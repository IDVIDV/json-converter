package example.serialization;

import example.exceptions.SerializeException;
import example.util.EscSymbSerializer;
import example.util.WrappedPrimitiveUtils;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Serializer {

    public String serialize(Object obj) {
        Class type = obj.getClass();
        if (type.isPrimitive() || WrappedPrimitiveUtils.isWrappedPrimitive(type)
                || type.isEnum() || type == String.class) {
            throw new SerializeException("Попытка сериализации неправильного объекта");
        }

        return serializeValue(obj, obj.getClass(), 0);
    }

    private String serializeValue(Object value, Class valueType, int indentCount) {
        if (value == null) {
            return "null";
        }

        if (valueType.isEnum() || valueType == String.class
                || WrappedPrimitiveUtils.wrappedFromUnknown(valueType) == Character.class) {
            return serializeStringCharEnum(value);
        }

        if (valueType.isPrimitive() || WrappedPrimitiveUtils.isWrappedPrimitive(valueType)) {
            return value.toString();
        }

        if (Collection.class.isAssignableFrom(valueType)) {
            return serializeCollection(value, indentCount);
        }

        if (valueType.isArray()) {
            return serializeArray(value, indentCount);
        }

        return serializeComplex(value, indentCount);
    }

    private String serializeStringCharEnum(Object obj) {
        StringBuilder jsonStrBuilder = new StringBuilder();
        String transformedStr;

        if (obj.getClass().isEnum()) {
            transformedStr = obj.toString();
        } else {
            transformedStr = EscSymbSerializer.serializeWithEsc(obj);
        }

        return jsonStrBuilder
                .append("\"")
                .append(transformedStr)
                .append("\"")
                .toString();
    }

    private String serializeCollection(Object collObj, int indentCount) {
        Collection collection = ((Collection) collObj);

        if (collection.isEmpty()) {
            return serializeArray(new Object[0], indentCount);
        }

        String indentStr = getIndentStr(indentCount);
        StringBuilder jsonStrBuilder = new StringBuilder("[");

        Class componentType = collection.iterator().next().getClass();

        collection.forEach(item -> jsonStrBuilder
                .append("\n")
                .append(indentStr)
                .append("  ")
                .append(serializeValue(item, componentType, indentCount + 2))
                .append(","));

        return jsonStrBuilder
                .deleteCharAt(jsonStrBuilder.length() - 1)
                .append("\n")
                .append(indentStr)
                .append("]")
                .toString();
    }

    private String serializeArray(Object arrObj, int indentCount) {
        String indentStr = getIndentStr(indentCount);
        StringBuilder jsonStrBuilder = new StringBuilder("[");

        Class componentType = arrObj.getClass().getComponentType();
        int arrLength = Array.getLength(arrObj);

        for (int i = 0; i < arrLength; ++i) {
            jsonStrBuilder
                    .append("\n")
                    .append(indentStr)
                    .append("  ")
                    .append(serializeValue(Array.get(arrObj, i), componentType, indentCount + 2))
                    .append(",");
        }

        if (arrLength != 0) {
            jsonStrBuilder.deleteCharAt(jsonStrBuilder.length() - 1);
        }

        return jsonStrBuilder
                .append("\n")
                .append(indentStr)
                .append("]")
                .toString();
    }

    private String serializeComplex(Object obj, int indentCount) {
        String indentStr = getIndentStr(indentCount);
        StringBuilder jsonStrBuilder = new StringBuilder("{");

        Class type = obj.getClass();
        List<Field> fields = getAllFields(type);

        for (Field field : fields) {
            if (field.trySetAccessible()) {
                jsonStrBuilder
                        .append("\n")
                        .append(indentStr)
                        .append("  \"")
                        .append(field.getName())
                        .append("\" : ");

                try {
                    jsonStrBuilder.append(serializeValue(field.get(obj), field.getType(), indentCount + 2));
                } catch (IllegalAccessException e) {
                    throw new SerializeException("Поле " + field.getName() + " не доступно для чтения", e);
                }

                jsonStrBuilder.append(",");
            }
        }

        if (!fields.isEmpty()) {
            jsonStrBuilder.deleteCharAt(jsonStrBuilder.length() - 1);
        }

        return jsonStrBuilder
                .append("\n")
                .append(indentStr)
                .append("}")
                .toString();
    }

    private String getIndentStr(int indentCount) {
        return " ".repeat(indentCount);
    }

    private List<Field> getAllFields(Class type) {
        List<Field> fields = new ArrayList<>();

        for (Class superType = type; superType != null; superType = superType.getSuperclass()) {
            fields.addAll(Arrays.stream(superType.getDeclaredFields()).toList());
        }

        return fields;
    }
}
