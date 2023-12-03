package action;

import eraser.EraserController;

import javax.swing.*;
import java.awt.event.FocusEvent;

public class Buttonfocus  {

    public static void focusGained(FocusEvent e) {
        JButton selectButton = (JButton) e.getSource();
        String Name=selectButton.getName();
        if (Name.equals("22_pixelEraser")){
            System.out.println("픽셀지우개 활성화");
            EraserController eraserController = new EraserController();
            eraserController.activatePixelEraser();

    }}

    public static void focusLost(FocusEvent e) {
        JButton selectButton = (JButton) e.getSource();
        String Name=selectButton.getName();


    }
}
