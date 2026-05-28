package tests;

import example.serialization.Deserializer;
import example.serialization.Serializer;
import examples.Classes.Simple.ClassWithClassFields;
import examples.Classes.Simple.EscapeSymbols;
import examples.Classes.Simple.ManyEnumOnly;
import examples.Classes.Simple.ManyStringOnly;
import examples.Classes.Simple.MixedAll;
import examples.Classes.Simple.MixedPrimWrap;
import examples.Classes.Simple.OneEnumOnly;
import examples.Classes.Simple.OneStringOnly;
import examples.Classes.Simple.PrimitiveOnly;
import examples.Classes.Simple.SuperSimple;
import examples.Classes.Simple.WrappedOnly;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SimpleClassesTest {

    static Stream<Arguments> getSimpleArgs() {
        return Stream.of(
                Arguments.of(new SuperSimple()),
                Arguments.of(new PrimitiveOnly()),
                Arguments.of(new WrappedOnly()),
                Arguments.of(new OneEnumOnly()),
                Arguments.of(new OneStringOnly()),
                Arguments.of(new ManyEnumOnly()),
                Arguments.of(new ManyStringOnly()),
                Arguments.of(new MixedPrimWrap()),
                Arguments.of(new MixedAll()),
                Arguments.of(new ClassWithClassFields()),
                Arguments.of(new EscapeSymbols())
        );
    }

    @ParameterizedTest
    @MethodSource("getSimpleArgs")
    void serializeAndDeserializeTest(Object obj) {
        Serializer serializer = new Serializer();
        Deserializer deserializer = new Deserializer();

        String jsonString = serializer.serialize(obj);
        Object deserializedObj = deserializer.deserializeObj(obj.getClass(), jsonString);

        Assertions.assertEquals(obj, deserializedObj);
    }
}
