package action;

import domain.panel.Canvas;
import eraser.PixelEraser;
import text.TextBox;
import zoom.Zoom;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class PanelMouseListener {
    private Canvas canvas;
    private TextBox textBox;
    private Zoom zoom;
    private PixelEraser pixelEraser;


    public PanelMouseListener(Canvas canvas) {
        this.canvas = canvas;
        addMouseListener();
    }

    private void addMouseListener() {
        textBox = new TextBox(canvas);
        zoom = new Zoom(canvas);
        pixelEraser = new PixelEraser(canvas);

        canvas.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textBox.click(e);
                textBox.arrangeTextBoxes(); // 위치 설정 추가
            }

            @Override
            public void mousePressed(MouseEvent e) {
            /*    if (pixelEraser != null && EraserController.act) {
                    pixelEraser.setEraserActivated(true);
                    System.out.println(EraserController.act);
                } else {
                    pixelEraser.setEraserNotActivated();
                }*/
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

        // 마우스 휠 리스너 추가
        canvas.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                // 마우스 휠 움직임에 따라 zoom 처리
                int notches = e.getWheelRotation();
                if (notches < 0) {
                    // 마우스 휠을 위로 돌리면 줌 인
                    zoom.zoomIn();
                } else {
                    // 마우스 휠을 아래로 돌리면 줌 아웃
                    zoom.zoomOut();
                }
                canvas.repaint();
            }
        });
    }


}
