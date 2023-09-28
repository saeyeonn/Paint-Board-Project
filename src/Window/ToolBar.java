package Window;

import javax.swing.*;
import java.awt.*;
import java.awt.Button;

public class ToolBar extends JToolBar {
        private static final String[] iconList = {"save", "open", "group", "ungroup", "red", "yellow", "green",
                "backgroundColor", "blue", "brown", "grey", "shapeColor", "black", "white", "more", "deleteAll",
                "line", "square", "triangle", "circle", "lineEraser", "pixelEraser", "cut", "paste", "lineType",
                "pencil", "brush", "spray", "textBox"};

        public ToolBar(Frame frame) {
                setPreferredSize(new Dimension(220, 400));
                setBackground(new Color(222, 237, 239));
                setLayout(new FlowLayout());
                Buttons buttons = new Buttons(this, iconList, frame);

        }

        protected void paintComponent(Graphics graphics) {
                super.paintComponent(graphics);

                int colStartX = 20, colStartY = 75, colWidth = 137, colHeight = 128;
                int colArcWidth = 7, colArcHeight = 7;

                graphics.setColor(Color.BLACK);
                ((Graphics2D) graphics).setStroke(new BasicStroke(1));
                graphics.drawRoundRect(colStartX, colStartY, colWidth, colHeight, colArcWidth, colArcHeight);

                int shpStartX = 20, shpStartY = 212, shpWidth = 182, shpHeight = 45;
                int shpArcWidth = 7, shpArcHeight = 7;

                graphics.setColor(Color.BLACK);
                ((Graphics2D) graphics).setStroke(new BasicStroke(1));
                graphics.drawRoundRect(shpStartX, shpStartY, shpWidth, shpHeight, shpArcWidth, shpArcHeight);
        }

}