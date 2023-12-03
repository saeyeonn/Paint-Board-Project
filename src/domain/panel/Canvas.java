package domain.panel;

import action.PanelMouseListener;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel{
    private final JPanel miniBarPanel;

    private Canvas() {

        MiniBar miniBar = MiniBar.create();
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

    public JPanel getPanel() {
        return this;
    }
}
