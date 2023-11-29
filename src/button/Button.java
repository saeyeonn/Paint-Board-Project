package button;

import action.ButtonAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Button extends JButton {

    // set common design of JButton
    public Button(String filepath, String buttonName) {
        setName(buttonName);
        setIcon(ImageConverter.getIconImage(filepath, buttonName));
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setPreferredSize(new Dimension(35, 35));

    }
}
