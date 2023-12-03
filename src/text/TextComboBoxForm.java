package text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextComboBoxForm extends JComboBox<String> {
    // set resources
    private static String[] fontList = {"Arial", "Serif", "Courier New", "Monospaced"};

    private static final TextComboBoxForm fontComboBoxForm = new TextComboBoxForm(fontList, 100, 30);

    static {
        new FontType(fontComboBoxForm);
    }

    TextComboBoxForm(String[] fontList, int width, int height) {
        // set details
        setPrototypeDisplayValue(null);
        setPreferredSize(new Dimension(width, height));

        // add choices
        for (String string : fontList) {
            addItem(string);
        }

        addCheckBoxListener();
    }

    private void addCheckBoxListener() {
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FontType.FontTypeSetting();
            }
        });
    }


    public static TextComboBoxForm getFontComboBox() {
        return fontComboBoxForm;
    }
}
