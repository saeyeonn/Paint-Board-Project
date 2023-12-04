package shape;

import java.awt.*;

public class Circle implements Shape {
    private int x, y, radius;
    private boolean isSelected;
    private Circle(){}

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        //반지름
    }

    @Override
    public void drawBorder(Graphics2D graphics2D) {
        graphics2D.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);

        // 선택된 원 주위에 점선으로 사각형을 그립니다.
        if (isSelected) {
            graphics2D.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{5}, 0));
            graphics2D.setColor(Color.BLUE);
            graphics2D.drawRect(
                    x - radius - 5,
                    y - radius - 5,
                    2 * radius + 10,
                    2 * radius + 10
            );

            // 사각형의 네 꼭짓점에 원 그리기
            int rectX = x - radius - 5;
            int rectY = y - radius - 5;
            int rectWidth = 2 * radius + 10;
            int rectHeight = 2 * radius + 10;
            int circleRadius = 5;

            graphics2D.setColor(Color.BLUE);
            graphics2D.fillOval(rectX - circleRadius, rectY - circleRadius, circleRadius * 2, circleRadius * 2);
            graphics2D.fillOval(rectX + rectWidth - circleRadius, rectY - circleRadius, circleRadius * 2, circleRadius * 2);
            graphics2D.fillOval(rectX + rectWidth - circleRadius, rectY + rectHeight - circleRadius, circleRadius * 2, circleRadius * 2);
            graphics2D.fillOval(rectX - circleRadius, rectY + rectHeight - circleRadius, circleRadius * 2, circleRadius * 2);

        }

        graphics2D.setStroke(new BasicStroke());
    }

    @Override
    public boolean contains(int containX, int containY) {
        int distanceSquared = (int) (Math.pow(containX - x, 2) + Math.pow(containY - y, 2));
        int radiusSquared = (int) Math.pow(radius, 2);
        return distanceSquared <= radiusSquared;
    }

    @Override
    public void move(int moveX, int moveY) {
        x = moveX; y = moveY;
    }

    @Override
    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    @Override
    public boolean getSelected() {
        return isSelected;
    }

    public Shape getShape() {
        return this;
    }
}
