package window;


import text.TextBox;
import zoom.Zoom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PanelForm extends JPanel{
    private TextBox textBox;
    private ShapingController shapingController;
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);//패널 초기화=다 지움
        Graphics2D g2d = (Graphics2D) g;

        List<Shape> note=shapingController.sibal();
        int i=0;
        for (Shape shape : note){
            i++;
            System.out.println(i+"개");
            shape.draw(g2d);
        }
    }

    public PanelForm() {
        add(MiniBarForm.getInstance(), BorderLayout.NORTH); // add minibar
        setBackground(Color.white);
        setLayout(new FlowLayout());



            @Override
            public void mouseClicked(MouseEvent e) {
                textBox.click(e);
                textBox.arrangeTextBoxes(); // 위치 설정 추가
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }
            @Override

            }
            @Override
            public void mouseReleased(MouseEvent e) {
                shapingController.release();
            }

        });

        // 마우스 휠 리스너 추가
        addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                // 마우스 휠 움직임에 따라 zoom 처리
                int notches = e.getWheelRotation();
                if (notches < 0) {
                    // 마우스 휠을 위로 돌리면 줌 인
                    zoom.zoomIn();
                } else {
                    // 마우스 휠을 아래로 돌리면 줌 아웃
                    zoom.zoomOut();
                }
                repaint();
            }
        });

    }

    public synchronized void addMouseMotionListener(MouseMotionListener l) {

    }

}
