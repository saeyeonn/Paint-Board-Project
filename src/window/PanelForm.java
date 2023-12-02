package window;

import drawing.Pen;

import javax.swing.*;

import text.TextBox;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class PanelForm extends JPanel{
    private TextBox textBox;

    public PanelForm() {
        add(MiniBarForm.getInstance(), BorderLayout.NORTH); // add minibar
        setBackground(Color.WHITE);
        setLayout(new FlowLayout());

        textBox = new TextBox(PanelForm.this);

        addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                textBox.click(e);
                textBox.arrangeTextBoxes(); // 위치 설정 추가
            }

            @Override
            public void mousePressed(MouseEvent e) {

                startX = e.getX(); // 마우스가 눌렸을때 그때의 X좌표값으로 초기화
                startY = e.getY();
                System.out.println("누름: " + startX +","+startY);
            }

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}

        });
    }

    public synchronized void addMouseMotionListener(MouseMotionListener l) {

    }

    public int getStartX(){
        return startX;
    };
    public int getStartY(){
        return startY;
    };

}
