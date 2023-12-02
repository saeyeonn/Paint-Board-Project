package drawing;


import window.PanelForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Pen implements Draw {int startX=0; // 마우스클릭시작의 X좌표값이 저장될 변수
    int startY; // 마우스클릭시작의 Y좌표값이 저장될 변수
    int endX; // 마우스클릭종료의 X좌표값이 저장될 변수
    int endY;

    boolean tf = false;

    class Graphic extends JFrame {
        Graphics graphics = getGraphics();
        Graphics2D graphics2D = (Graphics2D) graphics;

        public Graphics2D getGraphics2D(){
            return graphics2D;
        };
    }
    public Pen(){

        PanelForm panel= new PanelForm();
        while (startX==0) {
            startX = panel.getStartX();
            startY = panel.getStartY();
        }
        System.out.println("Pen으로 좌표 전송성공");

        panel.addMouseMotionListener(new MousePath());

    }

    public class MousePath implements MouseMotionListener {
        //선이 그어질때 쓰이는 공통적인 메소드
        // 위에서 paint_panel에 MouseMotionListener액션 처리가 될때 현 클래스로 넘어와서 밑 문장을 실행

        @Override
        public void mouseDragged(MouseEvent e) {
            Graphic G= new Graphic();
            Graphics2D g=G.getGraphics2D();
            g.setColor(Color.BLACK);
            endX = e.getX();
            // 드래그 되는 시점에서 X좌표가 저장 - 밑에서 시작좌표와 끝좌표를 연결 해주어 선이 그어지게된다.

            endY = e.getY();
            // 드래그 되는 시점에서 Y좌표가 저장 - 밑에서 시작좌표와 끝좌표를 연결 해주어 선이 그어지게된다.

            g.drawLine(startX+10, startY+121, endX+10, endY+121); // 라인이 그려지게 되는부분

            startX = endX;
            // 시작부분이 마지막에 드래그된 X좌표로 찍혀야 다음에 이어 그려질수 있다.
            startY = endY;
            // 시작부분이 마지막에 드래그된 Y좌표로 찍혀야 다음에 이어 그려질수 있다.
            System.out.println("끝점 좌표");
        }
        @Override
        public void mouseMoved(MouseEvent e) {}
        /* 인터페이스화 했기 때문에 그 인터페이스에 정의된  메소드를 전부다 오버라이딩 해줘야 함으로 굳이 사용되지지
             않는 메소드도 서브 클래스에서 전부다 오버라이딩 해줘야한다. */

    }

}



