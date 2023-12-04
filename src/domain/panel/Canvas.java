package domain.panel;

import action.PanelMouseListener;
import shape.ShapeMaker;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class Canvas extends JPanel{
    private final JPanel miniBarPanel;
    private Color color = Color.white;
    public BufferedImage bufferedImage;
    private List<ShapeMaker> drawShapeList;

    public Canvas() {

        MiniBar miniBar = new MiniBar(this);
        JPanel miniBarPanel = miniBar.getPanel();

        add(miniBarPanel, BorderLayout.NORTH);
        setBackground(color);
        setLayout(new FlowLayout());

        this.miniBarPanel = miniBarPanel;
        PanelMouseListener panelMouseListener = new PanelMouseListener(this);
    }

    public static Canvas create() {
        return new Canvas();
    }

    public Canvas getPanel() {
        return this;
    }

    public void changeBackground(Color color) {
        setBackground(color);
        setVisible(true);
    }

    public void setDrawShapeList(List<ShapeMaker> drawShapeList) {
        this.drawShapeList = drawShapeList;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (bufferedImage != null) {
            g.drawImage(bufferedImage, 200, 30, 800, 450,null);
        }
      }
}
