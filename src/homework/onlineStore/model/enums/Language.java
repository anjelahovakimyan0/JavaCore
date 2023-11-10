package homework.onlineStore.model.enums;

public enum Language {

    HY("Հայերեն"),
    RU,
    ENG("English"),
    FR;

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
