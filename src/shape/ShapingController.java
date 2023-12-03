package shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ShapingController {
    // Move, Resize, Draw, Spin 등 도형의 활동
    private static JPanel panel;
    private Shape currentShape;
    private List<Shape> shapes ;

    public ShapingController(){
        // 기본 생성자
    }
    public ShapingController(JPanel panel) {
        this.panel = panel;
    }

    //---------------버튼 클릭시 초기 도형 생성-----------------
    public void iniRect(){currentShape = new Rectangle(0, 0, 60, 60);
        System.out.println("초기 도형 설정");}
    public void iniTri(){currentShape = new Triangle(0, 0, 40, 80, -40, 80);}
    public void iniCir(){currentShape = new Circle(0, 0, 50);}

    // JPanel의 paintComponent 메서드를 오버라이드하여 도형을 그리는 기능을 추가
    public void drawShapes() {
        Graphics2D g2d = (Graphics2D) panel.getGraphics();
        System.out.println("초기화 후 sc에 진입");

        // 모든 도형을 그립니다.
        for (Shape shape : shapes) {
            shape.draw(g2d);
        }
        System.out.println("전체 도형 그리기 완료");

        // 현재 그리고 있는 도형을 그립니다.
        if (currentShape != null) {
            currentShape.draw(g2d);
        }
        System.out.println("현재 도형 그리기 완료");

    }
    //--------------------마우스 이벤트--------------------------
    public void press(MouseEvent e){ //mousePressed
        for (Shape shape : shapes) {
            if (shape.getSelected()) {
                shape.setSelected(false);
                //이전에 선택된 도형 해제
            }
        } System.out.println("이전 도형 해제");
        Shape clickedShape = getSelectedShape(e.getX(), e.getY());

        if (currentShape != null && clickedShape == null) {
            // 도형 버튼이 눌린 상태에서 패널을 클릭하면 현재 도형을 생성하여 리스트에 추가
            currentShape.move(e.getX(), e.getY());
            panel.getShapes().add(currentShape);
            System.out.println("도형 그리기~");
            currentShape = null; // 현재 도형 초기화
        } else if (clickedShape != null) {
            // 이미 생성된 도형을 클릭하면 해당 도형을 현재 도형으로 설정하여 이동 가능하게 함
            currentShape = clickedShape;
            System.out.println("선택된 도형");
        }

        panel.repaint(); // 화면을 다시 그리도록 요청
    }

    public void drag(MouseEvent e){//mouseDragged
        // 마우스 드래그 동안 현재 도형의 위치를 업데이트
        if (currentShape != null) {
            currentShape.move(e.getX(), e.getY());
            panel.repaint(); // 화면을 다시 그리도록 요청
        }System.out.println("움직임");
    }
    public void release(MouseEvent e){//mouseReleased
        currentShape = null; // 현재 그리고 있는 도형 초기화
        panel.repaint();
        System.out.println("해제");
    }

    // 마우스 클릭한 위치에 있는 도형을 찾아 반환
    private Shape getSelectedShape(int x, int y) {
        for (Shape shape : shapes) {
            if (shape.contains(x, y)) {
                shape.setSelected(true);
                return shape;
            }
        }
        return null;
    }
    //--------------------이전값 HashMap에 저장-----------









}
