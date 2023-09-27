package View;

import javax.swing.*;
import java.awt.*;

public class ToolBar extends JToolBar {
        private static final String[] iconList = {"save", "open", "group", "ungroup", "red", "yellow", "green",
                "backgroundColor", "blue", "brown", "grey", "shapeColor", "black", "white", "more",
                "deleteAll", "lineEraser", "pixelEraser", "cut", "paste", "line", "square", "triangle", "circle",
                "pencil", "rectangularBox1", "brush", "rectangularBox1", "spray", "rectangularBox1", "textBox", "rectangularBox1"};

        public ToolBar(Frame frame) {
                setPreferredSize(new Dimension(200, 400));
                setBackground(new Color(222, 237, 239));
                setLayout(new FlowLayout());
                Buttons buttons = new Buttons(this, iconList, frame);
        }

}
