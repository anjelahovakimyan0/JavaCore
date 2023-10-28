package classwork.lesson24;

public enum Language {

    HY("Հայերեն"),
    RU,
    ENG("English");

    private String languageName;

    Language() {
    }

    Language(String languageName) {
        this.languageName = languageName;
    }

    public String getLanguageName() {
        return languageName;
    }
}
