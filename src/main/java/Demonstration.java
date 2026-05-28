import Serialization.Deserializer;
import Serialization.Serializer;
import Example.Cat;
import Example.Gender;

// Разработать сериализатор/десериализатор POJO в JSON с помощью АОП

public class Demonstration {
    public static void main(String[] args) {
        Cat cat = new Cat("Матроскин", 10, Gender.MALE, null, false);

        Serializer serializer = new Serializer();
        Deserializer deserializer = new Deserializer();


        String jsonString = serializer.serialize(cat);

        System.out.println("Объект в формате JSON:");
        System.out.println(jsonString);

        Cat deserializedCat = (Cat) deserializer.deserializeObj(Cat.class, jsonString);
        jsonString = serializer.serialize(deserializedCat);
        System.out.println("Десериализованный объект в формате JSON:");
        System.out.println(jsonString);

        System.out.println("Десериализованный объект совпадает с изначальным?");
        System.out.println(cat.equals(deserializedCat));

        Cat cat2 = new Cat("Мурка", 15, Gender.FEMALE, null, true);
        String jsonString2 = serializer.serialize(cat2);

        System.out.println("Объект в формате JSON:");
        System.out.println(jsonString2);

        Cat deserializedCat2 = (Cat) deserializer.deserializeObj(Cat.class, jsonString2);
        jsonString = serializer.serialize(deserializedCat2);
        System.out.println("Десериализованный объект в формате JSON:");
        System.out.println(jsonString2);

        System.out.println("Десериализованный объект совпадает с изначальным?");
        System.out.println(cat2.equals(deserializedCat2));
    }
}