package shape;

import java.awt.*;

public class Line implements Shape{
    private static int x1, y1, x2, y2;
    private boolean isSelected;
    private Line(){}

    public Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void drawBorder(Graphics2D graphics2D) {
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawLine(x1, y1, x2, y2);

        // 선택된 선 주위에 점선으로 사각형을 그립니다.
        if (isSelected) {
            int minX = Math.min(x1, x2);
            int minY = Math.min(y1, y2);
            int maxX = Math.max(x1, x2);
            int maxY = Math.max(y1, y2);

            graphics2D.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{5}, 0));
            graphics2D.setColor(Color.BLUE);
            graphics2D.drawRect(minX - 3, minY -1, maxX - minX + 7, maxY - minY + 4);

            // 사각형의 네 꼭짓점에 원 그리기
            int[] rectXPoints = {minX - 5, maxX + 5, maxX + 5, minX - 5};
            int[] rectYPoints = {minY - 5, minY - 5, maxY + 5, maxY + 5};
            graphics2D.setColor(Color.BLUE);
            for (int i = 0; i < 4; i++) {
                graphics2D.fillOval(rectXPoints[i] - 5, rectYPoints[i] -4, 10, 10);
            }
        }
        graphics2D.setStroke(new BasicStroke());
    }

    @Override
    public boolean contains(int containX, int containY) {
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double d1 = Math.sqrt(Math.pow(containX - x1, 2) + Math.pow(containY - y1, 2));
        double d2 = Math.sqrt(Math.pow(containX - x2, 2) + Math.pow(containY - y2, 2));

        return Math.abs(distance - (d1 + d2)) <= 1;
    }

    @Override
    public void move(int moveX, int moveY) {
        if (x1 == 0 && y1 == 0) { //초기상태이면, 즉 시작점을 아직 안받았으면
            x1 = moveX;
            y1 = moveY;
        } else { //끝점 받을때
            x2 = moveX;
            y2 = moveY;
        }
    }

    @Override
    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    @Override
    public boolean getSelected() {
        return isSelected;
    }

    @Override
    public Shape getShape() {
        return this;
    }
}
