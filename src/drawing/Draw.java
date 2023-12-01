package drawing;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;

import org.w3c.dom.events.MouseEvent;

import button.Button;
import window.FrameForm;
import window.ToolBarForm;

public interface Draw {
    Color selectedColor; 
    // Graphics graphics;
    // Graphics2D g;
    
    int thickness = 10; // 현 변수는 그려지는 선의 굵기를 변경할때 변경값이 저장되는 변수
    int startX; 
    int startY; 
    int endX; 
    int endY;    
    boolean tf = false;

    default void draw(Button selectButton) {
        
        // graphics= getGraphics(); // Graphics2D 클래스의 사용을 위해 선언
        // g= (Graphics2D)graphics;
        // Graphics2D는 쉽게 말해 기존 graphics의 상위버전이라고 생각하시먄 됩니다.
        // 현 변수에 컬러가 저장되어 추후에 펜색상을 정해주는 변수의 매개변수로 사용된다.
       
        ToolBarForm.g.setColor(selectedColor);

        FrameForm.addMouseListener(new MouseListener() { 
            // paint_panel에서의 MouseListener 이벤트 처리
            public void mousePressed(MouseEvent e) { 
            // paint_panel에 마우스 눌림의 액션이 있을떄 밑 메소드 실행
                startX = e.getX(); // 마우스가 눌렸을때 그때의 X좌표값으로 초기화
                startY = e.getY(); // 마우스가 눌렸을때 그때의 Y좌표값으로 초기화
            }
            public void mouseClicked(MouseEvent e) {} // 클릭이벤트 처리
            public void mouseEntered(MouseEvent e) {} // paint_panel범위 내에 진입시 이벤트 처리
            public void mouseExited(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
        });

        FrameForm.addMouseMotionListener(new PaintDraw());
          // paint_panel에 마우스 모션리스너 추가
        selectButton.addActionListener(new ToolActionListener()); // 연필버튼 액션처리

        // colorSelect_bt.addActionListener(new ActionListener() {
        //   // 선색상버튼 액션처리를 익명클래스로 작성
        //     public void actionPerformed(ActionEvent e) { // 오버라이딩
        //         tf = true; // 위에서 변수 설명을 했으므로 스킵..
        //         JColorChooser chooser = new JColorChooser(); // JColorChooser 클래스객체화
        //         selectedColor = chooser.showDialog(null, "Color", Color.ORANGE); 
        //         // selectedColor에 선택된색으로 초기화
        //         g.setColor(selectedColor);
        //                 // 그려지는 펜의 색상을 selectedColor를 매개변수로 하여 지정
        //     }
        // });
    }
    
    public class PaintDraw implements MouseMotionListener {
        // 위에서 paint_panel에 MouseMotionListener액션 처리가 될때 현 클래스로 넘어와서 밑 문장을 실행

        @Override
        public void mouseDragged(MouseEvent e) { 
            // paint_panel에서 마우스 드래그 액션이 처리될떄 밑 메소드 실행
            thickness = Integer.parseInt(thicknessControl_tf.getText());
            // 텍스트필드부분에서 값을 값고와 thickness변수에 대입
            
                endX = e.getX(); 
                // 드래그 되는 시점에서 X좌표가 저장 - 밑에서 시작좌표와 끝좌표를 연결 해주어 선이 그어지게된다.

                endY = e.getY(); 
               // 드래그 되는 시점에서 Y좌표가 저장 - 밑에서 시작좌표와 끝좌표를 연결 해주어 선이 그어지게된다.

 
                g.setStroke(new BasicStroke(thickness, BasicStroke.CAP_ROUND,0)); //선굵기
                g.drawLine(startX+10, startY+121, endX+10, endY+121); // 라인이 그려지게 되는부분        
                
                startX = endX; 
                        // 시작부분이 마지막에 드래그된 X좌표로 찍혀야 다음에 이어 그려질수 있다.
                startY = endY;
                        // 시작부분이 마지막에 드래그된 Y좌표로 찍혀야 다음에 이어 그려질수 있다.
        }
        @Override
        public void mouseMoved(MouseEvent e) {}
        /* 인터페이스화 했기 때문에 그 인터페이스에 정의된  메소드를 전부다 오버라이딩 해줘야 함으로 굳이 사용되지지   
             않는 메소드도 서브 클래스에서 전부다 오버라이딩 해줘야한다. */



    }
    
    public class ToolActionListener implements ActionListener {
        // 연필,지우개 버튼의 액션처리시 실행되는 클래스
        public void actionPerformed(ActionEvent e ) {
                //implement해서 각각 구현
        }
    }
    }
}
