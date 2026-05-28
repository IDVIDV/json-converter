package Examples.Classes.Simple;

import Examples.Enums.Color;
import java.util.Objects;

public class OneEnumOnly {
    private Color color;

    public OneEnumOnly() {
    }

    public OneEnumOnly(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OneEnumOnly that = (OneEnumOnly) o;
        return color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }
}
