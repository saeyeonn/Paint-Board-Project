package utility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class Cut {
    private static JFrame frame;
    private static JPanel drawPanel;
    private Shape selectedShape;
    private Shape clippedShape;
    public List<Shape> shapesList;

    // 기존에 생성된 JFrame과 JPanel을 받아오는 생성자
    public Cut(JFrame frame, JPanel drawPanel) {
        Cut.frame = frame;
        Cut.drawPanel = drawPanel;

        // 기존에 생성된 JPanel에 마우스 이벤트 추가
        drawPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                // 마우스 클릭 시 도형 선택 로직 추가
                selectedShape = getSelectedShapeAt(e.getX(), e.getY());
                if (selectedShape != null) {
                    cutSelectedShape();
                }
            }
        });
    }

    // 선택된 도형을 오려내는 메서드
    public void cutSelectedShape() {
        if (selectedShape != null) {
            clippedShape=selectedShape;
            drawPanel.remove((Component) selectedShape);

            selectedShape=null;
           drawPanel.repaint();
        }
    }

    // 마우스 클릭 위치에서 도형을 찾는 메서드 (예시용)
    private Shape getSelectedShapeAt(int x, int y) {
        for (int i = 0; i < shapesList.size(); i++) {
            Shape shape = shapesList.get(i);

            if (shape.contains(x, y)) {
                return shape;
            }
        }

        return null;

    }


}
