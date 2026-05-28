package tests;

import example.serialization.Deserializer;
import example.serialization.Serializer;
import examples.Classes.WithSimpleArrays.ArrayObject;
import examples.Classes.WithSimpleArrays.ArraySimple;
import examples.Classes.WithSimpleArrays.MatrixObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class WithSimpleArraysClassesTest {
    static Stream<Arguments> getArrArgs() {
        return Stream.of(
                Arguments.of(new ArraySimple()),
                Arguments.of(new ArrayObject()),
                Arguments.of(new MatrixObject())
        );
    }

    @ParameterizedTest
    @MethodSource("getArrArgs")
    void serializeAndDeserializeTest(Object obj) {
        Serializer serializer = new Serializer();
        Deserializer deserializer = new Deserializer();

        String jsonString = serializer.serialize(obj);
        Object deserializedObj = deserializer.deserializeObj(obj.getClass(), jsonString);

        Assertions.assertEquals(obj, deserializedObj);
    }
}
