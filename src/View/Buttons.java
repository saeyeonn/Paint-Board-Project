package View;

import javax.swing.*;
import java.awt.*;
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
            buttons[i].setName("img-" + iconList[i]);

            if (buttons[i].getName().equals("img-after"))
                container.add(Box.createHorizontalStrut(5));
            if (buttons[i].getName().equals("img-textBox"))
                container.add(Box.createVerticalStrut(50));
            if (buttons[i].getName().equals("img-ungroup") || buttons[i].getName().equals("img-circle"))
                container.add(Box.createVerticalStrut(70));
            container.add(Box.createHorizontalStrut(2));

            if (buttons[i].getName().equals("img-lineType")) {
                buttons[i].setPreferredSize(new Dimension(180, 45));
                buttons[i].setBorderPainted(true);

                JComboBox<String> lineBoldComboBox = new JComboBox<>(new String[] {"line 3pt", "line 6pt", "line 9pt"});
                lineBoldComboBox.setPreferredSize(new Dimension(180, 30));
                container.add(lineBoldComboBox);
            }
            else buttons[i].setPreferredSize(new Dimension(35, 35));

            buttons[i].setFocusPainted(false);
            buttons[i].setBorderPainted(false);
            buttons[i].setContentAreaFilled(false);

            clickAction(buttons[i], imageIcons[i]);
            if (iconList[i].equals("more")) selectColor(buttons[i], frame);
        }
        createTextBoxSetting(container);
    }

    private void createTextBoxSetting(Container container) {

        JComboBox<String> fontComboBox = new JComboBox<>(new String[] {"Arial", "Times New Roman", "Courier New"});
        fontComboBox.setPreferredSize(new Dimension(90, 30));
        container.add(fontComboBox);

        SpinnerNumberModel fontSizeModel = new SpinnerNumberModel(12, 1, 80, 5);
        JSpinner fontSizeSpinner = new JSpinner(fontSizeModel);
        fontSizeSpinner.setPreferredSize(new Dimension(45, 30));
        container.add(fontSizeSpinner);

        JCheckBox fontBoldBox = new JCheckBox("B");
        fontBoldBox.setOpaque(false);
        fontBoldBox.setPreferredSize(new Dimension(40, 30));
        container.add(fontBoldBox);
    }

    private void createImageIcon(String[] iconList, ImageIcon[] imageIcons) {

        int width, height;

        for (int i = 0; i< iconList.length; i++) {
            imageIcons[i] = new ImageIcon("src/ImageSource/" + iconList[i] + ".png");
            Image orgImag = imageIcons[i].getImage();

            if (iconList[i].equals("zoomIn") || iconList[i].equals("zoomOut")) {
                width = 25; height = 25;
            } else if (iconList[i].equals("lineType")) {
                width = 190; height = 45;
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
        moreButton.addActionListener(e -> {
            Color selectedColor = JColorChooser.showDialog(frame, "Color Chooser", Color.LIGHT_GRAY);
        });
    }
}
