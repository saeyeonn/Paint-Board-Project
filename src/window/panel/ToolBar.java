package window.panel;

import button.ActionButtons;
import button.Button;
import window.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ToolBar {
    private final JPanel panel;

    public ToolBar() {
        JPanel toolbarPanel = new JPanel();
        toolbarPanel.setPreferredSize(new Dimension(190, 300));
        toolbarPanel.setBackground(new Color(222, 237, 239));
        toolbarPanel.setLayout(new FlowLayout());

        ActionButtons buttonList = ActionButtons.create("src/resource/toolBar");
        List<Button> buttons = buttonList.getButtons();

        for (Button button : buttons) {
            if (button.getName().equals("16_reset") || button.getName().equals("17_line")) {
                toolbarPanel.add(Box.createVerticalStrut(1));
            } else if (button.getName().equals("21_lineEraser")) {
                // display line type, bold box
                toolbarPanel.add(Box.createVerticalStrut(50));
                toolbarPanel.add(LabelBoxForm.getLineTypeLabel());
                toolbarPanel.add(LineBoxForm.getLineTypeBox());
                toolbarPanel.add(LabelBoxForm.getLineBoldLabel());
                toolbarPanel.add(LineBoxForm.getBoldTypeBox());
                toolbarPanel.add(Box.createVerticalStrut(50));
            }

            toolbarPanel.add(button);
        }

        toolbarPanel.add(Box.createVerticalStrut(50));
        toolbarPanel.add(TextComboBoxForm.getFontComboBox());
        toolbarPanel.add(Box.createHorizontalStrut(2));
        toolbarPanel.add(TextSpinnerForm.getFontSizeSpinner());
        toolbarPanel.add(Box.createHorizontalStrut(5));
        toolbarPanel.add(TextCheckBoxForm.getFontBoldBox());
        toolbarPanel.add(TextCheckBoxForm.getFontUnderLineBox());

        this.panel = toolbarPanel;
    }

    public static ToolBar create() {
        return new ToolBar();
    }

    public JPanel getPanel() {
        return panel;
    }
}
