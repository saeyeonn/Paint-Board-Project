package domain.button;

import domain.button.constants.ButtonConstants;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    private final ButtonConstants buttonConstants;

    public Button(
            String filepath,
            String buttonName
    ) {
        setName(buttonName);
        setIcon(ImageConverter.getIconImage(filepath, buttonName));
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setPreferredSize(new Dimension(35, 35));

        System.out.println(buttonName + "은 " + ButtonConstants.getButtonType(buttonName).getButtonUtilityType() + "기능");
        this.buttonConstants = ButtonConstants.getButtonType(buttonName);
    }
}
