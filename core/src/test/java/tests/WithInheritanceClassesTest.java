package tests;

import example.serialization.Deserializer;
import example.serialization.Serializer;
import examples.Classes.WithInheritence.BaseClass;
import examples.Classes.WithInheritence.ChildClass;
import examples.Classes.WithInheritence.ChildOfChildClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class WithInheritanceClassesTest {
    static Stream<Arguments> getInheritanceArgs() {
        return Stream.of(
                Arguments.of(new BaseClass()),
                Arguments.of(new ChildClass()),
                Arguments.of(new ChildOfChildClass())
        );
    }

    @ParameterizedTest
    @MethodSource("getInheritanceArgs")
    void serializeAndDeserializeTest(Object obj) {
        Serializer serializer = new Serializer();
        Deserializer deserializer = new Deserializer();

        String jsonString = serializer.serialize(obj);
        Object deserializedObj = deserializer.deserializeObj(obj.getClass(), jsonString);

        Assertions.assertEquals(obj, deserializedObj);
    }
}
