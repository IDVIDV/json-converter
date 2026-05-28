package Example.Serialization;

import Example.Exceptions.DeserializeException;
import Example.Util.EscSymbDeserializer;
import Example.Util.FileReader;
import Example.Util.WrappedPrimitiveUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;


public class Deserializer {

    private static final Logger LOGGER = LogManager.getLogger();

    //Мап для восстановления типов полей-коллекций (коллекции могут быть вложенными)
    private final Map<String, List<Class>> fieldInnerTypes;
    private final FileReader fileReader;

    public Deserializer(Map<String, List<Class>> collFieldTypes) {
        this.fieldInnerTypes = collFieldTypes;
        this.fileReader = new FileReader();
    }

    public Deserializer() {
        this.fieldInnerTypes = Collections.EMPTY_MAP;
        this.fileReader = new FileReader();
    }

    public Deserializer(FileReader fileReader) {
        this.fieldInnerTypes = Collections.EMPTY_MAP;
        this.fileReader = fileReader;
    }

    public Object deserializeObjFile(Class objType, Path file) {
        try {
            return deserializeObj(objType, fileReader.readFile(file));
        } catch (IOException e) {
            LOGGER.error("Failed to read from file", e);
        }

        return null;
    }

    //Десериализовать объект
    public Object deserializeObj(Class objType, String jsonString) {
        if (objType == null || objType.isPrimitive() || WrappedPrimitiveUtils.isWrappedPrimitive(objType) || objType.isArray()
                || objType.isEnum() || objType == String.class || Collection.class.isAssignableFrom(objType)) {
            throw new DeserializeException("Попытка десериализации неправильного типа");
        }

        Iterator<String> jsonIt = getJsonIt(jsonString);

        if (jsonIt.hasNext()) {
            jsonIt.next();
            return deserializeValue(objType, "", null, jsonIt);
        }

        return null;
    }

    //Десериализовать JSON массив
    public Object deserializeBuffer(Class bufferType, List<Class> innerTypes, String jsonString) {
        if (!bufferType.isArray() && !Collection.class.isAssignableFrom(bufferType)) {
            throw new DeserializeException("Попытка десериализации неправильного типа");
        }

        Iterator<String> jsonIt = getJsonIt(jsonString);

        if (jsonIt.hasNext()) {
            jsonIt.next();
            return deserializeValue(bufferType, "", innerTypes, jsonIt);
        }

        return null;
    }

    //Десериализация значения из преобразованной строки-значения
    private Object deserializeValue(Class valueType, String valueStr, List<Class> innerTypes, Iterator<String> jsonIt) {
        if (valueStr.equals("null")) {
            return null;
        }

        if (WrappedPrimitiveUtils.wrappedFromUnknown(valueType) == Character.class) {
            String desStrValue = EscSymbDeserializer.deserializeWithEsc(valueStr.substring(1, valueStr.length() - 1));
            return WrappedPrimitiveUtils.getWrappedFromStr(valueType, desStrValue);
        }

        if (valueType == String.class) {
            return EscSymbDeserializer.deserializeWithEsc(valueStr.substring(1, valueStr.length() - 1));
        }

        if (valueType.isEnum()) {
            return Enum.valueOf(valueType, valueStr.substring(1, valueStr.length() - 1));
        }

        if (valueType.isPrimitive() || WrappedPrimitiveUtils.isWrappedPrimitive(valueType)) {
            return WrappedPrimitiveUtils.getWrappedFromStr(valueType, valueStr);
        }

        if (valueType.isArray() || Collection.class.isAssignableFrom(valueType)) {
            return deserializeBuffer(valueType, innerTypes, jsonIt);
        }

        return deserializeComplex(valueType, jsonIt);
    }

