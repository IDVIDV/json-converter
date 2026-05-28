package example.util;

import example.exceptions.GetValueFromStrException;

import java.lang.reflect.InvocationTargetException;

public class WrappedPrimitiveUtils {
    public static boolean isWrappedPrimitive(Class type) {
        return type == Double.class || type == Float.class || type == Long.class ||
                type == Integer.class || type == Short.class || type == Character.class ||
                type == Byte.class || type == Boolean.class || type == Void.class;
    }

    public static Class primitiveFromUnknown(Class wrappedOrPrimitiveType) {
        if (wrappedOrPrimitiveType.isPrimitive()) {
            return wrappedOrPrimitiveType;
        }

        if (wrappedOrPrimitiveType == Integer.class) {
            return Integer.TYPE;
        }

        if (wrappedOrPrimitiveType == Long.class) {
            return Long.TYPE;
        }

        if (wrappedOrPrimitiveType == Boolean.class) {
            return Boolean.TYPE;
        }

        if (wrappedOrPrimitiveType == Byte.class) {
            return Byte.TYPE;
        }

        if (wrappedOrPrimitiveType == Character.class) {
            return Character.TYPE;
        }

        if (wrappedOrPrimitiveType == Float.class) {
            return Float.TYPE;
        }

        if (wrappedOrPrimitiveType == Double.class) {
            return Double.TYPE;
        }

        if (wrappedOrPrimitiveType == Short.class) {
            return Short.TYPE;
        }

        if (wrappedOrPrimitiveType == Void.class) {
            return Void.TYPE;
        }

        return wrappedOrPrimitiveType;
    }

    public static Class wrappedFromUnknown(Class wrappedOrPrimitiveType) {
        if (!wrappedOrPrimitiveType.isPrimitive()) {
            return wrappedOrPrimitiveType;
        }

        if (wrappedOrPrimitiveType == Integer.TYPE) {
            return Integer.class;
        }

        if (wrappedOrPrimitiveType == Long.TYPE) {
            return Long.class;
        }

        if (wrappedOrPrimitiveType == Boolean.TYPE) {
            return Boolean.class;
        }

        if (wrappedOrPrimitiveType == Byte.TYPE) {
            return Byte.class;
        }

        if (wrappedOrPrimitiveType == Character.TYPE) {
            return Character.class;
        }

        if (wrappedOrPrimitiveType == Float.TYPE) {
            return Float.class;
        }

        if (wrappedOrPrimitiveType == Double.TYPE) {
            return Double.class;
        }

        if (wrappedOrPrimitiveType == Short.TYPE) {
            return Short.class;
        }

        if (wrappedOrPrimitiveType == Void.TYPE) {
            return Void.class;
        }

        return wrappedOrPrimitiveType;
    }

    public static Object getWrappedFromStr(Class wrappedOrPrimitiveType, String valueStr) {
        Class wrappedType = wrappedFromUnknown(wrappedOrPrimitiveType);
        Object tmp;
        try {
            tmp = wrappedType.getDeclaredMethod("valueOf", String.class).invoke(null, valueStr);
        } catch (NoSuchMethodException ex) {
            try {
                tmp = wrappedType.getDeclaredMethod("valueOf", char.class).invoke(null, valueStr.charAt(0));
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                throw new GetValueFromStrException("Не найден метод для преобразования",e);
            }
        } catch (InvocationTargetException | IllegalAccessException ex) {
            throw new GetValueFromStrException("Не найден метод для преобразования", ex);
        }
        return wrappedType.cast(tmp);
    }
}
