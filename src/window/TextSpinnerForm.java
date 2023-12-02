package window;

import action.ChangeDetector;

import javax.swing.*;
import java.awt.*;

public class TextSpinnerForm extends JSpinner{
    private static final TextSpinnerForm fontSizeSpinner =
            new TextSpinnerForm(new SpinnerNumberModel(12, 1, 80, 5), 45, 30);

    TextSpinnerForm(SpinnerNumberModel spinnerNumberModel, int width, int height) { //set details
        setPreferredSize(new Dimension(width, height));
      }

    public static TextSpinnerForm getFontSizeSpinner() {
        return fontSizeSpinner;
    }
}
