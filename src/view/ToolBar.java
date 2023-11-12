package view;

import javax.swing.*;
import java.awt.*;

public class ToolBar extends JToolBar {

        private final String[] toolBarIconList = {"save", "open", "group", "ungroup", "red", "yellow", "green",
                "backgroundColor", "blue", "brown", "grey", "shapeColor", "black", "white", "more", "deleteAll",
                "line", "square", "triangle", "circle", "lineEraser", "pixelEraser", "cut", "paste",
                "pencil", "brush", "spray", "textBox"};

        public ToolBar(Frame frame) {
                setPreferredSize(new Dimension(190, 300));
                setBackground(new Color(222, 237, 239));
                setLayout(new FlowLayout());
                Buttons buttons = new Buttons(this, toolBarIconList, frame);
        }

        protected void paintComponent(Graphics graphics) {
                super.paintComponent(graphics);

                int colStartX = 20, colStartY = 44, colWidth = 120, colHeight = 118;
                int colArcWidth = 7, colArcHeight = 7;

                graphics.setColor(Color.BLACK);
                ((Graphics2D) graphics).setStroke(new BasicStroke(1));
                graphics.drawRoundRect(colStartX, colStartY, colWidth, colHeight, colArcWidth, colArcHeight);

                int shpStartX = 20, shpStartY = 170, shpWidth = 160, shpHeight = 40;
                int shpArcWidth = 7, shpArcHeight = 7;

                graphics.setColor(Color.BLACK);
                ((Graphics2D) graphics).setStroke(new BasicStroke(1));
                graphics.drawRoundRect(shpStartX, shpStartY, shpWidth, shpHeight, shpArcWidth, shpArcHeight);
        }

}
