package View;

import javax.swing.*;

import java.awt.*;

public class Panel{
    public void createPanel(Frame frame) {

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new FlowLayout());

        JPanel miniBar = new JPanel();
        miniBar.setBackground(new Color(222, 237, 239));
        miniBar.setPreferredSize(new Dimension(250, 45));
        miniBar.setLocation(600,50);

        String[] iconList = {"previous", "after", "zoomIn", "zoomOut"};
        Buttons buttons = new Buttons(miniBar, iconList, frame);

        mainPanel.add(miniBar, BorderLayout.NORTH);
        frame.add(mainPanel);
    }
}
