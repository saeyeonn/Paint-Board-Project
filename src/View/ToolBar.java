package View;

import javax.swing.*;
import java.awt.*;

public class ToolBar extends JToolBar {
        private static final String[] iconList = {"backgroundColor", "brush", "deleteAll", "group", "ungroup", "open", "lineEraser", "paste", "save", "pixelEraser", "save", "shapeColor", "textBox","line", "square", "triangle", "circle", "red", "yellow", "green", "blue", "black", "white", "more"};

        public ToolBar(Frame frame) {
                setPreferredSize(new Dimension(200, 400));
                setBackground(new Color(222, 237, 239));
                setLayout(new FlowLayout());
                Buttons buttons = new Buttons(this, iconList, frame);
        }

}

