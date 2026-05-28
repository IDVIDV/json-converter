package Examples.Classes.Simple;

import java.util.Objects;

public class PrimitiveOnly {
    public char charField;
    public float floatField;
    public long longField;
    private int intField;
    private double doubleField;
    private boolean booleanField;
    private short shortField;
    private byte byteField;

    public PrimitiveOnly() {
    }

    public PrimitiveOnly(char charField, float floatField,
                         long longField, int intField,
                         double doubleField, boolean booleanField,
                         short shortField, byte byteField) {
        this.charField = charField;
        this.floatField = floatField;
        this.longField = longField;
        this.intField = intField;
        this.doubleField = doubleField;
        this.booleanField = booleanField;
        this.shortField = shortField;
        this.byteField = byteField;
    }

    public char getCharField() {
        return charField;
    }

    public void setCharField(char charField) {
        this.charField = charField;
    }

    public float getFloatField() {
        return floatField;
    }

    public void setFloatField(float floatField) {
        this.floatField = floatField;
    }

    public long getLongField() {
        return longField;
    }

    public void setLongField(long longField) {
        this.longField = longField;
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

    public boolean isBooleanField() {
        return booleanField;
    }

    public void setBooleanField(boolean booleanField) {
        this.booleanField = booleanField;
    }

    public short getShortField() {
        return shortField;
    }

    public void setShortField(short shortField) {
        this.shortField = shortField;
    }

    public byte getByteField() {
        return byteField;
    }

    public void setByteField(byte byteField) {
        this.byteField = byteField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrimitiveOnly that = (PrimitiveOnly) o;
        return charField == that.charField
                && Float.compare(floatField, that.floatField) == 0
                && longField == that.longField
                && intField == that.intField
                && Double.compare(doubleField, that.doubleField) == 0
                && booleanField == that.booleanField
                && shortField == that.shortField
                && byteField == that.byteField;
    }

    @Override
    public int hashCode() {
        return Objects.hash(charField, floatField, longField, intField, doubleField, booleanField, shortField, byteField);
    }
}
