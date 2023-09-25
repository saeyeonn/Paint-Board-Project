package Window;

import javax.swing.*;
import java.awt.*;

public class ToolBar extends JToolBar {
        JToolBar bar = new JToolBar();

        public void createToolBar(JToolBar bar, int width, int height) {
                this.bar = bar;
                bar.setPreferredSize(new Dimension(width, height));
                bar.setBackground(Color.LIGHT_GRAY);
                bar.setLayout(new FlowLayout());
                imageIconProcess(bar);
        }

        public void imageIconProcess(JToolBar bar) {

                this.bar = bar;
                String[] iconList = {"backgroundColor", "brush", "deleteAll", "group", "ungroup", "open", "lineCol", "lineEraser", "paste", "save", "pixelEraser", "save", "shapeColor", "textBox"};

                ImageIcon[] orgIcon = new ImageIcon[iconList.length];
                ImageIcon[] chgIcon = new ImageIcon[iconList.length];
                JButton[] Buttons = new JButton[iconList.length];

                for (int i = 0; i < iconList.length; i++)
                        orgIcon[i] = createImageIcon("src/ImageSource/" + iconList[i] + ".png", 70, 70);

                for (int i = 0; i < Buttons.length; i++) {
                        Buttons[i] = new JButton(orgIcon[i]);
                        bar.add(Buttons[i]);
                        Buttons[i].setPreferredSize(new Dimension(30, 30));
                        Buttons[i].setRolloverIcon(chgIcon[i]);
                        Buttons[i].setBorderPainted(true);
                        bar.addSeparator();
                        Buttons[i].setName("img" + iconList[i]);
                }

        }
        private ImageIcon createImageIcon (String filePath, int width, int height) {
                try {
                        ImageIcon orgIcon = new ImageIcon(filePath);
                        Image orgImag = orgIcon.getImage();
                        Image scaledImage = orgImag.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                        return new ImageIcon(scaledImage);
                } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                }
        }
}
