package window;

import javax.swing.*;

import java.awt.*;

public class PanelForm extends JPanel{
    public PanelForm() {
        add(MiniBarForm.getInstance(), BorderLayout.NORTH);
        setBackground(Color.WHITE);
        setLayout(new FlowLayout());
    }
}
