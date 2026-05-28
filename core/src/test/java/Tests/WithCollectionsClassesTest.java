package Tests;

import Example.Serialization.Deserializer;
import Example.Serialization.Serializer;
import Examples.Classes.Simple.MixedAll;
import Examples.Classes.WithCollections.CollectionNotInterface;
import Examples.Classes.WithCollections.CollectionObject;
import Examples.Classes.WithCollections.CollectionSimple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class WithCollectionsClassesTest {
    static Stream<Arguments> getCollectionArgs() {
        Map<String, List<Class>> simpleMap = new HashMap<>();
        simpleMap.put("CollectionSimplelistInteger", List.of(Integer.class));
        simpleMap.put("CollectionSimplequeueString", List.of(String.class));

        Map<String, List<Class>> objectMap = new HashMap<>();
        objectMap.put("CollectionObjectlistMixed", List.of(MixedAll.class));

        Map<String, List<Class>> notInterfaceColMap = new HashMap<>();
        notInterfaceColMap.put("CollectionNotInterfacearrList", List.of(MixedAll.class));
        notInterfaceColMap.put("CollectionNotInterfacelinkList", List.of(MixedAll.class));

        return Stream.of(
                Arguments.of(new CollectionSimple(), simpleMap),
                Arguments.of(new CollectionObject(), objectMap),
                Arguments.of(new CollectionNotInterface(), notInterfaceColMap)
        );
    }

    @ParameterizedTest
    @MethodSource("getCollectionArgs")
    void serializeAndDeserializeTest(Object obj, Map<String, List<Class>> mapper) {
        Serializer serializer = new Serializer();
        Deserializer deserializer = new Deserializer(mapper);

        String jsonString = serializer.serialize(obj);
        Object deserializedObj = deserializer.deserializeObj(obj.getClass(), jsonString);

        Assertions.assertEquals(obj, deserializedObj);
    }
}
