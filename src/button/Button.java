package button;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    public Button(String filepath, String buttonName) {
        setName(buttonName);
        setIcon(ImageConverter.getIconImage(filepath, buttonName));
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setPreferredSize(new Dimension(35, 35));

    }
}
