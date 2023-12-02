package window.box.constants;

public enum LineType {
    DOT("dot"),
    DASH("dash"),
    SOLID("solid");

    private String name;

    LineType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
