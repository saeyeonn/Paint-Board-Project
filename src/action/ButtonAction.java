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

        }else if (Name.equals("17_line")) {
            ShapingController sc= new ShapingController();
            System.out.println("라인 버튼");
            sc.iniLine();            

        }else if (Name.equals("18_rectangular")) {
            ShapingController sc= new ShapingController();
            System.out.println("사각형 버튼");
            sc.iniRect();

        } else if (Name.equals("19_triangle")) {
            ShapingController sc= new ShapingController();
            sc.iniTri();
        } else if (Name.equals("20_circle")) {
            ShapingController sc= new ShapingController();
            sc.iniCir();
        }


    }

}
