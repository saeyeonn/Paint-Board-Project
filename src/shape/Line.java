package shape;

import java.awt.*;
public class Line implements Shape {
    
    private static int x1, y1, x2, y2;
    private boolean isSelected;

    public Line(){}

    public Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.drawLine(x1, y1, x2, y2);

        // 선택된 선 주위에 점선으로 사각형을 그립니다.
        if (isSelected) {
            int minX = Math.min(x1, x2);
            int minY = Math.min(y1, y2);
            int maxX = Math.max(x1, x2);
            int maxY = Math.max(y1, y2);

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
        // 선의 경우, 선택 여부를 판단하는데 있어 실제 선 상의 좌표를 고려하여 처리해야 할 수도 있습니다.
        // 여기서는 간단하게 점과 점 사이의 거리를 이용하여 판단하는 방식을 사용하겠습니다.
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double d1 = Math.sqrt(Math.pow(x - x1, 2) + Math.pow(y - y1, 2));
        double d2 = Math.sqrt(Math.pow(x - x2, 2) + Math.pow(y - y2, 2));
        return Math.abs(distance - (d1 + d2)) <= 1; // 정확한 거리 판단을 위해 오차 1 이내로 판단
    }

    @Override
    public void move(int x, int y) {
        if (x1==0 && y1==0) { //초기상태이면, 즉 시작점을 아직 안받았으면
            x1=x;
            y1=y;
        } else{ //끝점 받을때
            x2=x;
            y2=y;
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
}

