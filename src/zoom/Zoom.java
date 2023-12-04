package zoom;

import domain.panel.Canvas;

import javax.swing.*;

public class Zoom extends JPanel{
    private static double zoomFactor = 1.0; // 확대 축소 비율
    private final Canvas canvas;

    public Zoom(Canvas canvas) {
        this.canvas = canvas;
    }

    public void zoomIn() {
        zoomFactor *= 1.1; // 필요에 따라 조절
        notifyCanvas();
        System.out.println("줌 인"+zoomFactor);
    }

    public void zoomOut() {
        zoomFactor /= 1.1; // 필요에 따라 조절
        if (zoomFactor < 1.0) {
            zoomFactor = 1.0; // 최소 줌 아웃 값
            notifyCanvas();
        }

        System.out.println("줌 아웃"+zoomFactor);
    }

    public double getZoomFactor() {
        return zoomFactor;
    }

    private void notifyCanvas() {
        canvas.applyZoom();
    }

}