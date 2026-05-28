package Examples.Enums;

public enum Color {
    RED("Red"),
    BLUE("Blue"),
    GREEN("Green");
    private final String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
