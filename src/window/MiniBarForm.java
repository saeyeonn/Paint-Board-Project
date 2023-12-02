package window;

import button.Button;
import button.ActionButtons;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MiniBarForm extends JPanel  {
    private static final MiniBarForm miniBarForm = new MiniBarForm();

    private MiniBarForm() { // set details of minibar
        setBackground(new Color(222, 237, 239));
        setPreferredSize(new Dimension(200, 45));
        setLayout(new FlowLayout());
        setLocation(600,50);

        ActionButtons buttonList = ActionButtons.create("src/resource/miniBar");
        List<Button> buttons = buttonList.getButtons();

        for (Button button : buttons) {
            add(button);
        }
    }

    public static MiniBarForm getInstance() {
        return miniBarForm;
    }
}
