package eraser;

import domain.panel.Canvas;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

public class PixelEraser  {
    private List<Point> points;

    private int eraserSize = 10; // 지우개 크기
    public boolean eraserActivated = false;
    private Canvas canvas; // PanelForm 참조
    int x;
    int y;

    public PixelEraser(Canvas canvas) {
        this.canvas = canvas;
        this.points = new ArrayList<>();
    }

    public void activatePixelEraser() {
        canvas.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (EraserController.act) {
                    x = e.getX();
                    y = e.getY();
                    // erase(g);
                }
            }
        });

        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (EraserController.act) {
                    x=e.getX();
                    y=e.getY();
                   // erase(g);
                }
            }
        });
    }
    public void addPoint(Point point) {
        points.add(point);
    }
    public void erase(Graphics g) {
        g.setColor(Color.black); // 패널의 배경색으로 설정
        g.fillRect(x - eraserSize / 2, y - eraserSize / 2, eraserSize, eraserSize);
        g.dispose();
    }
    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }

    public void setEraserActivated(boolean activated) {
        eraserActivated = true;
        /*if (activated) {
            activatePixelEraser();
        }*/
    }

    public void setEraserNotActivated(){
        eraserActivated = false;
    }



}


