package zoom;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Zoom extends JPanel{
    private static double zoomFactor = 1.0; // 확대 축소 비율

    public Zoom() {
    }
    
    public void zoomIn() {
        zoomFactor *= 1.1; // 필요에 따라 조절

        System.out.println("줌 인");
    }

    public void zoomOut() {
        zoomFactor /= 1.1; // 필요에 따라 조절
        if (zoomFactor < 1.0) {
            zoomFactor = 1.0; // 최소 줌 아웃 값
        }

        System.out.println("줌 아웃");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.scale(zoomFactor, zoomFactor);

        // 여기에 그림을 그리는 코드 추가

        g2d.dispose();
    }

}