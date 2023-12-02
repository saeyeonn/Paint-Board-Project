package window.panel;

import button.ActionButtons;
import button.Button;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MiniBar {
    private static final String RESOURCE_PATH = "src/resource/miniBar";

    private final JPanel miniBarPanel;

    private MiniBar() {
        JPanel miniBarPanel = new JPanel();
        initPanelConstraints(miniBarPanel);
        this.miniBarPanel = miniBarPanel;
    }

    private void initPanelConstraints(JPanel miniBarPanel) {
        miniBarPanel.setBackground(new Color(222, 237, 239));
        miniBarPanel.setPreferredSize(new Dimension(200, 45));
        miniBarPanel.setLayout(new FlowLayout());
        miniBarPanel.setLocation(600, 50);

        ActionButtons buttonList = ActionButtons.create(RESOURCE_PATH);
        List<Button> buttons = buttonList.getButtons();
        buttons.forEach(miniBarPanel::add);
    }

    public static MiniBar create() {
        return new MiniBar();
    }

    public JPanel getPanel() {
        return miniBarPanel;
    }
}
