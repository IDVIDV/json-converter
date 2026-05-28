package Examples.Classes.Simple;

import java.util.Objects;

public class SuperSimple {
    private int intField;
    private double doubleField;

    public SuperSimple() {
        intField = 1;
        doubleField = 2.5;
    }

    public SuperSimple(int intField, double doubleField) {
        this.intField = intField;
        this.doubleField = doubleField;
    }

    public int getIntField() {
        return intField;
    }

    public void setIntField(int intField) {
        this.intField = intField;
    }

    public double getDoubleField() {
        return doubleField;
    }

    public void setDoubleField(double doubleField) {
        this.doubleField = doubleField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuperSimple that = (SuperSimple) o;
        return getIntField() == that.getIntField() && Double.compare(getDoubleField(), that.getDoubleField()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIntField(), getDoubleField());
    }
}
