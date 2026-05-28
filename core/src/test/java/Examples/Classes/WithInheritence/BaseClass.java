package Examples.Classes.WithInheritence;

import java.util.Objects;

public class BaseClass {
    private int baseField;

    public BaseClass() {
    }

    public BaseClass(int baseField) {
        this.baseField = baseField;
    }

    public int getBaseField() {
        return baseField;
    }

    public void setBaseField(int baseField) {
        this.baseField = baseField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseClass baseClass = (BaseClass) o;
        return getBaseField() == baseClass.getBaseField();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBaseField());
    }
}
