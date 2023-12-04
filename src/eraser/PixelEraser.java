package eraser;

import domain.panel.Canvas;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class PixelEraser  {
    private int eraserSize = 10; // 지우개 크기
    public boolean eraserActivated = false;
    private Canvas canvas;

    public PixelEraser(Canvas canvas) {
        this.canvas = canvas;
    }

    public void activatePixelEraser() {
        canvas.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (eraserActivated && EraserController.act) {
                    erase(e.getX(), e.getY());
                }
            }
        });

        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (eraserActivated && EraserController.act) {
                    erase(e.getX(), e.getY());
                }
            }
        });
    }

    private void erase(int x, int y) {
        Graphics g = canvas.getGraphics(); // 패널의 그래픽 컨텍스트 가져오기
        g.setColor(Color.black); // 패널의 배경색으로 설정
        g.fillRect(x - eraserSize / 2, y - eraserSize / 2, eraserSize, eraserSize);
        g.dispose();
    }

    public void setEraserActivated(boolean activated) {
        eraserActivated = true;
        if (activated) {
            activatePixelEraser();
        }
    }

    public void setEraserNotActivated(){
        eraserActivated = false;
    }



}


