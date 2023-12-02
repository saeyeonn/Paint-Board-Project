package action;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Buttonfocus implements FocusListener {
    @Override
    public void focusGained(FocusEvent e) {
        JButton selectButton = (JButton) e.getSource();
        String Name=selectButton.getName();
        if (Name.equals("22_pixelEraser")){
            System.out.println("실험1");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {

    }
}
