package shape;

import java.awt.Graphics;

public class Shape {
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

    public void draw(Graphics g) {
        if (isRectangle) {
            g.drawRect(x, y, width, height);
        } else if (isTriangle) {
            int[] xPoints = {x, x + width, x + width / 2};
            int[] yPoints = {y + height, y + height, y};
            g.drawPolygon(xPoints, yPoints, 3);
        } else if (isCircle) {
            g.drawOval(x, y, width, height);
        } else if (isLine) {
            g.drawLine(x, y, x + width, y + height);
        }
    }
}
