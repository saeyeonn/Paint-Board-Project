package Window;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    public void createPanel(Frame frame) {

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new FlowLayout());

        JPanel miniBar = new JPanel();
        miniBar.setBackground(new Color(222, 237, 239));
        miniBar.setPreferredSize(new Dimension(200, 30));
        miniBar.setLocation(600,50);

        mainPanel.add(miniBar, BorderLayout.NORTH);
        frame.add(mainPanel);
    }
}
