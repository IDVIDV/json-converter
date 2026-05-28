package tests;

import example.serialization.Deserializer;
import example.serialization.Serializer;
import examples.Classes.Complex.ArrayInCollection;
import examples.Classes.Complex.CollectionInArray;
import examples.Classes.Complex.CollectionInCollection;
import examples.Classes.Complex.CollectionOfCollectionInArray;
import examples.Classes.Simple.MixedAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ComplexClassesTest {
    static Stream<Arguments> getComplexArgs() {
        Map<String, List<Class>> arrInColMap = new HashMap<>();
        arrInColMap.put("ArrayInCollectionlistOfArr", List.of(MixedAll[].class));

        Map<String, List<Class>> colInArrMap = new HashMap<>();
        colInArrMap.put("CollectionInArrayarrOfList", List.of(MixedAll.class));

        Map<String, List<Class>> colInColMap = new HashMap<>();
        colInColMap.put("CollectionInCollectionlistOfList", List.of(List.class, MixedAll.class));

        Map<String, List<Class>> colOfcolInArrMap = new HashMap<>();
        colOfcolInArrMap.put("CollectionOfCollectionInArraylist", List.of(List[].class, MixedAll.class));

        return Stream.of(
                Arguments.of(new ArrayInCollection(), arrInColMap),
                Arguments.of(new CollectionInArray(), colInArrMap),
                Arguments.of(new CollectionInCollection(), colInColMap),
                Arguments.of(new CollectionOfCollectionInArray(), colOfcolInArrMap)
        );
    }

    @ParameterizedTest
    @MethodSource("getComplexArgs")
    void serializeAndDeserializeTest(Object obj, Map<String, List<Class>> mapper) {
        Serializer serializer = new Serializer();
        Deserializer deserializer = new Deserializer(mapper);

        String jsonString = serializer.serialize(obj);
        Object deserializedObj = deserializer.deserializeObj(obj.getClass(), jsonString);

        Assertions.assertEquals(obj, deserializedObj);
    }
}
