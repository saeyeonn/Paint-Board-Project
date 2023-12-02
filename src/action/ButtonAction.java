package action;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import button.Button;
import drawing.Draw;
import drawing.Pen;
import window.PanelForm;

public class ButtonAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton selectButton = (JButton) e.getSource();

        String Name=selectButton.getName();
        if (Name.equals("25_pen")) {
            // Pen 버튼을 눌렀을 때 
            System.out.println("Pen!!");
            Pen pen= new Pen();
//            pen.draw((Button) selectButton);
        } else if (Name.equals("")) {
            //쭉 밑으로 버튼마다의 기능 연결

        }
    }

}
