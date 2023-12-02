package window;

import javax.swing.*;
import java.awt.*;

public class LabelBoxForm extends JLabel {
    public static final LabelBoxForm lineTypeLabel = new LabelBoxForm("Line Type", 60, 30);
    public static final LabelBoxForm lineBoldLabel = new LabelBoxForm("Line Bold",60, 30);

    private LabelBoxForm(String name, int width, int height) { // set details
        setText(name);
        setPreferredSize(new Dimension(width, height));
    }

    public static LabelBoxForm getLineTypeLabel(){
        return lineTypeLabel;
    }

    public static LabelBoxForm getLineBoldLabel(){
        return lineBoldLabel;
    }

}
