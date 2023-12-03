package action;

import domain.panel.Canvas;
import drawing.DrawingController;
import eraser.EraserController;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class ButtonFocus implements FocusListener {
    private Canvas canvas;

    public ButtonFocus(Canvas canvas) {
        this.canvas = canvas;
    }

    public void focusGained(FocusEvent e) {
        JButton selectButton = (JButton) e.getSource();
        String Name=selectButton.getName();
        if (Name.equals("22_pixelEraser")){
            EraserController eraserController = new EraserController(canvas);
            eraserController.activatePixelEraser(true);

        }
        else if(Name.equals("21_lineEraser")){
            EraserController eraserController = new EraserController(canvas);
            eraserController.activateLineEraser();
        } else if (Name.equals("25_pen")) {
            DrawingController drawingController = new DrawingController(canvas);

        }
    }

    public void focusLost(FocusEvent e) {
        JButton lostFocusButton = (JButton) e.getSource();
        String lostFocusButtonName = lostFocusButton.getName();

        if (lostFocusButtonName.equals("22_pixelEraser")) {
            EraserController eraserController = new EraserController(canvas);
            eraserController.NotActivatePixelEraser();


        }
    }
}
