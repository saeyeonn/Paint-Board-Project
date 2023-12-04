package shape;

import java.util.ArrayList;
import java.util.List;<<<<<<< HEAD
public class ShapeMaker {
    public ShapeMaker() {
        // Shape 생성하는 코드
    }
=======
import domain.panel.Canvas;

import java.util.ArrayList;
import java.util.List;

public class ShapeMaker {

    private List<Shape> shapeList = new ArrayList<>();
    private Shape shape;
    private Canvas canvas;

    public ShapeMaker(Canvas canvas) {
        this.canvas = canvas;
    }

    public void addShape(String name) {
        if (name.equals("17_line")) {
            shape = new Line(0,0,40,40);
        } else if (name.equals("18_rectangular")) {
            shape = new Rectangular(0, 0, 60, 60);
        } else if (name.equals("19_triangle")) {
            shape = new Triangle(0, 0, 40, 80, -40, 80);
        } else if (name.equals("20_circle")) {
            shape = new Circle(0, 0, 50);
        }

        shapeList.add(shape);
    }

    public Shape getShape() {
        return shape;
    }

    public List<Shape> getShapeList() {
        return shapeList;
    }


>>>>>>> c4783ecfd5390539b393bfb3752884db3dff2b06
}
