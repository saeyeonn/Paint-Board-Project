package window;

import javax.swing.*;

import shape.Shape;
import shape.ShapingController;
import text.TextBox;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PanelForm extends JPanel{
    private TextBox textBox;

    ShapingController shapingController;

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);//패널 초기화=다 지움
        shapingController.drawShapes();
    }

    public PanelForm() {
        add(MiniBarForm.getInstance(), BorderLayout.NORTH); // add minibar
        setBackground(Color.WHITE);
        setLayout(new FlowLayout());

        textBox = new TextBox(PanelForm.this);
        shapingController = new ShapingController(this);



        addMouseListener(new MouseAdapter() {
            //MouseAdapter는 MouseListener 인터페이스를 구현한 추상 클래스
            //상위 호환 버전이라고 보면 됨. 모든 메서드를 구현할 필요없음.

            @Override
            public void mouseClicked(MouseEvent e) {
                textBox.click(e);
                textBox.arrangeTextBoxes(); // 위치 설정 추가
            }

            @Override
            public void mousePressed(MouseEvent e) {
                shapingController.press(e);
            }
            @Override
            public void mouseDragged(MouseEvent e){
                shapingController.drag(e);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                shapingController.release(e);
            }

        });
    }

    public synchronized void addMouseMotionListener(MouseMotionListener l) {

    }

}
