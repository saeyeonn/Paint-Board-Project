package window.box;

import javax.swing.*;
import java.awt.*;

public class TextComboBoxForm extends JComboBox<String>{

    // set resources
    private static String[] fontList = {"Arial", "Serif", "Times", "Roman"};

    private static final TextComboBoxForm fontComboBoxForm = new TextComboBoxForm(fontList, 100, 30);

    TextComboBoxForm(String[] fontList, int width, int height) {
        // set details
        setPrototypeDisplayValue(null);
        setPreferredSize(new Dimension(width, height));

        // add choices
        for (String string : fontList) {
            addItem(string);
        }
      }

    public static TextComboBoxForm getFontComboBox() {
        return fontComboBoxForm;
    }

}
