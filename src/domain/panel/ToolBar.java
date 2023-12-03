package domain.panel;

import domain.box.BoldTypeBox;
import domain.box.LineTypeBox;
import domain.button.Button;
import domain.button.Buttons;
import text.TextLabel;
import text.TextCheckBoxForm;
import text.TextComboBoxForm;
import text.TextSpinnerForm;
import repository.ButtonRepository;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ToolBar extends JToolBar{

    public ToolBar(Canvas canvas) {
        setPreferredSize(new Dimension(190, 300));
        setBackground(new Color(222, 237, 239));
        setLayout(new FlowLayout());

        Buttons buttonList = Buttons.create("src/resource/toolBar", canvas);
        List<Button> buttons = buttonList.getButtons();
        ButtonRepository.getInstance().addAll(buttons);

        for (Button button : buttons) {
            if (button.getName().equals("16_reset") || button.getName().equals("17_line")) {
                add(Box.createVerticalStrut(1));
            } else if (button.getName().equals("21_lineEraser")) {
                add(Box.createVerticalStrut(50));
                add(TextLabel.getLineTypeLabel());

                LineTypeBox lineType = LineTypeBox.create();
                add(lineType.getBox());
                add(TextLabel.getLineBoldLabel());

                BoldTypeBox boldType = BoldTypeBox.create();
                add(boldType.getBox());
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
    }

    public ToolBar getPanel() {
        return this;
    }


    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        // Set and Display Color List External Box line
        int colStartX = 20, colStartY = 44, colWidth = 120, colHeight = 118;
        int colArcWidth = 7, colArcHeight = 7;

        Graphics2D g= (Graphics2D) graphics;
        graphics.setColor(Color.BLACK);
        (g).setStroke(new BasicStroke(1));
        graphics.drawRoundRect(colStartX, colStartY, colWidth, colHeight, colArcWidth, colArcHeight);

        // Set and Display Shape List External Box Line
        int shpStartX = 20, shpStartY = 170, shpWidth = 160, shpHeight = 40;
        int shpArcWidth = 7, shpArcHeight = 7;

        graphics.setColor(Color.BLACK);
        (g).setStroke(new BasicStroke(1));
        graphics.drawRoundRect(shpStartX, shpStartY, shpWidth, shpHeight, shpArcWidth, shpArcHeight);
    }
}

