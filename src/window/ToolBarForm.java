package window;

import button.Button;
import button.ButtonList;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ToolBarForm extends JToolBar {

    public ToolBarForm() {
        setPreferredSize(new Dimension(190, 300));
        setBackground(new Color(222, 237, 239));
        setLayout(new FlowLayout());

        ButtonList buttonList = ButtonList.create("src/resource/toolBar");
        ArrayList<Button> buttonsList = buttonList.getButtons();

        for (Button button : buttonsList) {
            if (button.getName().equals("16_reset") || button.getName().equals("17_line")) {
                add(Box.createVerticalStrut(1));
            } else if (button.getName().equals("21_lineEraser")) {
                add(Box.createVerticalStrut(50));
                add(LabelBoxForm.getLineTypeLabel());
                add(LineBoxForm.getLineTypeBox());
                add(LabelBoxForm.getLineBoldLabel());
                add(LineBoxForm.getBoldTypeBox());
                add(Box.createVerticalStrut(50));
            }

            add(button);
        }

        add(Box.createVerticalStrut(50));
        add(TextComboBoxForm.getFontComboBox());
        add(Box.createHorizontalStrut(2));
        add(TextSpinnerForm.getFontSizeSpinner());
        add(Box.createHorizontalStrut(5));
        add(TextCheckBoxForm.getFontBoldBox());
        add(TextCheckBoxForm.getFontUnderLineBox());
    }

    private void addVerticalGap(int width) {
        add(Box.createVerticalGlue());
        add(Box.createRigidArea(new Dimension(width, 0))); // Adjust the height as needed
        add(Box.createVerticalGlue());
    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        // Color List Box line
        int colStartX = 20, colStartY = 44, colWidth = 120, colHeight = 118;
        int colArcWidth = 7, colArcHeight = 7;

        graphics.setColor(Color.BLACK);
        ((Graphics2D) graphics).setStroke(new BasicStroke(1));
        graphics.drawRoundRect(colStartX, colStartY, colWidth, colHeight, colArcWidth, colArcHeight);

        // Shape List Box Line
        int shpStartX = 20, shpStartY = 170, shpWidth = 160, shpHeight = 40;
        int shpArcWidth = 7, shpArcHeight = 7;

        graphics.setColor(Color.BLACK);
        ((Graphics2D) graphics).setStroke(new BasicStroke(1));
        graphics.drawRoundRect(shpStartX, shpStartY, shpWidth, shpHeight, shpArcWidth, shpArcHeight);
    }
}