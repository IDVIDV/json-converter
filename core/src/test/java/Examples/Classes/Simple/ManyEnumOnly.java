package Examples.Classes.Simple;

import Examples.Enums.Color;
import Examples.Enums.Language;
import java.util.Objects;

public class ManyEnumOnly {
    private Color color;
    private Language language;

    public ManyEnumOnly() {
    }

    public ManyEnumOnly(Color color, Language language) {
        this.color = color;
        this.language = language;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManyEnumOnly that = (ManyEnumOnly) o;
        return color == that.color && language == that.language;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, language);
    }
}
