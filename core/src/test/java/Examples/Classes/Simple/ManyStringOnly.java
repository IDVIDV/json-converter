package Examples.Classes.Simple;

import java.util.Objects;

public class ManyStringOnly {
    private String firstStringField;
    private String secondStringField;

    public ManyStringOnly() {
    }

    public ManyStringOnly(String firstStringField, String secondStringField) {
        this.firstStringField = firstStringField;
        this.secondStringField = secondStringField;
    }

    public String getFirstStringField() {
        return firstStringField;
    }

    public void setFirstStringField(String firstStringField) {
        this.firstStringField = firstStringField;
    }

    public String getSecondStringField() {
        return secondStringField;
    }

    public void setSecondStringField(String secondStringField) {
        this.secondStringField = secondStringField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManyStringOnly that = (ManyStringOnly) o;
        return Objects.equals(firstStringField, that.firstStringField) && Objects.equals(secondStringField, that.secondStringField);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstStringField, secondStringField);
    }
}
