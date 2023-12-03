package action;

import drawing.drawingController;
import eraser.EraserController;

import javax.swing.*;
import java.awt.event.FocusEvent;

public class Buttonfocus  {
    public static void focusGained(FocusEvent e) {
        JButton selectButton = (JButton) e.getSource();
        String Name=selectButton.getName();
        if (Name.equals("22_pixelEraser")){
            EraserController eraserController = new EraserController();
            eraserController.activatePixelEraser(true);

        }
        else if(Name.equals("21_lineEraser")){
            EraserController eraserController = new EraserController();
            eraserController.activateLineEraser();
        } else if (Name.equals("25_pen")) {
            drawingController drawingController = new drawingController();

        }
    }

    public static void focusLost(FocusEvent e) {
        JButton lostFocusButton = (JButton) e.getSource();
        String lostFocusButtonName = lostFocusButton.getName();

        if (lostFocusButtonName.equals("22_pixelEraser")) {
            EraserController eraserController = new EraserController();
            eraserController.deactivatePixelEraser();


    }
}}
