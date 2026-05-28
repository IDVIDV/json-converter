package Examples.Classes.Simple;

import Examples.Enums.Color;
import Examples.Enums.Language;
import java.util.Objects;

public class MixedAll {
    private String firstStringField;
    private Color color;
    private Integer integerField;
    private Language language;
    private String secondStringField;
    private int intField;

    public MixedAll() {
    }

    public MixedAll(String firstStringField, Color color,
                    Integer integerField, Language language,
                    String secondStringField, int intField) {
        this.firstStringField = firstStringField;
        this.color = color;
        this.integerField = integerField;
        this.language = language;
        this.secondStringField = secondStringField;
        this.intField = intField;
    }

    public String getFirstStringField() {
        return firstStringField;
    }

    public void setFirstStringField(String firstStringField) {
        this.firstStringField = firstStringField;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Integer getIntegerField() {
        return integerField;
    }

    public void setIntegerField(Integer integerField) {
        this.integerField = integerField;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getSecondStringField() {
        return secondStringField;
    }

    public void setSecondStringField(String secondStringField) {
        this.secondStringField = secondStringField;
    }

    public int getIntField() {
        return intField;
    }

    public void setIntField(int intField) {
        this.intField = intField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MixedAll mixedAll = (MixedAll) o;
        return intField == mixedAll.intField
                && Objects.equals(firstStringField, mixedAll.firstStringField)
                && color == mixedAll.color
                && Objects.equals(integerField, mixedAll.integerField)
                && language == mixedAll.language
                && Objects.equals(secondStringField, mixedAll.secondStringField);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstStringField, color, integerField, language, secondStringField, intField);
    }
}
