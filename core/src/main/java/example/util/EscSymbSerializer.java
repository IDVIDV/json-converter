package example.util;

import java.util.HashMap;
import java.util.Map;

public class EscSymbSerializer {
    private static final Map<Character, String> escSerializeMap;

    static {
        escSerializeMap = new HashMap<>();
        escSerializeMap.put('\"', "\\\"");
        escSerializeMap.put('\\', "\\\\");
        escSerializeMap.put('/', "\\/");
        escSerializeMap.put('\b', "\\b");
        escSerializeMap.put('\f', "\\f");
        escSerializeMap.put('\n', "\\n");
        escSerializeMap.put('\r', "\\r");
        escSerializeMap.put('\t', "\\t");
    }

    public static String serializeWithEsc(Object obj) {

        if (obj.getClass() == Character.class) {
            return serializeWithEsc((Character) obj);
        }

        if (obj.getClass() == String.class) {
            return serializeWithEsc((String) obj);
        }

        return serializeWithEsc((char) obj);
    }

    public static String serializeWithEsc(String str) {
        StringBuilder strBuilder = new StringBuilder();
        char[] chars = str.toCharArray();

        for (char c : chars) {
            if (escSerializeMap.containsKey(c)) {
                strBuilder.append(escSerializeMap.get(c));
            } else {
                strBuilder.append(c);
            }
        }

        return strBuilder.toString();
    }

    public static String serializeWithEsc(char c) {
        if (escSerializeMap.containsKey(c)) {
            return escSerializeMap.get(c);
        } else {
            return String.valueOf(c);
        }
    }

    public static String serializeWithEsc(Character c) {
        if (escSerializeMap.containsKey(c)) {
            return escSerializeMap.get(c);
        } else {
            return c.toString();
        }
    }
}
