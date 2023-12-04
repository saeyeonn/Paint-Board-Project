package doing;

import domain.panel.Canvas;
import grouping.SelectedShape;
import shape.Shape;
import shape.Shapes;

import java.util.List;

public class Doing { // 언두 리두를 총괄합니다
    private static List<Shape> shapes = Shapes.shapes;
    private static List<Shape> doingList = DoingList.doingList;
    private static Canvas canvas;
    private Shape cutShape;
    private SelectedShape selectedShape = new SelectedShape();

    public Doing(Canvas canvas) {
        this.canvas = canvas;
    }

    public void undo() {
        if (!shapes.isEmpty()) {
            doingList.add(shapes.remove(shapes.size() - 1));
            canvas.repaint();
        }
    }

    public void redo() {
        if (!doingList.isEmpty()) {
            shapes.add(doingList.remove(doingList.size() - 1));
            canvas.repaint();
        }
    }

    public void cut() {
        cutShape = selectedShape.getSelectedShape();
        if (cutShape != null) {
            shapes.remove(cutShape);
            canvas.repaint();
        }
    }

    public void paste() {
        if (cutShape != null) {
            shapes.add(cutShape);
            cutShape = null;
            canvas.repaint();
        }
    }

}
