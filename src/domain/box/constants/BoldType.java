package domain.box.constants;

public enum BoldType {
    SIZE_1("1pt"),
    SIZE_3("3pt"),
    SIZE_6("6pt"),
    SIZE_9("9pt");


    private final String name;

    BoldType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
