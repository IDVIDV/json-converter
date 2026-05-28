package tests;

import example.exceptions.DeserializeException;
import example.exceptions.SerializeException;
import example.serialization.Deserializer;
import example.serialization.Serializer;
import examples.Enums.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class InvalidArgsTest {
    static Stream<Arguments> getIllegalArgs() {
        Integer integerObj = 1;
        double doubleObj = 2;
        return Stream.of(
                Arguments.of(integerObj),
                Arguments.of("String"),
                Arguments.of(Color.RED),
                Arguments.of(doubleObj)
        );
    }

    @ParameterizedTest
    @MethodSource("getIllegalArgs")
    void serializerThrowsIllegalArgumentException(Object arg) {
        Serializer serializer = new Serializer();

        Assertions.assertThrows(SerializeException.class, () -> serializer.serialize(arg));
    }

    @ParameterizedTest
    @MethodSource("getIllegalArgs")
    void deserializerThrowsIllegalArgumentException(Object arg) {
        Deserializer deserializer = new Deserializer();
        Class argType = arg.getClass();

        Assertions.assertThrows(DeserializeException.class, () -> deserializer.deserializeObj(argType, ""));
        Assertions.assertThrows(DeserializeException.class, () -> deserializer.deserializeBuffer(argType, null, ""));
    }
}
