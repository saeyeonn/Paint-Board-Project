package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Buttons {
    private ImageIcon[] Icon;

    public Buttons(Container container, String[] iconList, Frame frame) {
        createButton(container, iconList, frame);
    }

    public void createButton(Container container, String[] iconList, Frame frame) {

        Icon = new ImageIcon[iconList.length];
        JButton[] Buttons = new JButton[iconList.length];

        for (int i = 0; i < iconList.length; i++) {
            if (iconList[i].equals("zoomIn") || iconList[i].equals("zoomOut"))
                Icon[i] = createImageIcon("src/ImageSource/" + iconList[i] + ".png", 15, 15);
            if (iconList[i].equals("rectangularBox1"))
                Icon[i] = createImageIcon("src/ImageSource/" + iconList[i] + ".png", 100, 30);

           else Icon[i] = createImageIcon("src/ImageSource/" + iconList[i] + ".png", 30, 30);
        }
        for (int i = 0; i < Buttons.length; i++) {
            Buttons[i] = new JButton(Icon[i]);
            container.add(Buttons[i]);
            Buttons[i].setName("img" + iconList[i]);

            if (Buttons[i].getName().equals("imgrectangularBox1"))
                Buttons[i].setPreferredSize(new Dimension(105, 35));
            else Buttons[i].setPreferredSize(new Dimension(35, 35));
            Buttons[i].setFocusPainted(false);
            Buttons[i].setBorderPainted(false);
            Buttons[i].setContentAreaFilled(false);

            clickAction(Buttons[i], Icon[i]);

            if (iconList[i].equals("more")) selectColor(Buttons[i], frame);

        }
    }

    private ImageIcon createImageIcon(String filePath, int width, int height) {
        ImageIcon Icon = new ImageIcon(filePath);
        Image orgImag = Icon.getImage();
        Image scaledImage = orgImag.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        return new ImageIcon(scaledImage);
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
