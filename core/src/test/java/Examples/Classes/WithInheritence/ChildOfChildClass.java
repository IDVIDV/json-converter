package Examples.Classes.WithInheritence;

import java.util.Objects;

public class ChildOfChildClass extends ChildClass{
    private String childChildField;

    public ChildOfChildClass() {
    }

    public ChildOfChildClass(int baseField, String childField, String childChildField) {
        super(baseField, childField);
        this.childChildField = childChildField;
    }

    public String getChildChildField() {
        return childChildField;
    }

    public void setChildChildField(String childChildField) {
        this.childChildField = childChildField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ChildOfChildClass that = (ChildOfChildClass) o;
        return Objects.equals(getChildChildField(), that.getChildChildField());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getChildChildField());
    }
}