    //Десериализация массива значений (сбор значений)
    private Object deserializeBuffer(Class bufferType, List<Class> innerTypes, Iterator<String> jsonIt) {
        String curLine;
        Collection collectedValues = new ArrayList();
        Class topInnerType;
        List<Class> bottomInnerTypes;

        if (bufferType.isArray()) {
            topInnerType = bufferType.getComponentType();
            bottomInnerTypes = innerTypes;
        } else {
            topInnerType = innerTypes.get(0);
            bottomInnerTypes = innerTypes.subList(1, innerTypes.size());
        }

        while (jsonIt.hasNext()) {
            curLine = jsonIt.next();
            if (curLine.equals("]") || curLine.equals("],")) {
                break;
            }

            String valueStr = getValueStr(curLine, -1);

            collectedValues.add(deserializeValue(topInnerType, valueStr, bottomInnerTypes, jsonIt));
        }

        return decideBufferType(bufferType, collectedValues);
    }

    //Десериализация массива (определение типа массива/коллекции (тип задается извне с помощью мапа))
    private Object decideBufferType(Class bufferType, Collection collectedValues) {

        if (bufferType.isArray()) {
            Object arrObj = Array.newInstance(bufferType.getComponentType(), collectedValues.size());
            Iterator colValIt = collectedValues.iterator();
            int i = 0;
            while (colValIt.hasNext()) {
                Array.set(arrObj, i, colValIt.next());
                i++;
            }
            return arrObj;
        }

        if (bufferType.isInterface()) {
            if (Set.class.isAssignableFrom(bufferType)) {
                return new TreeSet(collectedValues);
            } else if (Queue.class.isAssignableFrom(bufferType)) {
                return new ArrayDeque(collectedValues);
            } else {
                return new ArrayList(collectedValues);
            }
        }

        try {
            return bufferType.getConstructor(Collection.class).newInstance(collectedValues);
        } catch (InstantiationException | IllegalAccessException
                 | InvocationTargetException | NoSuchMethodException e) {
            throw new DeserializeException("Не найден конструктор для внутренней коллекции", e);
        }
    }

    //Преобразование в объект
    private Object deserializeComplex(Class objType, Iterator<String> jsonIt) {
        Object obj;
        Field field;
        String curLine;

        try {
            obj = objType.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException |
                 InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        while (jsonIt.hasNext()) {
            curLine = jsonIt.next();

            if (curLine.equals("}") || curLine.equals("},")) {
                break;
            }

            int separatorIndex = curLine.indexOf(":");
            String fieldStr = getFieldStr(curLine, separatorIndex);
            String valueStr = getValueStr(curLine, separatorIndex);

            try {
                field = getFieldByName(objType, fieldStr);
            } catch (NoSuchFieldException e) {
                throw new DeserializeException("Не найдено поле с именем " + fieldStr, e);
            }

            if (field.trySetAccessible()) {
                try {
                    field.set(obj, deserializeValue(field.getType(), valueStr,
                            fieldInnerTypes.get(objType.getSimpleName() + fieldStr), jsonIt));
                } catch (IllegalAccessException e) {
                    throw new DeserializeException("Поле " + fieldStr + " не доступно для записи", e);
                }
            }
        }
        return obj;
    }

    //Получение строки с именем поля
    private String getFieldStr(String jsonLine, int separatorIndex) {
        String fieldStr = jsonLine.substring(0, separatorIndex).trim();
        return fieldStr.substring(1, fieldStr.length() - 1);
    }

    //Получение строки, отражающей значение поля
    private String getValueStr(String jsonLine, int separatorIndex) {
        String valueStr = jsonLine.substring(separatorIndex + 1).trim();

        if (valueStr.endsWith(",")) {
            valueStr = valueStr.substring(0, valueStr.length() - 1);
        }

        return valueStr;
    }

    //Вытаскивание поля по его имени
    private Field getFieldByName(Class<?> objType, String fieldStr) throws NoSuchFieldException {
        Class superType = objType;
        while (superType != null) {
            try {
                return superType.getDeclaredField(fieldStr);
            } catch (NoSuchFieldException e) {
                superType = superType.getSuperclass();
            }
        }
        throw new NoSuchFieldException(fieldStr);
    }

    //Преобразование полученной json строки в массив строк
    private Iterator<String> getJsonIt(String jsonString) {
        return jsonString.lines().map(String::trim).toList().iterator();
    }
}