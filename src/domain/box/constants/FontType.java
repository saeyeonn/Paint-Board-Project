package domain.box.constants;

public enum FontType {
    ARIAL("Arial"),
    SERIF("Serif"),
    TIMES("Times"),
    ROMAN("Roman");

    private final String name;

    FontType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
