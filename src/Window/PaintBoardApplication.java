package Window;

import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;

public class PaintBoardApplication extends JFrame{
    public PaintBoardApplication() {
        setTitle("Paint Board");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);

        ImageIcon imageIcon = new ImageIcon("src/ImageSource/paintBoard.png");
        setIconImage(imageIcon.getImage());

        BoardPanel boardPanel = new BoardPanel();
        add(boardPanel, BorderLayout.CENTER);

        JToolBar jToolBar = new JToolBar();
        ToolBar toolBar = new ToolBar();
        add(jToolBar, BorderLayout.WEST);
        toolBar.createToolBar(jToolBar);
        setVisible(true);
    }

    public static void main(String[] args) {
        new PaintBoardApplication();
    }
}
