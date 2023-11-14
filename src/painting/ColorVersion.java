package painting;

import button.Function;

import java.awt.*;

public enum ColorVersion {
    RED("red", Color.RED, Function.COLOR_VERSION),
    YELLOW("yellow", Color.YELLOW, Function.COLOR_VERSION),
    GREEN("green", Color.GREEN, Function.COLOR_VERSION),
    BLUE("rgb", Color.BLUE, Function.COLOR_VERSION),
    BROWN("rgb", Color.getHSBColor(30.0F, 1.0F, 0.588F), Function.COLOR_VERSION),
    GREY("rgb", Color.GRAY, Function.COLOR_VERSION),
    WHITE("rgb", Color.WHITE, Function.COLOR_VERSION),
    BLACK("rgb", Color.BLACK, Function.COLOR_VERSION),
    CUSTOM("rgb", null, Function.COLOR_VERSION);


    private final String name;
    private final Color colorCode;
    private final Function function;

    ColorVersion(String name, Color colorCode, Function function) {
        this.name = name;
        this.colorCode = colorCode;
        this.function = function;
    }

    public String getName() {
        return name;
    }
    public Color getColorCode(){
        return colorCode;
    }

    public Function function() {
        return function;
    }
}
