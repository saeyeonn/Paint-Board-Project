package domain.panel;

import domain.button.Button;
import domain.button.Buttons;
import repository.ButtonRepository;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MiniBar extends JPanel {
    private static final String RESOURCE_PATH = "src/resource/miniBar";
    public MiniBar(Canvas canvas) {
        initPanelConstraints(this, canvas);
    }

    private void initPanelConstraints(JPanel miniBar, Canvas canvas) {
        miniBar.setBackground(new Color(222, 237, 239));
        miniBar.setPreferredSize(new Dimension(200, 45));
        miniBar.setLayout(new FlowLayout());
        miniBar.setLocation(600, 50);

        Buttons buttonList = Buttons.create(RESOURCE_PATH, canvas);
        List<Button> buttons = buttonList.getButtons();
        ButtonRepository.getInstance().addAll(buttons);
        buttons.forEach(miniBar::add);
    }

    public JPanel getPanel() {
        return this;
    }
}
