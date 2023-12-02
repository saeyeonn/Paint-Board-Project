package domain.box.constants;

public enum LineType {
    DOT("dot"),
    DASH("dash"),
    SOLID("solid");

    private final String name;

    LineType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
