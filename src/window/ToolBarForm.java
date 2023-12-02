package window;

import button.ActionButtons;
import button.Button;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ToolBarForm extends JToolBar {

    public ToolBarForm() {
        // Set Size and Background
        setPreferredSize(new Dimension(190, 300));
        setBackground(new Color(222, 237, 239));
        setLayout(new FlowLayout());

        // generate and get buttons of toolbar in once
        ActionButtons buttonList = ActionButtons.create("src/resource/toolBar");
        List<Button> buttons = buttonList.getButtons();

        // display buttons in buttonList
        for (Button button : buttons) {
            if (button.getName().equals("16_reset") || button.getName().equals("17_line")) {
                add(Box.createVerticalStrut(1));
            } else if (button.getName().equals("21_lineEraser")) {
                // display line type, bold box
                add(Box.createVerticalStrut(50));
                add(LabelBoxForm.getLineTypeLabel());
                add(LineBoxForm.getLineTypeBox());
                add(LabelBoxForm.getLineBoldLabel());
                add(LineBoxForm.getBoldTypeBox());
                add(Box.createVerticalStrut(50));
            }

            add(button);
        }
        // display text box
        add(Box.createVerticalStrut(50));
        add(TextComboBoxForm.getFontComboBox());
        add(Box.createHorizontalStrut(2));
        add(TextSpinnerForm.getFontSizeSpinner());
        add(Box.createHorizontalStrut(5));
        add(TextCheckBoxForm.getFontBoldBox());
        add(TextCheckBoxForm.getFontUnderLineBox());

        setFloatable(false);
    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        // Set and Display Color List External Box line
        int colStartX = 20, colStartY = 44, colWidth = 120, colHeight = 118;
        int colArcWidth = 7, colArcHeight = 7;

        Graphics2D graphic = (Graphics2D) graphics;
        graphics.setColor(Color.BLACK);
        (graphic).setStroke(new BasicStroke(1));
        graphics.drawRoundRect(colStartX, colStartY, colWidth, colHeight, colArcWidth, colArcHeight);

        // Set and Display Shape List External Box Line
        int shpStartX = 20, shpStartY = 170, shpWidth = 160, shpHeight = 40;
        int shpArcWidth = 7, shpArcHeight = 7;

        graphics.setColor(Color.BLACK);
        (graphic).setStroke(new BasicStroke(1));
        graphics.drawRoundRect(shpStartX, shpStartY, shpWidth, shpHeight, shpArcWidth, shpArcHeight);
    }
}
