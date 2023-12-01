package action;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import drawing.Draw;

public class ButtonAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton selectButton = (JButton) e.getSource();

        if (selectButton.getName().equals("25_pen")) {
            // Pen 버튼을 눌렀을 때 
            Draw pen= new Draw(){};
            draw(selectButton);
            
        }
    }

}
