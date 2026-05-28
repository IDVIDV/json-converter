package Examples.Classes.Simple;

import java.util.Objects;

public class ClassWithClassFields {
    private MixedAll classField1;
    private SuperSimple classField2;

    public ClassWithClassFields() {
        classField1 = new MixedAll();
        classField2 = new SuperSimple();
    }

    public ClassWithClassFields(MixedAll classField1, SuperSimple classField2) {
        this.classField1 = classField1;
        this.classField2 = classField2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassWithClassFields that = (ClassWithClassFields) o;
        return Objects.equals(classField1, that.classField1) && Objects.equals(classField2, that.classField2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classField1, classField2);
    }
}
