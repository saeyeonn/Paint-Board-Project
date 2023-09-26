package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Buttons {
    private ImageIcon[] imageIcons;

    public Buttons(Container container, String[] iconList, Frame frame) {
        createButton(container, iconList, frame);
    }

    public void createButton(Container container, String[] iconList, Frame frame) {

        imageIcons = new ImageIcon[iconList.length];
        JButton[] buttons = new JButton[iconList.length];

        createImageIcon(iconList, imageIcons);
        setButtons(container, frame, buttons, imageIcons, iconList);

    }

    private void setButtons(Container container, Frame frame, JButton[] buttons, ImageIcon[] imageIcons, String[] iconList) {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(imageIcons[i]);
            container.add(buttons[i]);
            buttons[i].setName("img" + iconList[i]);

            if (buttons[i].getName().equals("imgrectangularBox1"))
                buttons[i].setPreferredSize(new Dimension(105, 35));
            else buttons[i].setPreferredSize(new Dimension(35, 35));
            buttons[i].setFocusPainted(false);
            buttons[i].setBorderPainted(false);
            buttons[i].setContentAreaFilled(false);

            clickAction(buttons[i], imageIcons[i]);

            if (iconList[i].equals("more")) selectColor(buttons[i], frame);
        }
    }

    private void createImageIcon(String[] iconList, ImageIcon[] imageIcons) {

        int width, height;

        for (int i = 0; i< iconList.length; i++) {
            imageIcons[i] = new ImageIcon("src/ImageSource/" + iconList[i] + ".png");
            Image orgImag = imageIcons[i].getImage();

            if (iconList[i].equals("zoomIn") || iconList[i].equals("zoomOut")) {
                width = 25; height = 25;
            } else if (iconList[i].equals("rectangularBox1")) {
                width = 100; height = 30;
            } else { width = 30; height=30; }

            Image scaledImage = orgImag.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            imageIcons[i] = new ImageIcon(scaledImage);
        }
    }

    // maybe should mv below 2 methods to other package while implementing controller
    public void clickAction(JButton button, ImageIcon imageIcon) {
        button.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                JButton srcButton = (JButton) e.getSource();
                srcButton.setBorderPainted(true);
            }
            @Override
            public void focusLost(FocusEvent e) {
                JButton srcButton = (JButton) e.getSource();
                srcButton.setBorderPainted(false);
            }
        });
    }

    public void selectColor(JButton moreButton, Frame frame) {
        moreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color selectedColor = JColorChooser.showDialog(frame, "Color Chooser", Color.LIGHT_GRAY);
            }
        });
    }
}
