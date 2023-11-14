package window;

import javax.swing.*;
import java.awt.*;

public class TextCheckBoxForm extends JCheckBox{
    private static final TextCheckBoxForm fontBoldBox = new TextCheckBoxForm("Bold", 60, 30);
    private static final TextCheckBoxForm fontUnderLineBox = new TextCheckBoxForm("Underline", 90, 30);


    TextCheckBoxForm(String text, int width, int height) {
        setText(text);
        setOpaque(false);
        setPreferredSize(new Dimension(width, height));
    }

    public static TextCheckBoxForm getFontBoldBox() {
        return fontBoldBox;
    }

    public static TextCheckBoxForm getFontUnderLineBox() {
        return fontUnderLineBox;
    }

}
