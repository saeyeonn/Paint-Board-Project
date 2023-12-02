package window;

import window.panel.Canvas;
import window.panel.ToolBar;

import javax.swing.*;

import static java.awt.BorderLayout.WEST;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class Board {
    private static final String TITLE = "Paint Board";
    private static final String SYSTEM_ICON = "src/resource/paintBoard.png";
    private static final int FRAME_WIDTH = 1000;
    private static final int FRAME_HEIGHT = 530;

    private final JFrame frame; // 전체 프레임 원본
    private final Canvas canvasPanel; // 캔버스 패널 : 백지 패널, 미니바 패널
    private final ToolBar toolBar; // 툴바 패널 : 좌측 패널

    private Board() {
        JFrame mainFrame = new JFrame();
        initFrameConstraints(mainFrame);

        Canvas canvas = Canvas.create();
        ToolBar toolBar = ToolBar.create();

        JPanel canvasPanel = canvas.getPanel();
        JPanel toolBarPanel = toolBar.getPanel();

        mainFrame.add(canvasPanel);
        mainFrame.add(toolBarPanel, WEST);

        this.frame = mainFrame;
        this.canvasPanel = canvas;
        this.toolBar = toolBar;
    }

    private void initFrameConstraints(JFrame mainFrame) {
        mainFrame.setTitle(TITLE);
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        mainFrame.setLocationRelativeTo(null);

        ImageIcon imageIcon = new ImageIcon(SYSTEM_ICON);
        mainFrame.setIconImage(imageIcon.getImage());
    }

    public static Board create() {
        return new Board();
    }

    public void show() {
        frame.setVisible(true);
    }
}
