package shape;

import java.awt.*;

public class Shape {
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean isLine;
    private boolean isRectangle;
    private boolean isTriangle;
    private boolean isCircle;

    private boolean isFilled = false;
    private Color fillColor;

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
        if (isFilled) { // 만약 내부를 채웠다면
            g.setColor(fillColor);
            if (isRectangle) {
                g.fillRect(x, y, width, height);
            } else if (isTriangle) {
                int[] xPoints = {x, x + width, x + width / 2};
                int[] yPoints = {y + height, y + height, y};
                g.fillPolygon(xPoints, yPoints, 3);
            } else if (isCircle) {
                g.fillOval(x, y, width, height);
            }
        } else { // 만약 내부를 채우지 않았다면
            g.setColor(Color.black);
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

    public void update(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean contains(int x, int y) {
        if (isRectangle) {
            return (x >= this.x && x <= this.x + this.width) &&
                    (y >= this.y && y <= this.y + this.height);
        } else if (isTriangle) {
            int x1 = this.x, y1 = this.y;
            int x2 = this.x + this.width, y2 = this.y;
            int x3 = this.x + this.width / 2, y3 = this.y + this.height;

            // 각 변과 주어진 점을 잇는 벡터의 외적
            int crossProduct1 = (x2 - x1) * (y - y1) - (x - x1) * (y2 - y1);
            int crossProduct2 = (x3 - x2) * (y - y2) - (x - x2) * (y3 - y2);
            int crossProduct3 = (x1 - x3) * (y - y3) - (x - x3) * (y1 - y3);

            // 모두 같은 부호이면 삼각형 내부
            return (crossProduct1 >= 0 && crossProduct2 >= 0 && crossProduct3 >= 0) ||
                    (crossProduct1 <= 0 && crossProduct2 <= 0 && crossProduct3 <= 0);
        } else if (isCircle) {
            int centerX = this.x + this.width / 2;
            int centerY = this.y + this.height / 2;
            int radius = this.width / 2;
            int dx = centerX - x;
            int dy = centerY - y;
            return dx * dx + dy * dy <= radius * radius;
        }
        return false;

    }

    public void setColor(Color color) {
        this.fillColor = color;
    }

    public void setFillMode(boolean isFillMode) {
        this.isFilled = isFillMode;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
