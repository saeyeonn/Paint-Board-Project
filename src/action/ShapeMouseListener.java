package action;

import domain.panel.Canvas;
import shape.Shape;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ShapeMouseListener {
  /*  private Canvas canvas;

    private static Shape currentShape;
    private static List<Shape> shapes= new ArrayList<>();

    public ShapeMouseListener(Canvas canvas) {
        this.canvas = canvas;
        canvas.add(press(e);)
    }
    public void press(MouseEvent e){ //mousePressed
        if (shapes!=null) {
            for (Shape shape : shapes) {
                if (shape.getSelected()) {
                    shape.setSelected(false);
                    //이전에 선택된 도형 해제
                }
            }
        }
        System.out.println("이전 도형 해제");
        Shape clickedShape = getSelectedShape(e.getX(), e.getY());

        if (currentShape != null && clickedShape == null) {
            System.out.println("if");
            // 도형 버튼이 눌린 상태에서 패널을 클릭하면 현재 도형을 생성하여 리스트에 추가
            currentShape.move(e.getX(), e.getY());
            shapes.add(currentShape);
            System.out.println("도형 그리기~");
            currentShape = null; // 현재 도형 초기화
        } else if (clickedShape != null) {
            System.out.println("else if");
            // 이미 생성된 도형을 클릭하면 해당 도형을 현재 도형으로 설정하여 이동 가능하게 함
            currentShape = clickedShape;
            System.out.println("선택된 도형");
        }
        System.out.println("둘다 아님"+currentShape+clickedShape);
        panel.repaint(); // 화면을 다시 그리도록 요청
    }

    public void drag(MouseEvent e){//mouseDragged
        // 마우스 드래그 동안 현재 도형의 위치를 업데이트
        if (currentShape != null) {
            currentShape.move(e.getX(), e.getY());
            SwingUtilities.invokeLater(() -> panel.repaint());
            // panel.repaint(); // 화면을 다시 그리도록 요청/
        }System.out.println("움직임");
    }
    public void release(){//mouseReleased
        currentShape = null; // 현재 그리고 있는 도형 초기화
        panel.repaint();
        System.out.println("해제");
    }

    // 마우스 클릭한 위치에 있는 도형을 찾아 반환
    private Shape getSelectedShape(int x, int y) {
        if (shapes!=null){
            for (Shape shape : shapes) {
                if (shape.contains(x, y)) {
                    shape.setSelected(true);
                    return shape;
                }
            }

        }
        return null;
    }
*/
}
