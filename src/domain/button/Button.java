package domain.button;

import action.ButtonAction;
import action.ButtonFocus;
import domain.button.constants.ButtonConstants;
import domain.panel.Canvas;
import eraser.EraserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import static domain.button.constants.ButtonUtilityType.*;

public class Button extends JButton {
    private final ButtonConstants buttonConstants;

    public Button(
            String filepath,
            String buttonName,
            Canvas canvas
    ) {
        setName(buttonName);
        setIcon(ImageConverter.getIconImage(filepath, buttonName));
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setPreferredSize(new Dimension(35, 35));

        System.out.println(buttonName + "은 " + ButtonConstants.getButtonType(buttonName).getButtonUtilityType() + "기능");
        this.addListener(canvas);
        this.buttonConstants = ButtonConstants.getButtonType(buttonName);
    }

    private void addListener(Canvas canvas) {
        addActionListener(new ButtonAction(canvas));
        ButtonFocus buttonFocus = new ButtonFocus(canvas);
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                JButton srcButton = (JButton) e.getSource();
                srcButton.setFocusPainted(true);
                if (srcButton.getName().equals("22_pixelEraser")){
                    System.out.println("픽셀지우개 활성화");
                    EraserController eraserController = new EraserController(canvas);
                    eraserController.activatePixelEraser(true);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                JButton srcButton = (JButton) e.getSource();
                srcButton.setFocusPainted(false);
                if (srcButton.getName().equals("22_pixelEraser")) {
                    EraserController eraserController = new EraserController(canvas);
                    eraserController.NotActivatePixelEraser();
                    System.out.println("꺼져라");
            }
        }});
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
