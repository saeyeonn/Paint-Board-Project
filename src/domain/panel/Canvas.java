package domain.panel;

import action.PanelMouseListener;
import doing.Doing;
import doing.DoingList;
import eraser.PixelEraser;
import shape.Shape;
import shape.Shapes;
import zoom.Zoom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Canvas extends JPanel{
    private final JPanel miniBarPanel;
    private Color color = Color.white;
    public BufferedImage bufferedImage;
    private List<Shape> shapes = Shapes.shapes;
    private List<Shape> doingList = DoingList.doingList;
    private boolean drawLine = false;
    private boolean drawRectangle = false;
    private boolean drawTriangle = false;
    private boolean drawCircle = false;
    private final Zoom zoom;
    private final Doing doing;
    private int offsetX; // 화면의 중심 좌표를 나타내는 변수
    private int offsetY;

    private static boolean isremoving = false;

    private List<PixelEraser> erashapes;
    private List<PixelEraser> eraredoList;

    private PixelEraser currenteraserShape;


    public Canvas() {
        erashapes= new ArrayList<>();

        MiniBar miniBar = new MiniBar(this);
        JPanel miniBarPanel = miniBar.getPanel();

        add(miniBarPanel, BorderLayout.NORTH);
        setBackground(color);
        setLayout(new FlowLayout());

        this.miniBarPanel = miniBarPanel;
        PanelMouseListener panelMouseListener = new PanelMouseListener(this);
        zoom = new Zoom(this);
        doing = new Doing(this);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (drawLine || drawRectangle || drawTriangle || drawCircle) {
                    // 현재 중심 좌표를 빼서 상대적인 위치로 설정
                    Shape shape = new Shape(
                            e.getX() - offsetX, e.getY() - offsetY,
                            50, 50,
                            drawLine, drawRectangle, drawTriangle, drawCircle
                    );
                    shapes.add(shape);
                    doingList.add(shape);
                    repaint();
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
                if (isremoving) {
                    currenteraserShape = new PixelEraser(getPanel());
                    currenteraserShape.addPoint(e.getPoint());
                    repaint();
                    System.out.println("그리기 시작!");
                }
        }
            @Override
            public void mouseReleased(MouseEvent e) {
                if (isremoving ) {
                    currenteraserShape.addPoint(e.getPoint());
                    erashapes.add(currenteraserShape);
                    currenteraserShape = null;
                    eraredoList.clear();
                    repaint();
                    System.out.println("그리기 끝!");
                }
            }


        });
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (isremoving && currenteraserShape != null) {
                    currenteraserShape.addPoint(e.getPoint());
                    repaint();
                    System.out.println("그리는 중...");
                }
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

        Graphics2D g2d = (Graphics2D) g.create();
        applyZoom(g2d);

        if (bufferedImage != null) {
            g.drawImage(bufferedImage, 200, 30, 800, 450,null);
        }
        for (Shape shape : shapes) {
            shape.draw(g, zoom.getZoomFactor(), offsetX, offsetY);

            this.drawLine = false;
            this.drawRectangle = false;
            this.drawTriangle = false;
            this.drawCircle = false;
        }
        for (PixelEraser shape2 : erashapes) {
          shape2.draw(g2d);
        }
        if (isremoving && currenteraserShape != null) {
            currenteraserShape.draw(g2d);
        }

        g2d.dispose();

    }
    private void applyZoom(Graphics2D g2d) {
        AffineTransform at = new AffineTransform();
        at.scale(zoom.getZoomFactor(), zoom.getZoomFactor());
        System.out.print("스케일 조정함" + zoom.getZoomFactor());
        at.translate(offsetX, offsetY); // 중심 좌표로 이동
        g2d.setTransform(at);
    }

    public void applyZoom() {
        repaint();
        System.out.print("다시 그려!");
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

    public Zoom getZoom() {
        return zoom;
    }

    public Doing getDoing() {
        return doing;
    }

    public void setOffset(int offsetX, int offsetY) {
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        repaint();
    }
    public static void setEraser(boolean drawCircle){
        isremoving=drawCircle;

    }

}
