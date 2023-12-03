package shape;

import java.awt.*;

public class Triangle implements Shape {
    private int[] xPoints;
    private int[] yPoints;
    private boolean isSelected;


    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        xPoints = new int[]{x1, x2, x3};
        yPoints = new int[]{y1, y2, y3};
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.drawPolygon(xPoints, yPoints, 3);

        // 선택된 삼각형 주위에 점선으로 사각형을 그립니다.
        if (isSelected) {
            int minX = Math.min(Math.min(xPoints[0], xPoints[1]), xPoints[2]);
            int minY = Math.min(Math.min(yPoints[0], yPoints[1]), yPoints[2]);
            int maxX = Math.max(Math.max(xPoints[0], xPoints[1]), xPoints[2]);
            int maxY = Math.max(Math.max(yPoints[0], yPoints[1]), yPoints[2]);

            g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{5}, 0));
            g2d.setColor(Color.BLUE);
            g2d.drawRect(minX - 3, minY -1, maxX - minX + 7, maxY - minY + 4);

            // 사각형의 네 꼭짓점에 원 그리기
            int[] rectXPoints = {minX - 5, maxX + 5, maxX + 5, minX - 5};
            int[] rectYPoints = {minY - 5, minY - 5, maxY + 5, maxY + 5};
            g2d.setColor(Color.BLUE);
            for (int i = 0; i < 4; i++) {
                g2d.fillOval(rectXPoints[i] - 5, rectYPoints[i] -4, 10, 10);
            }
        }
        g2d.setStroke(new BasicStroke()); // 선 스타일을 원래대로 복구
    }
    @Override
    public boolean contains(int x, int y) {
        Polygon polygon = new Polygon(xPoints, yPoints, 3);
        return polygon.contains(x, y);
    }

    @Override
    public void move(int x, int y) {
        int deltaX = x - xPoints[0];
        int deltaY = y - yPoints[0];

        for (int i = 0; i < 3; i++) {
            xPoints[i] += deltaX;
            yPoints[i] += deltaY;
        }
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
