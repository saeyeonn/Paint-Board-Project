package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Buttons extends JButton {
    JButton[] buttons;

    Buttons(Container container, String[] iconList, Frame frame) {
        buttons = new JButton[iconList.length];

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = (JButton) createButton(container, createImageIcon(iconList[i]), iconList[i], frame);
            container.add(buttons[i]);
            if (buttons[i].getName().equals("button-textBox") || buttons[i].getName().equals("button-circle"))
                container.add(Box.createVerticalStrut(50));
        }
        createTextBoxSetting(container);
    }

    private ImageIcon createImageIcon(String iconName) {
            int width = 25, height = 25;

        if (iconName.equals("zoomIn") || iconName.equals("zoomOut")) {width = height = 25;}
        if (iconName.equals("1pt")|| iconName.equals("3pt")|| iconName.equals("6pt") || iconName.equals("9pt")
                || iconName.equals("dot") || iconName.equals("dash") || iconName.equals("solid")) {width = 70; height = 40;}
        if (iconName.equals("lineType") || iconName.equals("lineBold")) {width = 190; height = 45;}
        Image scaledImage = new ImageIcon("src/ImageSource/" + iconName + ".png")
                .getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);

        return new ImageIcon(scaledImage);
    }

    private Component createButton(Container container, ImageIcon imageIcon, String iconList, Frame frame) {
        JButton button = new JButton(imageIcon);
        button.setName("button-" + iconList);
        applyButtonsStyle(container, button);
        if (button.getName().equals("button-more")) selectColor(button, frame);
        if (button.getName().equals("button-lineEraser")) {createLineBox(container);}
        clickAction(button);
        return button;
    }

    private void applyButtonsStyle(Container container, JButton button) {
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setPreferredSize(new Dimension(35, 35));

        if (button.getName().equals("button-zoomIn")) container.add(Box.createHorizontalStrut(5));
    }

    private void createLineBox(Container container) {
        JLabel lineTypeLabel = new JLabel("Line Type");
        lineTypeLabel.setPreferredSize(new Dimension(60, 30));
        container.add(lineTypeLabel);

        ImageIcon[] lineTypeIcons = {createImageIcon("dash"),
                createImageIcon("dot"), createImageIcon("solid")};
        JComboBox<ImageIcon> lineTypeBox = new JComboBox<>(lineTypeIcons);
        lineTypeBox.setPreferredSize(new Dimension(80, 30));
        container.add(lineTypeBox);
        container.add(Box.createVerticalStrut(30));

        JLabel lineBoldLabel = new JLabel("Line Bold");
        lineBoldLabel.setPreferredSize(new Dimension(60, 30));
        container.add(lineBoldLabel);

        ImageIcon[] lineBoldIcons = {createImageIcon("9pt"), createImageIcon("6pt"),
                createImageIcon("3pt"), createImageIcon("1pt")};
        JComboBox<ImageIcon> lineBoldBox = new JComboBox<>(lineBoldIcons);
        lineBoldBox.setPreferredSize(new Dimension(80, 30));
        container.add(lineBoldBox);
        container.add(Box.createVerticalStrut(50));

    }


    private void createTextBoxSetting(Container container) {
        JComboBox<String> fontComboBox = new JComboBox<>(new String[] {"Arial", "Times New Roman", "Courier New"});
        fontComboBox.setPreferredSize(new Dimension(100, 30));
        container.add(fontComboBox);
        container.add(Box.createHorizontalStrut(5));

        SpinnerNumberModel fontSizeModel = new SpinnerNumberModel(12, 1, 80, 5);
        JSpinner fontSizeSpinner = new JSpinner(fontSizeModel);
        fontSizeSpinner.setPreferredSize(new Dimension(35, 30));
        container.add(fontSizeSpinner);

        JCheckBox fontBoldBox = new JCheckBox("Bold");
        fontBoldBox.setOpaque(false);
        fontBoldBox.setPreferredSize(new Dimension(60, 30));
        container.add(fontBoldBox);

        JCheckBox fontUnderLineBox = new JCheckBox("Underline");
        fontUnderLineBox.setOpaque(false);
        fontUnderLineBox.setPreferredSize(new Dimension(90, 30));
        container.add(fontUnderLineBox);
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
            Color rgbColor = JColorChooser.showDialog(frame, "Color Chooser", Color.LIGHT_GRAY);
        });
    }
}
