package Window;

import javax.swing.*;
import java.awt.*;
import java.awt.Button;

public class ToolBar extends JToolBar {
        private static final String[] iconList = {"backgroundColor", "brush", "deleteAll", "group", "ungroup", "open", "lineCol", "lineEraser", "paste", "save", "pixelEraser", "save", "shapeColor", "textBox"};
        private ImageIcon[] orgIcon;
        private ImageIcon[] chgIcon;

        public ToolBar() {
                setPreferredSize(new Dimension(200, 400));
                setBackground(new Color(222, 237, 239));
                setLayout(new FlowLayout());
                Buttons buttons = new Buttons(this, iconList);
        }

}

