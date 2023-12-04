package action;

import domain.panel.Canvas;
import eraser.PixelEraser;
import text.TextBox;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelMouseListener {
    private Canvas canvas;
    private TextBox textBox;
    private PixelEraser pixelEraser;


    public PanelMouseListener(Canvas canvas) {
        this.canvas = canvas;
        addMouseListener();
    }

    private void addMouseListener() {
        textBox = new TextBox(canvas);
        pixelEraser = new PixelEraser(canvas);


        canvas.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textBox.click(e);
                textBox.arrangeTextBoxes(); // 위치 설정 추가
            }

            @Override
            public void mousePressed(MouseEvent e) {
                pixelEraser.activatePixelEraser();
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
