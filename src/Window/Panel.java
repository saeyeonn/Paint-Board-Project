package Window;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    public void createPanel(Frame frame) {

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new FlowLayout());

        JPanel miniBar = new JPanel();
        miniBar.setBackground(Color.LIGHT_GRAY);
        miniBar.setPreferredSize(new Dimension(200, 30));
        miniBar.setBounds(600, 50, 200, 30);
        mainPanel.add(miniBar, BorderLayout.NORTH);

        frame.add(mainPanel);

        JToolBar sideToolBar = new JToolBar();
        ToolBar mySideToolBar = new ToolBar();
        frame.add(sideToolBar, BorderLayout.WEST);
        mySideToolBar.createToolBar(sideToolBar, 200, 400);
    }
}
