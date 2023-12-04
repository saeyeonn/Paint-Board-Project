package doing;

import domain.panel.Canvas;
import shape.Shape;
import shape.ShapeMaker;
import shape.Shapes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Doing { // 언두 리두를 총괄합니다
    private static Map<ShapeMaker, Shape> shapes = Shapes.shapes;
    private static List<ShapeMaker> doingList = DoingList.doingList;
    private static Canvas canvas;

    public Doing() {
        
    }

    public Doing(Canvas canvas) {
        this.canvas = canvas;
    }

    public void undo() {
        if (!shapes.isEmpty()) {
            int lastIndex = shapes.size() - 1;
            ShapeMaker removedShapeMaker = new ArrayList<>(shapes.keySet()).get(lastIndex);
            doingList.add(removedShapeMaker);
            canvas.repaint();
        }
    }

    public void redo() {
        if (!doingList.isEmpty()) {
            int lastIndex = doingList.size() - 1;
            ShapeMaker shapeMakerToAdd = doingList.get(lastIndex);
            Shape shape = shapes.get(shapeMakerToAdd);

            if (shape != null) {
                shapes.remove(shapeMakerToAdd);
                canvas.repaint();
            }
        }
    }
}
