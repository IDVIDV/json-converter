package Tests;

import Example.Serialization.Deserializer;
import Example.Serialization.Serializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OtherDeserializersTest {

    @Test
    void serializeAndDeserializeCollectionTest() {
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(null);
        intList.add(3);

        Serializer serializer = new Serializer();
        Deserializer deserializer = new Deserializer();

        String jsonString = serializer.serialize(intList);
        Object deserializedList = deserializer.deserializeBuffer(intList.getClass(), List.of(Integer.class), jsonString);

        Assertions.assertEquals(intList, deserializedList);
    }

    @Test
    void serializeAndDeserializeSimpleArrayTest() {
        Integer[] intArr = new Integer[3];
        intArr[0] = 1;
        intArr[1] = null;
        intArr[2] = 1;

        Serializer serializer = new Serializer();
        Deserializer deserializer = new Deserializer();

        String jsonString = serializer.serialize(intArr);
        Object deserializedArr = deserializer.deserializeBuffer(intArr.getClass(), null, jsonString);

        Assertions.assertTrue(Arrays.equals(intArr, (Integer[]) deserializedArr));
    }

    @Test
    void serializeAndDeserializeCollectionArrayTest() {
        List<Integer>[] listArr = new List[3];

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(null);

        List<Integer> list2 = new ArrayList<>();

        listArr[0] = list1;
        listArr[1] = null;
        listArr[2] = list2;

        Serializer serializer = new Serializer();
        Deserializer deserializer = new Deserializer();

        String jsonString = serializer.serialize(listArr);
        Object deserializedArr = deserializer.deserializeBuffer(listArr.getClass(), List.of(Integer.class), jsonString);

        Assertions.assertTrue(Arrays.equals(listArr, (List<Integer>[]) deserializedArr));
    }
}
