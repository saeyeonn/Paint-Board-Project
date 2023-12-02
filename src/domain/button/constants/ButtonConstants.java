package domain.button.constants;

import java.util.Arrays;

import static domain.button.constants.ButtonUtilityType.*;

public enum ButtonConstants {
    REDO("redo", ACTION, null),
    UNDO("undo", ACTION, null),
    ZOOM_IN("zoomIn", ACTION, null),
    ZOOM_OUT("zoomOut", ACTION, null),
    SAVE("01_save", ACTION, null),
    OPEN("02_open", ACTION, null),
    GROUP("03_group", SELECTION, null),
    UNGROUP("04_ungroup", SELECTION, null),
    RED("05_red", COLOR, null),
    YELLOW("06_yellow", COLOR, null),
    GREEN("07_green", COLOR, null),
    BACKGROUND_COLOR("08_backgroundColor", SELECTION, null),
    BLUE("09_blue", COLOR, null),
    BROWN("10_brown", COLOR, null),
    GREY("11_grey", COLOR, null),
    SHAPE_COLOR("12_shapeColor", ACTION, null),
    WHITE("13_white", COLOR, null),
    BLACK("14_black", COLOR, null),
    CUSTOM_COLOR("15_customColor", ACTION, null),
    RESET("16_reset", ACTION, null),
    LINE("17_line", SELECTION, null),
    RECTANGULAR("18_rectangular", SELECTION, null),
    TRIANGLE("19_triangle", SELECTION, null),
    CIRCLE("20_circle", SELECTION, null),
    LINE_ERASER("21_lineEraser", SELECTION, null),
    PIXEL_ERASER("22_pixelEraser", SELECTION, null),
    CUT("23_cut", ACTION, null),
    PASTE("24_paste", ACTION, null),
    PEN("25_pen", SELECTION, null),
    BRUSH("26_brush", SELECTION, null),
    SPRAY("27_spray", SELECTION, null),
    TEXT_BOX("28_textBox", SELECTION, null);


    private final String name;
    private final ButtonUtilityType buttonUtilityType;
    private final String add;

    ButtonConstants(
            String name,
            ButtonUtilityType buttonUtilityType,
            String add
    ) {
        this.name = name;
        this.buttonUtilityType = buttonUtilityType;
        this.add = add;
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
