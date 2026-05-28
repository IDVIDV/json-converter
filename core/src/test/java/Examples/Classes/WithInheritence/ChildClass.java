package Examples.Classes.WithInheritence;

import java.util.Objects;

public class ChildClass extends BaseClass {
    private String childField;

    public ChildClass() {
    }

    public ChildClass(int baseField, String childField) {
        super(baseField);
        this.childField = childField;
    }

    public String getChildField() {
        return childField;
    }

    public void setChildField(String childField) {
        this.childField = childField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ChildClass that = (ChildClass) o;
        return Objects.equals(getChildField(), that.getChildField());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getChildField());
    }
}
