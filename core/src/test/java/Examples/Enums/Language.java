package Examples.Enums;

public enum Language {
    RU("Russian"),
    EN("English");
    private final String language;

    Language(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }
}
