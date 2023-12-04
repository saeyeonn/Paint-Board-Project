package shape;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.Objects;

public class Shape { // 각 shape의 속성값 저장

    private int x;
    private int y;
    private int width;
    private int height;
    private boolean isLine;
    private boolean isRectangle;
    private boolean isTriangle;
    private boolean isCircle;
    private boolean isSelected;//추가

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

    //-------------------밑에 추가------------------
    // Getter and Setter for x
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    // Getter and Setter for y
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    // Getter and Setter for width
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    // Getter and Setter for height
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public void setSelected(boolean selected) {
        isSelected = selected;
    }
    public boolean getSelected() {
        return isSelected;
    }

    public boolean contains(int x, int y) {
        return (this.x <= x && x <= this.x + this.width && this.y <= y && y <= this.y + this.height);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Shape shape = (Shape) obj;
        return isSelected == shape.isSelected &&
                x == shape.x &&
                y == shape.y &&
                width == shape.width &&
                height == shape.height &&
                isLine == shape.isLine &&
                isRectangle == shape.isRectangle &&
                isTriangle == shape.isTriangle &&
                isCircle == shape.isCircle;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, width, height, isLine, isRectangle, isTriangle, isCircle, isSelected);
    }

}
