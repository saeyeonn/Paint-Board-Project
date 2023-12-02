package window.label;

import javax.swing.*;
import java.awt.*;

public class TextLabel extends JLabel {
    public static final TextLabel lineTypeLabel = new TextLabel("Line Type", 60, 30);
    public static final TextLabel lineBoldLabel = new TextLabel("Line Bold",60, 30);

    private TextLabel(String name, int width, int height) { // set details
        setText(name);
        setPreferredSize(new Dimension(width, height));
    }

    public static TextLabel getLineTypeLabel(){
        return lineTypeLabel;
    }

    public static TextLabel getLineBoldLabel(){
        return lineBoldLabel;
    }

}
