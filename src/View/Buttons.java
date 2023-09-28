package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Buttons extends JButton{
    private ImageIcon[] imageIcons;

    public Buttons(Container container, String[] iconList, Frame frame) {
        imageIcons = new ImageIcon[iconList.length];
        createImageIcon(iconList);
        createButton(container, iconList, frame);
    }

    private void createImageIcon(String[] iconList) {
        for (int i = 0; i< iconList.length; i++) {
            int width = 30, height = 30;

            if (iconList[i].equals("zoomIn") || iconList[i].equals("zoomOut")) { width = height = 25; }
            if (iconList[i].equals("lineType")) { width = 190; height = 45; }

            Image scaledImage = new ImageIcon("src/ImageSource/" + iconList[i] + ".png")
                    .getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            imageIcons[i] = new ImageIcon(scaledImage);
        }
    }

    private void createButton(Container container, String[] iconList, Frame frame) {
        JButton[] buttons = new JButton[iconList.length];

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(imageIcons[i]);
            buttons[i].setName("button-" + iconList[i]);
            applyButtonsStyle(container, buttons[i]);
            if (iconList[i].equals("more")) selectColor(buttons[i], frame);
            if (buttons[i].getName().equals("button-lineType")) { container.add(createLineBoldBox());

            }
            container.add(buttons[i]);
            clickAction(buttons[i]);
        }
        createTextBoxSetting(container);
    }

    private Component createLineBoldBox() {
        JComboBox<String> lineBoldComboBox = new JComboBox<>(new String[] {"line 3pt", "line 6pt", "line 9pt"});
        lineBoldComboBox.setPreferredSize(new Dimension(180, 30));
        return lineBoldComboBox;
    }

    private void applyButtonsStyle(Container container, JButton button) {
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        container.add(Box.createHorizontalStrut(2));

        if (button.getName().equals("button-after")) container.add(Box.createHorizontalStrut(5));
        if (button.getName().equals("button-textBox")) container.add(Box.createVerticalStrut(50));
        if (button.getName().equals("button-ungroup") || button.getName().equals("button-circle"))
            container.add(Box.createVerticalStrut(70));

        if (button.getName().equals("button-lineType")) { button.setPreferredSize(new Dimension(180, 45)); }
        else button.setPreferredSize(new Dimension(35, 35));
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

    // maybe should mv below 2 methods to other package while implementing controller
    public void clickAction(JButton button) {
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
