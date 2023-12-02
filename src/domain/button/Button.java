package domain.button;

import domain.button.constants.ButtonConstants;
import event.ClickListener;

import javax.swing.*;
import java.awt.*;

import static domain.button.constants.ButtonUtilityType.*;

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
        this.addActionListener(new ClickListener());
        this.buttonConstants = ButtonConstants.getButtonType(buttonName);
    }

    public ButtonConstants getButtonConstants() {
        return buttonConstants;
    }

    public boolean isColorButton() {
        return buttonConstants.getButtonUtilityType().equals(COLOR);
    }

    public boolean isActionButton() {
        return buttonConstants.getButtonUtilityType().equals(ACTION);
    }

    public boolean isSelectionButton() {
        return buttonConstants.getButtonUtilityType().equals(SELECTION);
    }
}
