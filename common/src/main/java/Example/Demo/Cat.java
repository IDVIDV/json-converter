package Example.Demo;

import java.util.Objects;

public class Cat {
    private String name;
    private int age;
    private Gender gender;
    private String breed;
    private boolean defertilized;

    public Cat() {
    }

    public Cat(String name, int age, Gender gender, String breed, boolean defertilized) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.breed = breed;
        this.defertilized = defertilized;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public boolean isDefertilized() {
        return defertilized;
    }

    public void setDefertilized(boolean defertilized) {
        this.defertilized = defertilized;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return age == cat.age && defertilized == cat.defertilized && Objects.equals(name, cat.name) && gender == cat.gender && Objects.equals(breed, cat.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender, breed, defertilized);
    }
}
