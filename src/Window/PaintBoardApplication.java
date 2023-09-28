package Window;

import javax.swing.*;
import java.awt.*;

public class PaintBoardApplication {
    public PaintBoardApplication() {
        Frame frame = new Frame();
        frame.createFrame();

        Panel panel = new Panel();
        panel.createPanel(frame);

        ToolBar toolBar = new ToolBar(frame);
        frame.add(toolBar, BorderLayout.WEST);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new PaintBoardApplication();
    }
}
