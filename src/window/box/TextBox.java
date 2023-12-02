package window.box;

import window.box.constants.FontType;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class TextBox {
    private final JComboBox<String> box;

    private TextBox() {
        JComboBox<String> fontJComboBox = new JComboBox<>();

        fontJComboBox.setPrototypeDisplayValue(null);
        fontJComboBox.setPreferredSize(new Dimension(80, 30));

        Arrays.stream(FontType.values())
                .forEach(value -> fontJComboBox.addItem(value.getName()));

        this.box = fontJComboBox;
    }

    public static TextBox create() {
        return new TextBox();
    }

    public JComboBox<String> getBox() {
        return box;
    }
}
