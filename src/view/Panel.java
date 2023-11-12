package view;

import javax.swing.*;

import java.awt.*;

public class Panel{
        private final String[] panelIconList = {"previous", "after", "zoomIn", "zoomOut"};
        public void createPanel(Frame frame) {

            JPanel mainPanel = new JPanel();
            mainPanel.setBackground(Color.WHITE);
            mainPanel.setLayout(new FlowLayout());

            JPanel miniBar = new JPanel();
            miniBar.setBackground(new Color(222, 237, 239));
            miniBar.setPreferredSize(new Dimension(200, 45));
            miniBar.setLocation(600,50);

            Buttons buttons = new Buttons(miniBar, panelIconList, frame);

            mainPanel.add(miniBar, BorderLayout.NORTH);
            frame.add(mainPanel);
        }
    }
