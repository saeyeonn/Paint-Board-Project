package shape;

import domain.panel.Canvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ShapeDrawer extends Canvas{
    // Move, Resize, Draw, Spin 등 도형의 활동
    private static Shape currentShape;
    private static List<Shape> shapes= new ArrayList<>();

    private ShapeDrawer(){
        super();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        shapes = drawAll();
        int i=0;
        for (Shape shape : shapes){
            i++;
            System.out.println(i+"개");
            shape.draw(g2d);
        }

    }

    //---------------버튼 클릭시 초기 도형 생성-----------------
    private void iniRect(){
        Rectangle rectangle= new Rectangle(0, 0, 60, 60);
        shapes.add(rectangle);
        System.out.println("만들어짐" + currentShape);
        System.out.println("사각형");
    }

    private void iniTri(){
        Triangle triangle = new Triangle(0, 0, 40, 80, -40, 80);
        shapes.add(triangle);
        System.out.println("만들어짐" + currentShape);
        System.out.println("삼각형");
    }
    private void iniCir(){
        Circle circle = new Circle(0, 0, 50);
        shapes.add(circle);
        System.out.println("만들어짐" + currentShape);
        System.out.println("동그라미");
    }

    // JPanel의 paintComponent 메서드를 오버라이드하여 도형을 그리는 기능을 추가
    public List<Shape> drawAll() {
        System.out.println("초기화 후 sc에 진입");
        List<Shape> drawShapeList = new ArrayList<>();

        // 모든 도형을 그립니다.
        if (shapes!=null){
            drawShapeList.addAll(shapes);
        }
        System.out.println("전체 도형 그리기 완료");

        // 현재 그리고 있는 도형을 그립니다.
        if (currentShape != null) {
            drawShapeList.add(currentShape);
        }
        System.out.println("현재 도형 그리기 완료");
        return drawShapeList;
    }

    public Shape getCurrentShape() {
        return currentShape;
    }

    public List<Shape> getShapes() {
        return shapes;
    }
}
