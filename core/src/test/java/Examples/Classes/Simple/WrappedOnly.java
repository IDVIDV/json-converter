package Examples.Classes.Simple;

import java.util.Objects;

public class WrappedOnly {
    public Character charField;
    public Float floatField;
    public Long longField;
    private Integer intField;
    private Double doubleField;
    private Boolean booleanField;
    private Short shortField;
    private Byte byteField;

    public WrappedOnly() {
    }

    public WrappedOnly(Character charField, Float floatField,
                       Long longField, Integer intField,
                       Double doubleField, Boolean booleanField,
                       Short shortField, Byte byteField) {
        this.charField = charField;
        this.floatField = floatField;
        this.longField = longField;
        this.intField = intField;
        this.doubleField = doubleField;
        this.booleanField = booleanField;
        this.shortField = shortField;
        this.byteField = byteField;
    }

    public Character getCharField() {
        return charField;
    }

    public void setCharField(Character charField) {
        this.charField = charField;
    }

    public Float getFloatField() {
        return floatField;
    }

    public void setFloatField(Float floatField) {
        this.floatField = floatField;
    }

    public Long getLongField() {
        return longField;
    }

    public void setLongField(Long longField) {
        this.longField = longField;
    }

    public Integer getIntField() {
        return intField;
    }

    public void setIntField(Integer intField) {
        this.intField = intField;
    }

    public Double getDoubleField() {
        return doubleField;
    }

    public void setDoubleField(Double doubleField) {
        this.doubleField = doubleField;
    }

    public Boolean getBooleanField() {
        return booleanField;
    }

    public void setBooleanField(Boolean booleanField) {
        this.booleanField = booleanField;
    }

    public Short getShortField() {
        return shortField;
    }

    public void setShortField(Short shortField) {
        this.shortField = shortField;
    }

    public Byte getByteField() {
        return byteField;
    }

    public void setByteField(Byte byteField) {
        this.byteField = byteField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WrappedOnly that = (WrappedOnly) o;
        return Objects.equals(charField, that.charField)
                && Objects.equals(floatField, that.floatField)
                && Objects.equals(longField, that.longField)
                && Objects.equals(intField, that.intField)
                && Objects.equals(doubleField, that.doubleField)
                && Objects.equals(booleanField, that.booleanField)
                && Objects.equals(shortField, that.shortField)
                && Objects.equals(byteField, that.byteField);
    }

    @Override
    public int hashCode() {
        return Objects.hash(charField, floatField, longField, intField, doubleField, booleanField, shortField, byteField);
    }
}
