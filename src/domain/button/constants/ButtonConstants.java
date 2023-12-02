package domain.button.constants;

import java.util.Arrays;

import static domain.button.constants.ButtonUtilityType.*;

public enum ButtonConstants {
    REDO("redo", ACTION),
    UNDO("undo", ACTION),
    ZOOM_IN("zoomIn", ACTION),
    ZOOM_OUT("zoomOut", ACTION),
    SAVE("01_save", ACTION),
    OPEN("02_open", ACTION),
    GROUP("03_group", SELECTION),
    UNGROUP("04_ungroup", SELECTION),
    RED("05_red", COLOR),
    YELLOW("06_yellow", COLOR),
    GREEN("07_green", COLOR),
    BACKGROUND_COLOR("08_backgroundColor", SELECTION),
    BLUE("09_blue", COLOR),
    BROWN("10_brown", COLOR),
    GREY("11_grey", COLOR),
    SHAPE_COLOR("12_shapeColor", ACTION),
    WHITE("13_white", COLOR),
    BLACK("14_black", COLOR),
    CUSTOM_COLOR("15_customColor", ACTION),
    RESET("16_reset", ACTION),
    LINE("17_line", SELECTION),
    RECTANGULAR("18_rectangular", SELECTION),
    TRIANGLE("19_triangle", SELECTION),
    CIRCLE("20_circle", SELECTION),
    LINE_ERASER("21_lineEraser", SELECTION),
    PIXEL_ERASER("22_pixelEraser", SELECTION),
    CUT("23_cut", ACTION),
    PASTE("24_paste", ACTION),
    PEN("25_pen", SELECTION),
    BRUSH("26_brush", SELECTION),
    SPRAY("27_spray", SELECTION),
    TEXT_BOX("28_textBox", SELECTION);


    private final String name;
    private final ButtonUtilityType buttonUtilityType;

    ButtonConstants(
            String name,
            ButtonUtilityType buttonUtilityType
    ) {
        this.name = name;
        this.buttonUtilityType = buttonUtilityType;
    }

    public static ButtonConstants getButtonType(String name) {
        return Arrays.stream(ButtonConstants.values())
                .filter(value -> value.getName().equals(name))
                .findFirst()
                .get();
    }

    public String getName() {
        return name;
    }

    public ButtonUtilityType getButtonUtilityType() {
        return buttonUtilityType;
    }
}
