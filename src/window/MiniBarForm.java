package window;

import button.Button;
import button.ButtonList;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MiniBarForm extends JPanel  {
    private static final MiniBarForm miniBarForm = new MiniBarForm();

    private MiniBarForm() { // set details of minibar
        setBackground(new Color(222, 237, 239));
        setPreferredSize(new Dimension(200, 45));
        setLocation(600,50);

        ButtonList buttonList = ButtonList.create("src/resource/miniBar");
        ArrayList<button.Button> buttonsList = buttonList.getButtons();

        for (Button button : buttonsList) {
            add(button);
        }
    }

    public static MiniBarForm getInstance() {
        return miniBarForm;
    }
}
