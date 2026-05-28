package Tests;

import Example.Serialization.Deserializer;
import Example.Serialization.Serializer;
import Examples.Classes.Simple.ClassWithClassFields;
import Examples.Classes.Simple.EscapeSymbols;
import Examples.Classes.Simple.ManyEnumOnly;
import Examples.Classes.Simple.ManyStringOnly;
import Examples.Classes.Simple.MixedAll;
import Examples.Classes.Simple.MixedPrimWrap;
import Examples.Classes.Simple.OneEnumOnly;
import Examples.Classes.Simple.OneStringOnly;
import Examples.Classes.Simple.PrimitiveOnly;
import Examples.Classes.Simple.SuperSimple;
import Examples.Classes.Simple.WrappedOnly;
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
