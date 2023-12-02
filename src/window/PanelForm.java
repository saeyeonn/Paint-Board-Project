package window;

import javax.swing.*;

import text.TextBox;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
}
