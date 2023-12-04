package shape;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Shape { // 각 shape의 속성값 저장
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean isLine;
    private boolean isRectangle;
    private boolean isTriangle;
    private boolean isCircle;

    public Shape(int x, int y, int width, int height, boolean isLine, boolean isRectangle, boolean isTriangle, boolean isCircle) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isLine = isLine;
        this.isRectangle = isRectangle;
        this.isTriangle = isTriangle;
        this.isCircle = isCircle;
    }

    public void draw(Graphics g, double zoomFactor, int offsetX, int offsetY) {
        Graphics2D g2d = (Graphics2D) g.create();

        AffineTransform at = new AffineTransform();
        at.translate((x - offsetX) * zoomFactor, (y - offsetY) * zoomFactor); // 현재 도형의 위치로 이동
        at.scale(zoomFactor, zoomFactor); // 확대 또는 축소
        g2d.transform(at);

        if (isRectangle) {
            int scaledWidth = (int) (width * zoomFactor);
            int scaledHeight = (int) (height * zoomFactor);
            g2d.drawRect(0, 0, scaledWidth, scaledHeight);
        } else if (isTriangle) {
            int[] xPoints = {0, (int) (width * zoomFactor), (int) ((width / 2) * zoomFactor)};
            int[] yPoints = {(int) ((height) * zoomFactor), (int) ((height) * zoomFactor), 0};
            g2d.drawPolygon(xPoints, yPoints, 3);
        } else if (isCircle) {
            int scaledWidth = (int) (width * zoomFactor);
            int scaledHeight = (int) (height * zoomFactor);
            g2d.drawOval(0, 0, scaledWidth, scaledHeight);
        } else if (isLine) {
            int scaledWidth = (int) (width * zoomFactor);
            int scaledHeight = (int) (height * zoomFactor);
            g2d.drawLine(0, 0, scaledWidth, scaledHeight);
        }

        g2d.dispose();
    }
}
