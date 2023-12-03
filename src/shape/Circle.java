package shape;

import java.awt.*;

public class Circle implements Shape {
    private int x, y, radius;
    private boolean isSelected;
    public Circle(){}

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        //반지름
    }

    public void draw(Graphics2D g2d) {
        g2d.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);

        // 선택된 원 주위에 점선으로 사각형을 그립니다.
        if (isSelected) {
            g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{5}, 0));
            g2d.setColor(Color.BLUE);
            g2d.drawRect(
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

            g2d.setColor(Color.BLUE);
            g2d.fillOval(rectX - circleRadius, rectY - circleRadius, circleRadius * 2, circleRadius * 2);
            g2d.fillOval(rectX + rectWidth - circleRadius, rectY - circleRadius, circleRadius * 2, circleRadius * 2);
            g2d.fillOval(rectX + rectWidth - circleRadius, rectY + rectHeight - circleRadius, circleRadius * 2, circleRadius * 2);
            g2d.fillOval(rectX - circleRadius, rectY + rectHeight - circleRadius, circleRadius * 2, circleRadius * 2);

        }

        g2d.setStroke(new BasicStroke()); // 선 스타일을 원래대로 복구

    }

    @Override
    public boolean contains(int x, int y) {
        int distanceSquared = (int) (
                Math.pow(x - this.x, 2) +
                        Math.pow(y - this.y, 2)
        );
        int radiusSquared = (int) Math.pow(radius, 2);
        return distanceSquared <= radiusSquared;
    }

    @Override
    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    @Override
    public boolean getSelected() {
        boolean b=isSelected;
        return b;
    }

}

