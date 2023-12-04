package domain.panel;

import action.PanelMouseListener;
import eraser.PixelEraser;
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

    private static boolean isremoving = false;

    private List<PixelEraser> erashapes;
    private List<PixelEraser> eraredoList;

    private PixelEraser currenteraserShape;


    public Canvas() {
        erashapes = new ArrayList<>();

        MiniBar miniBar = new MiniBar(this);
        JPanel miniBarPanel = miniBar.getPanel();

        add(miniBarPanel, BorderLayout.NORTH);
        setBackground(color);
        setLayout(new FlowLayout());


        this.miniBarPanel = miniBarPanel;
        PanelMouseListener panelMouseListener = new PanelMouseListener(this);
        shapes = new ArrayList<>();


        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (drawLine || drawRectangle || drawTriangle || drawCircle) {
                    Shape shape = new Shape(e.getX(), e.getY(), 50, 50, drawLine, drawRectangle, drawTriangle, drawCircle);
                    shapes.add(shape);
                    System.out.println("shape 그려짐");
                    repaint();
                }
                System.out.println(isremoving);
                if (isremoving) {
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
    protected void paintComponent2(Graphics g) {
        super.paintComponent(g);


        Graphics2D g2d = (Graphics2D) g;

        for (PixelEraser shape2 : erashapes) {
            shape2.draw(g2d);
        }

        if (isremoving && currenteraserShape != null) {
            currenteraserShape.draw(g2d);

        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if (bufferedImage != null) {
            g.drawImage(bufferedImage, 200, 30, 800, 450,null);
        }
        for (Shape shape : shapes) {
            shape.draw(g);
        }
        //for (PixelEraser shape2 : erashapes) {
          //  shape2.draw(g2d);
        //}
        if (isremoving && currenteraserShape != null) {
            currenteraserShape.draw(g2d);
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

    public static void setEraser(boolean drawCircle){
        isremoving=drawCircle;

    }

}
