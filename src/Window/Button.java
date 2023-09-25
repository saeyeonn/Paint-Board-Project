package Window;

import javax.swing.*;
import java.awt.*;

public class Button {
    private ImageIcon[] orgIcon;
    private ImageIcon[] chgIcon;

    public Button(Container container, String[] iconList) {

        createButton(container, iconList);
    }

    public void createButton(Container container, String[] iconList) {

        orgIcon = new ImageIcon[iconList.length];
        chgIcon = new ImageIcon[iconList.length];
        JButton[] Buttons = new JButton[iconList.length];

        for (int i = 0; i < iconList.length; i++)
            orgIcon[i] = createImageIcon("src/ImageSource/" + iconList[i] + ".png", 30, 30);

        for (int i = 0; i < Buttons.length; i++) {
            Buttons[i] = new JButton(orgIcon[i]);
            container.add(Buttons[i]);
            Buttons[i].setPreferredSize(new Dimension(30, 30));
            Buttons[i].setBorderPainted(false);
            Buttons[i].setRolloverIcon(chgIcon[i]);
            Buttons[i].setContentAreaFilled(false);
            Buttons[i].setName("img" + iconList[i]);
        }
    }

    private ImageIcon createImageIcon(String filePath, int width, int height) {
        ImageIcon orgIcon = new ImageIcon(filePath);
        Image orgImag = orgIcon.getImage();
        Image scaledImage = orgImag.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        return new ImageIcon(scaledImage);
    }
}
