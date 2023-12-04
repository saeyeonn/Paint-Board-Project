// package drawing;

// import java.awt.Color;
// import java.awt.Graphics2D;
// import java.awt.Point;
// import java.util.ArrayList;
// import java.util.List;

// import javax.swing.*;
// import java.awt.event.MouseEvent;

// public class Drawing extends JPanel{
//     private JPanel panel;

//     private List<Shape> shapes = new ArrayList<>();
//     // private List<Shape> redoList = Doing.redoList;
//     private Shape currentShape = null;
//     private static boolean isDrawing = false;

//     public Drawing() {
//         System.out.println("생성자");
//     }

//     public Drawing(JPanel panel) {
//         this.panel = panel;    
//     }

//     // 버튼 누르면 생성 가능 상태가 됨
//     public void activeDrawing() {
//         isDrawing = true;
//         System.out.println("버튼 눌림!");
//     }

//     public void deactiveDrawing(){
//         isDrawing = false;
//         System.out.println("버튼 해제!");
//     }

//     public void click(MouseEvent e){
//         // 생성 가능 상태 일 때 (버튼을 눌렀을 때) 생성
//         if (isDrawing) { 
//             currentShape = new Shape();
//             currentShape.addPoint(e.getPoint());
//             repaint();
//             System.out.println("그리기 시~작!");
//         }
//     }

//     public void Release(MouseEvent e) {
//         if (isDrawing && currentShape != null) {
//             currentShape.addPoint(e.getPoint());
//             shapes.add(currentShape);
//             currentShape = null;
//             // redoList.clear();
//             repaint();
//             System.out.println("그리기 끝!");
//         }
//     }

//     public void Drag(MouseEvent e) {
//         if (isDrawing && currentShape != null) {
//             currentShape.addPoint(e.getPoint());
//             repaint();
//             System.out.println("그리는 중...");
//         }
//     }

//     // @Override
//     // protected void paintComponent(Graphics g) {
//     //     super.paintComponent(g); // 상위 클래스의 paintComponent 메서드 호출

//     //     Graphics2D g2d = (Graphics2D) g; // Graphics2D 객체로 캐스팅

//     //     // 저장된 도형들을 그림
//     //     for (Shape shape : shapes) {
//     //         shape.draw(g2d);
//     //     }

//     //     // 그리기 상태이고, 현재 그리고 있는 도형이 존재하면 해당 도형을 그림
//     //     if (isDrawing && currentShape != null) {
//     //         currentShape.draw(g2d);
//     //     }
//     // }

// }

// class Shape {
//     private List<Point> points;

//     public Shape() {
//         points = new ArrayList<>();
//     }

//     public void addPoint(Point point) {
//         points.add(point);
//     }

//     public void draw(Graphics2D g2d) {
//         g2d.setColor(Color.BLACK);
//         for (int i = 0; i < points.size() - 1; i++) {
//             Point p1 = points.get(i);
//             Point p2 = points.get(i + 1);
//             g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
//         }
//     }
// }
