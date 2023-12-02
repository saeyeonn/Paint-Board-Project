package window.panel;

import javax.swing.*;
import java.awt.*;

public class Canvas {
    private final JPanel canvasPanel;
    private final JPanel miniBarPanel;

    private Canvas() {
        JPanel canvasPanel = new JPanel();

        MiniBar miniBar = MiniBar.create();
        JPanel miniBarPanel = miniBar.getPanel();

        canvasPanel.add(miniBarPanel, BorderLayout.NORTH);
        canvasPanel.setBackground(Color.WHITE);
        canvasPanel.setLayout(new FlowLayout());

        this.canvasPanel = canvasPanel;
        this.miniBarPanel = miniBarPanel;
    }

    public static Canvas create() {
        return new Canvas();
    }

    public JPanel getPanel() {
        return canvasPanel;
    }
}
