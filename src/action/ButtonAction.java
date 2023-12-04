package action;

import text.TextBox;
import javax.swing.*;

import doing.Doing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonAction implements ActionListener {
    //private Zoom zoom = new Zoom();
    private Doing doing = new Doing();

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton selectButton = (JButton) e.getSource();


        String Name=selectButton.getName();


        if (Name.equals("28_textBox")) {
            TextBox textBox = new TextBox();
            textBox.setCreating();

        } else if (Name.equals("redo")) {
            doing.redo();
            System.out.println("리두");

        } else if (Name.equals("undo")) {
            doing.undo();
            System.out.println("언두");

        } else if (Name.equals("zoomIn")) {
            // System.out.println("줌인");
            // // zoom.zoomInBut();

        } else if (Name.equals("zoomOut")) {
            // System.out.println("줌아웃");
            // // zoom.zoomOutBut();
        }


    }
}
