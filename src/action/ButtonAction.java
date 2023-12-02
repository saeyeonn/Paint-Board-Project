package action;

import drawing.Pen;
import text.TextBox;

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
        
    }

}
