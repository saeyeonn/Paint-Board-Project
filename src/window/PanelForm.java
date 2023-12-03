package window;

import eraser.PixelEraser;
import text.TextBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelForm extends JPanel{
    private TextBox textBox;
    private PixelEraser pixelEraser;

    public PanelForm() {
        add(MiniBarForm.getInstance(), BorderLayout.NORTH); // add minibar
        setBackground(Color.white);
        setLayout(new FlowLayout());



        textBox = new TextBox(PanelForm.this);
        pixelEraser = new PixelEraser(PanelForm.this);

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textBox.click(e);
                textBox.arrangeTextBoxes(); // 위치 설정 추가
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (pixelEraser != null) {
                    pixelEraser.setEraserActivated(true);

            }
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
