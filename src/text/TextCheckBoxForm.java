package text;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TextCheckBoxForm extends JCheckBox{
    private static BoldUnderline boldUnderline;
    // set resources
    private static final TextCheckBoxForm fontBoldBox = new TextCheckBoxForm("Bold", 60, 30);
    private static final TextCheckBoxForm fontUnderLineBox = new TextCheckBoxForm("Underline", 90, 30);

    static {
        boldUnderline = new BoldUnderline(fontBoldBox, fontUnderLineBox);
    }

    TextCheckBoxForm(String text, int width, int height) { // set details
        setText(text);
        setOpaque(false);
        setPreferredSize(new Dimension(width, height));
        addCheckBoxListener();
    }

    private void addCheckBoxListener() {
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boldUnderline.checkBoxSetting();
            }
        });
        
    }

    public static TextCheckBoxForm getFontBoldBox() {
        return fontBoldBox;
    }

    public static TextCheckBoxForm getFontUnderLineBox() {
        return fontUnderLineBox;
    }

}
