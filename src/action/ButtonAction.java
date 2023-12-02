package action;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import button.Button;
import drawing.Draw;
import drawing.Pen;
import painting.BackgroundPaint;
import painting.ColorType;
import user.UserSelection;

public class ButtonAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton selectButton = (JButton) e.getSource();

        String Name=selectButton.getName();
        if (Name.equals("25_pen")) {
            // Pen 버튼을 눌렀을 때 
            Pen pen= new Pen();
//            pen.draw((Button) selectButton);

        } else if (Name.equals("08_backgroundColor")) {
            BackgroundPaint backgroundPaint= new BackgroundPaint();
            //쭉 밑으로 버튼마다의 기능 연결

        } else if (Name.equals("05_red")) {
            UserSelection userSelection = new UserSelection(ColorType.RED);

        } else if (Name.equals("06_yellow")) {
            UserSelection userSelection = new UserSelection(ColorType.YELLOW);



        }
    }

}