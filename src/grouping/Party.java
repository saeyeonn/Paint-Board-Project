package grouping;

import shape.Shape;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Party {//통채로 추가
    List<Shape> shapes;

    public Party() {
        this.shapes = new ArrayList<>();
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void move(int deltaX, int deltaY) {
        for (Shape shape : shapes) {
            int x=shape.getX();
            shape.setX(x+deltaX);
            int y=shape.getY();
            shape.setY(y+deltaY);
        }
    }

    public void draw(Graphics g) {
        for (Shape shape : shapes) {
//            shape.draw(g);
        }
    }

    public boolean contains(Point p) {
        for (Shape shape : shapes) {
//            if (shape.contains(p)) {
//                return true;
//            }
        }
        return false;
    }

    public void setSelected(boolean selected) {
        for (Shape shape : shapes) {
//            shape.selected = selected;
        }
    }

    public boolean isSelected(Point startPoint) {
        return false;
    }
}
