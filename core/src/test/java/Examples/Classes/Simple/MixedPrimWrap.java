package Examples.Classes.Simple;

import java.util.Objects;

public class MixedPrimWrap {
    public Integer wrapIntField;
    public int primIntField;
    public float primFloatField;
    public Boolean wrapBoolField;
    private boolean primBoolField;
    private Float wrapFloatField;
    private long primLongField;
    private Long wrapLongField;

    public MixedPrimWrap() {
    }

    public MixedPrimWrap(Integer wrapIntField, int primIntField,
                         float primFloatField, Boolean wrapBoolField,
                         boolean primBoolField, Float wrapFloatField,
                         long primLongField, Long wrapLongField) {
        this.wrapIntField = wrapIntField;
        this.primIntField = primIntField;
        this.primFloatField = primFloatField;
        this.wrapBoolField = wrapBoolField;
        this.primBoolField = primBoolField;
        this.wrapFloatField = wrapFloatField;
        this.primLongField = primLongField;
        this.wrapLongField = wrapLongField;
    }

    public Integer getWrapIntField() {
        return wrapIntField;
    }

    public void setWrapIntField(Integer wrapIntField) {
        this.wrapIntField = wrapIntField;
    }

    public int getPrimIntField() {
        return primIntField;
    }

    public void setPrimIntField(int primIntField) {
        this.primIntField = primIntField;
    }

    public float getPrimFloatField() {
        return primFloatField;
    }

    public void setPrimFloatField(float primFloatField) {
        this.primFloatField = primFloatField;
    }

    public Boolean getWrapBoolField() {
        return wrapBoolField;
    }

    public void setWrapBoolField(Boolean wrapBoolField) {
        this.wrapBoolField = wrapBoolField;
    }

    public boolean isPrimBoolField() {
        return primBoolField;
    }

    public void setPrimBoolField(boolean primBoolField) {
        this.primBoolField = primBoolField;
    }

    public Float getWrapFloatField() {
        return wrapFloatField;
    }

    public void setWrapFloatField(Float wrapFloatField) {
        this.wrapFloatField = wrapFloatField;
    }

    public long getPrimLongField() {
        return primLongField;
    }

    public void setPrimLongField(long primLongField) {
        this.primLongField = primLongField;
    }

    public Long getWrapLongField() {
        return wrapLongField;
    }

    public void setWrapLongField(Long wrapLongField) {
        this.wrapLongField = wrapLongField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MixedPrimWrap mixed = (MixedPrimWrap) o;
        return primIntField == mixed.primIntField
                && Float.compare(primFloatField, mixed.primFloatField) == 0
                && primBoolField == mixed.primBoolField
                && primLongField == mixed.primLongField
                && Objects.equals(wrapIntField, mixed.wrapIntField)
                && Objects.equals(wrapBoolField, mixed.wrapBoolField)
                && Objects.equals(wrapFloatField, mixed.wrapFloatField)
                && Objects.equals(wrapLongField, mixed.wrapLongField);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wrapIntField, primIntField, primFloatField, wrapBoolField, primBoolField, wrapFloatField, primLongField, wrapLongField);
    }
}
