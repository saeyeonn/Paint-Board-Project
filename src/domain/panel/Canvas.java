package domain.panel;

import action.PanelMouseListener;
import shape.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Canvas extends JPanel{
    private final JPanel miniBarPanel;
    private Color color = Color.white;
    public BufferedImage bufferedImage;
    private List<Shape> shapes;
    private boolean drawLine = false;
    private boolean drawRectangle = false;
    private boolean drawTriangle = false;
    private boolean drawCircle = false;
    private boolean isFillMode = false; // paint button
    private Color fillColor;

    public Canvas() {

        MiniBar miniBar = new MiniBar(this);
        JPanel miniBarPanel = miniBar.getPanel();

        add(miniBarPanel, BorderLayout.NORTH);
        setBackground(color);
        setLayout(new FlowLayout());


        this.miniBarPanel = miniBarPanel;
        PanelMouseListener panelMouseListener = new PanelMouseListener(this);
        shapes = new ArrayList<>();
        addMouseListener(new MouseAdapter() {
            private Shape dragShape = null;
            private Point dragStartPoint = null;

            @Override
            public void mouseClicked(MouseEvent e) {
                if (drawLine || drawRectangle || drawTriangle || drawCircle) {
                    Shape shape = new Shape(e.getX(), e.getY(), 50, 50, drawLine, drawRectangle, drawTriangle, drawCircle);
                    shapes.add(shape);
                } else if (isFillMode) { // 도형 내부를 채우는 모드일 때
                    for (Shape shape : shapes) {
                        if (shape.contains(e.getX(), e.getY())) {
                            shape.setColor(fillColor); // 클릭한 위치에 있는 도형의 색상을 fillColor로 설정
                            shape.setFillMode(isFillMode);
                            break;
                        }
                    }
                }
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                for (Shape shape : shapes) {
                    if (shape.contains(e.getX(), e.getY())) {
                        dragShape = shape; // 현재 드래그 중인 도형을 저장
                        dragStartPoint = e.getPoint();
                        break;
                    }
                }
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (dragShape != null && dragStartPoint != null) { // 만약 드래그 중인 도형이 있고, 드래그 시작 시의 마우스 좌표가 정해져 있다면
                    // 마우스의 현재 위치와 드래그 시작 시의 위치의 차이를 계산
                    int dx = e.getX() - dragStartPoint.x;
                    int dy = e.getY() - dragStartPoint.y;
                    // 도형의 위치를 업데이트
                    dragShape.setX(dragShape.getX() + dx);
                    dragShape.setY(dragShape.getY() + dy);
                    dragStartPoint = e.getPoint(); // 드래그 시작 시의 마우스 좌표를 현재 좌표로 업데이트
                    repaint();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                dragShape = null;
                dragStartPoint = null;
            }
        });
    }

    public static Canvas create() {
        return new Canvas();
    }

    public Canvas getPanel() {
        return this;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (bufferedImage != null) {
            g.drawImage(bufferedImage, 200, 30, 800, 450,null);
        }
        for (Shape shape : shapes) {
            shape.draw(g);

            this.drawLine = false;
            this.drawRectangle = false;
            this.drawTriangle = false;
            this.drawCircle = false;
        }

    }

    public void changeBackground(Color color) {
        setBackground(color);
        setVisible(true);
    }

    public void setDrawLine(boolean drawLine) {
        this.drawLine = drawLine;
        this.drawRectangle = false;
        this.drawTriangle = false;
        this.drawCircle = false;
    }

    public void setDrawRectangle(boolean drawRectangle) {
        this.drawLine = false;
        this.drawRectangle = drawRectangle;
        this.drawTriangle = false;
        this.drawCircle = false;
    }

    public void setDrawTriangle(boolean drawTriangle) {
        this.drawLine = false;
        this.drawRectangle = false;
        this.drawTriangle = drawTriangle;
        this.drawCircle = false;
    }

    public void setDrawCircle(boolean drawCircle) {
        this.drawLine = false;
        this.drawRectangle = false;
        this.drawTriangle = false;
        this.drawCircle = drawCircle;
    }

    public void setFillMode(boolean isFillMode) {
        this.isFillMode = isFillMode;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }
}