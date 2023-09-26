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
                Icon[i] = createImageIcon("src/ImageSource/" + iconList[i] + ".png", 24, 24);
            else Icon[i] = createImageIcon("src/ImageSource/" + iconList[i] + ".png", 30, 30);
        }
        for (int i = 0; i < Buttons.length; i++) {
            Buttons[i] = new JButton(Icon[i]);
            container.add(Buttons[i]);
            Buttons[i].setName("img" + iconList[i]);

            Buttons[i].setPreferredSize(new Dimension(40, 40));
            Buttons[i].setFocusPainted(false);
            Buttons[i].setBorderPainted(false);
            Buttons[i].setContentAreaFilled(false);

            int finalI = i;
            Buttons[i].addFocusListener(new FocusListener() {
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

            Buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("clicked " + iconList[finalI]);
                }
            });

            if (iconList[i].equals("more")) {
                Buttons[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Color selectedColor = JColorChooser.showDialog(frame, "Color Chooser", Color.LIGHT_GRAY);
                    }
                });
            }

        }
    }

    private ImageIcon createImageIcon(String filePath, int width, int height) {
        ImageIcon Icon = new ImageIcon(filePath);
        Image orgImag = Icon.getImage();
        Image scaledImage = orgImag.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        return new ImageIcon(scaledImage);
    }
}
