package window;

import javax.swing.*;
import java.awt.*;

public class TextComboBoxForm extends JComboBox<String>{

    private static String[] fontList = {"Arial", "Serif", "Times", "Roman"};

    private static final TextComboBoxForm fontComboBoxForm = new TextComboBoxForm(fontList, 100, 30);

    TextComboBoxForm(String[] fontList, int width, int height) {
        setPrototypeDisplayValue(null);
        setPreferredSize(new Dimension(width, height));

        for (String string : fontList) {
            addItem(string);
        }
      }

    public static TextComboBoxForm getFontComboBox() {
        return fontComboBoxForm;
    }

}
