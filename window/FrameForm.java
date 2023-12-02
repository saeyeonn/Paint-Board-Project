package window;

import javax.swing.*;
import java.awt.*;

public class FrameForm extends JFrame {
    private static final FrameForm frameForm = new FrameForm();
    private JPanel PanelForm;

    private FrameForm() { // set frame
        setTitle("Paint Board");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 530);
        setLocationRelativeTo(null);

        ImageIcon imageIcon = new ImageIcon("src/resource/paintBoard.png");
        setIconImage(imageIcon.getImage());

        add(new PanelForm()); // display panel (white)
        add(new ToolBarForm(), BorderLayout.WEST); // display left toolbar

        setVisible(true);
    }

    public static FrameForm getInstance() {
        return frameForm;
    }

    public JPanel getPanelForm() {
        return PanelForm;
    }
}
