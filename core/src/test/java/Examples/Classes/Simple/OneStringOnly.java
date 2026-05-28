package Examples.Classes.Simple;

import java.util.Objects;

public class OneStringOnly {
    private String stringField;

    public OneStringOnly() {
    }

    public OneStringOnly(String stringField) {
        this.stringField = stringField;
    }

    public String getStringField() {
        return stringField;
    }

    public void setStringField(String stringField) {
        this.stringField = stringField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OneStringOnly that = (OneStringOnly) o;
        return Objects.equals(stringField, that.stringField);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stringField);
    }
}
