package action;

import drawing.Pen;
import shape.Circle;
import shape.ShapingController;
import shape.Triangle;
import text.TextBox;
import zoom.Zoom;

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
        Zoom zoom = new Zoom();

        String Name=selectButton.getName();

        if (Name.equals("25_pen")) {
            // Pen 버튼을 눌렀을 때
            Pen pen= new Pen();
            //pen.draw((Button) selectButton);
        } else if (Name.equals("28_textBox")) {
            TextBox textBox = new TextBox();
            textBox.setCreating();

        } else if (Name.equals("redo")) {
            System.out.println("리두");

        } else if (Name.equals("undo")) {
            System.out.println("언두");

        } else if (Name.equals("zoomIn")) {

        }


    }

}
