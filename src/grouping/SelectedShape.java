package grouping;

import domain.panel.Canvas;
import shape.Shape;
import shape.Shapes;

import java.awt.event.MouseEvent;
import java.util.List;

public class SelectedShape {
    private Shape curShape;
    private List<Shape> shapes = Shapes.shapes;
    private Canvas canvas;

    public SelectedShape() {

    }

    public SelectedShape(Canvas canvas) {
        this.canvas = canvas;
    }

    public void click(MouseEvent e) {
        // 새로운 선택을 확인하기 전에 이전 선택을 초기화합니다.
        if (shapes != null) {
            for (Shape shape : shapes) {
                if (shape.getSelected()) {
                    shape.setSelected(false);
                }
            }
        }

        // 클릭된 위치에서 도형을 찾아 선택합니다.
        Shape clickedShape = new SelectedShape(e.getX(), e.getY()).getSelectedShape();
        if (clickedShape != null) {
            clickedShape.setSelected(true);
            System.out.println("클릭된 도형: " + clickedShape);
        }

        // 캔버스를 다시 그리거나 필요한 업데이트를 수행합니다.
        canvas.repaint();
    }

    // 마우스 클릭한 위치에 있는 도형을 찾아 반환
    public SelectedShape(int x, int y) {
        if (shapes != null) {
            for (Shape shape : shapes) {
                if (shape.contains(x, y)) {
                    shape.setSelected(true);
                    curShape = shape;
                }
            }
        }
    }

    public Shape getSelectedShape() {
        System.out.println("선택됨"+curShape);
        return curShape;
    }
}
