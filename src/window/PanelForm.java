package window;

import javax.swing.*;

import java.awt.*;

public class PanelForm extends JPanel{ //undo redo 있는 위쪽 중앙 박스
    public PanelForm() {
        add(MiniBarForm.getInstance(), BorderLayout.NORTH);
        setBackground(Color.WHITE);
        setLayout(new FlowLayout());
    }
}
