package domain.button.constants;

import java.util.Arrays;

public enum Color {
    RED("05_red"),
    YELLOW("06_yellow"),
    GREEN("07_green"),
    BLUE("09_blue"),
    BROWN("10_brown"),
    GREY("11_grey"),
    WHITE("13_white"),
    BLACK("14_black");

    private final String name;

    Color(String name) {
        this.name = name;
    }

    public static boolean isColorType(String name) {
        return Arrays.stream(Color.values())
                .anyMatch(value -> value.getName().equals(name));
    }

    public String getName() {
        return name;
    }
}
