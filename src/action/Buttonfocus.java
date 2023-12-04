package action;

//import drawing.Drawing;
import eraser.EraserController;

import javax.swing.*;
import java.awt.event.FocusEvent;

public class Buttonfocus  {
    private static EraserController eraserController = new EraserController();
    // private static Drawing drawing = new Drawing();

    public static void focusGained(FocusEvent e) {
        JButton selectButton = (JButton) e.getSource();
        String Name=selectButton.getName();
        if (Name.equals("22_pixelEraser")){
            eraserController.activatePixelEraser(true);

        } else if(Name.equals("21_lineEraser")){
            eraserController.activateLineEraser();

        } else if (Name.equals("25_pen")) {
            //drawing.activeDrawing();
        }
    }

    public static void focusLost(FocusEvent e) {
        JButton lostFocusButton = (JButton) e.getSource();
        String lostFocusButtonName = lostFocusButton.getName();

        if (lostFocusButtonName.equals("22_pixelEraser")) {
            eraserController.deactivatePixelEraser();
        } else if (lostFocusButtonName.equals("25_pen")) {
            //drawing.deactiveDrawing();
        }
    }
}
