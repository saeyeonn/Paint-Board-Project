package Window;

import javax.swing.*;
import java.awt.*;

public class ToolBar extends JToolBar {
        private static final String[] iconList = {"backgroundColor", "brush", "deleteAll", "group", "ungroup", "open", "lineCol", "lineEraser", "paste", "save", "pixelEraser", "save", "shapeColor", "textBox"};
        private ImageIcon[] orgIcon;
        private ImageIcon[] chgIcon;

        public ToolBar() {
                setPreferredSize(new Dimension(200, 400));
                setBackground(new Color(222, 237, 239));
                setLayout(new FlowLayout());
                createButton(this);
        }

        public void createButton(Container container) {

                orgIcon = new ImageIcon[iconList.length];
                chgIcon = new ImageIcon[iconList.length];
                JButton[] Buttons = new JButton[iconList.length];

                for (int i = 0; i < iconList.length; i++)
                        orgIcon[i] = createImageIcon("src/ImageSource/ToolBar/" + iconList[i] + ".png", 30, 30);

                for (int i = 0; i < Buttons.length; i++) {
                        Buttons[i] = new JButton(orgIcon[i]);
                        add(Buttons[i]);
                        Buttons[i].setPreferredSize(new Dimension(30, 30));
                        Buttons[i].setBorderPainted(false);
                        Buttons[i].setRolloverIcon(chgIcon[i]);
                        Buttons[i].setContentAreaFilled(false);
                        Buttons[i].setName("img" + iconList[i]);
                }
        }
        private ImageIcon createImageIcon (String filePath, int width, int height) {
                ImageIcon orgIcon = new ImageIcon(filePath);
                Image orgImag = orgIcon.getImage();
                Image scaledImage = orgImag.getScaledInstance(width, height, Image.SCALE_SMOOTH);

                return new ImageIcon(scaledImage);
        }
}

