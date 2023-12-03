package domain.panel;

import action.PanelMouseListener;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Canvas extends JPanel{
    private final JPanel miniBarPanel;
    public BufferedImage bufferedImage;

    private Canvas() {

        MiniBar miniBar = new MiniBar(this);
        JPanel miniBarPanel = miniBar.getPanel();

        add(miniBarPanel, BorderLayout.NORTH);
        setBackground(Color.WHITE);
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (bufferedImage != null) {
            g.drawImage(bufferedImage, 200, 30, 800, 450,null);
        }
    }
}
