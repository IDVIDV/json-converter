package example.util;

import java.util.HashMap;
import java.util.Map;

public class EscSymbDeserializer {
    private static final Map<Character, Character> escDeserializeMap;

    static {
        escDeserializeMap = new HashMap<>();
        escDeserializeMap.put('\"', '\"');
        escDeserializeMap.put('\\', '\\');
        escDeserializeMap.put('/', '/');
        escDeserializeMap.put('b', '\b');
        escDeserializeMap.put('f', '\f');
        escDeserializeMap.put('n', '\n');
        escDeserializeMap.put('r', '\r');
        escDeserializeMap.put('t', '\t');
    }

    public static String deserializeWithEsc(String str) {
        char[] charArr = str.toCharArray();
        StringBuilder deserStrBuilder = new StringBuilder();

        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == '\\') {
                i++;
                deserStrBuilder.append(escDeserializeMap.get(charArr[i]));
            } else {
                deserStrBuilder.append(charArr[i]);
            }
        }

        return deserStrBuilder.toString();
    }
}
