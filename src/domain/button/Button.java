package domain.button;

import domain.button.constants.ButtonType;
import domain.button.constants.Color;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    private final ButtonType buttonType;

    public Button(String filepath, String buttonName) {
        ButtonType variable = null;
        setName(buttonName);
        setIcon(ImageConverter.getIconImage(filepath, buttonName));
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setPreferredSize(new Dimension(35, 35));

        if (Color.isColorType(buttonName)) {
            variable = ButtonType.COLOR;
            System.out.println(buttonName + " = 색깔");
        } else {
            variable = ButtonType.ACTION;
            System.out.println(buttonName + " = 액션");
        }

        this.buttonType = variable;
    }
}
