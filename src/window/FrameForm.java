package window;

import javax.swing.*;
import java.awt.*;


public class FrameForm extends JFrame {
    private static final String TITLE = "Paint Board";
    private static final String SYSTEM_ICON = "src/resource/paintBoard.png";
    private static final int FRAME_WIDTH = 1000;
    private static final int FRAME_HEIGHT = 530;

    private FrameForm() {
        setTitle(TITLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLocationRelativeTo(null);

        ImageIcon imageIcon = new ImageIcon(SYSTEM_ICON);
        setIconImage(imageIcon.getImage());

        add(new PanelForm());
        add(new ToolBarForm(), BorderLayout.WEST); // display left toolbar

        setVisible(true);
    }

    public static FrameForm create(){
        return new FrameForm();
    }

}
