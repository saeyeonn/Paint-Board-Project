package domain.panel;

import action.PanelMouseListener;
import shape.Shape;
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
    private List<Shape> shapes;
    private boolean drawLine = false;
    private boolean drawRectangle = false;
    private boolean drawTriangle = false;
    private boolean drawCircle = false;
    private final Zoom zoom;


    public Canvas() {

        MiniBar miniBar = new MiniBar(this);
        JPanel miniBarPanel = miniBar.getPanel();

        add(miniBarPanel, BorderLayout.NORTH);
        setBackground(color);
        setLayout(new FlowLayout());


        this.miniBarPanel = miniBarPanel;
        PanelMouseListener panelMouseListener = new PanelMouseListener(this);
        shapes = new ArrayList<>();
        zoom = new Zoom(this);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (drawLine || drawRectangle || drawTriangle || drawCircle) {
                    Shape shape = new Shape(e.getX(), e.getY(), 50, 50, drawLine, drawRectangle, drawTriangle, drawCircle);
                    shapes.add(shape);
                    repaint();
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
            shape.draw(g);
        }

        g2d.dispose();

    }
    private void applyZoom(Graphics2D g2d) {
        AffineTransform at = new AffineTransform();
        at.scale(zoom.getZoomFactor(), zoom.getZoomFactor());
        g2d.setTransform(at);
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


}
