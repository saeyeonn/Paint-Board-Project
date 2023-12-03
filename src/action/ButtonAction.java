package action;

import drawing.Pen;
import text.TextBox;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton selectButton = (JButton) e.getSource();

        String Name=selectButton.getName();
        if (Name.equals("25_pen")) {
            // Pen 버튼을 눌렀을 때 
            Pen pen= new Pen();
            //pen.draw((Button) selectButton);
        } else if (Name.equals("28_textBox")) {
            TextBox textBox = new TextBox();
            textBox.setCreating();
        }


    }

}
