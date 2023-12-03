package shape;

import java.awt.*;

public class Rectangle implements Shape {
    private int x, y, width, height;
    private boolean isSelected;
    private boolean isResizing;
    private int resizingCorner;

    private static final int RESIZE_HANDLE_SIZE = 10;
    private static final int NO_RESIZE = -1;
    private static final int TOP_LEFT = 0;
    private static final int TOP_RIGHT = 1;
    private static final int BOTTOM_RIGHT = 2;
    private static final int BOTTOM_LEFT = 3;



    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isSelected = false;
        this.isResizing = false;
        this.resizingCorner = NO_RESIZE;

    }

    @Override
    public void draw(Graphics2D g2d) {
        // 사각형을 그리는 로직
        g2d.setColor(Color.BLACK);
        System.out.println("사각형 그려보자");
        g2d.drawRect(x, y, width, height);

        if (isSelected) {
            Stroke oldStroke = g2d.getStroke();
            g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{2}, 0));
            g2d.setColor(Color.BLUE);
            g2d.drawRect(x, y, width, height);
            g2d.setStroke(oldStroke);

            // 모서리 작은 동그라미 그리기
            g2d.setColor(Color.BLUE);
            g2d.fillOval(x - RESIZE_HANDLE_SIZE / 2, y - RESIZE_HANDLE_SIZE / 2, RESIZE_HANDLE_SIZE, RESIZE_HANDLE_SIZE);
            g2d.fillOval(x + width - RESIZE_HANDLE_SIZE / 2, y - RESIZE_HANDLE_SIZE / 2, RESIZE_HANDLE_SIZE, RESIZE_HANDLE_SIZE);
            g2d.fillOval(x + width - RESIZE_HANDLE_SIZE / 2, y + height - RESIZE_HANDLE_SIZE / 2, RESIZE_HANDLE_SIZE, RESIZE_HANDLE_SIZE);
            g2d.fillOval(x - RESIZE_HANDLE_SIZE / 2, y + height - RESIZE_HANDLE_SIZE / 2, RESIZE_HANDLE_SIZE, RESIZE_HANDLE_SIZE);
        }
    }

    @Override
    public boolean contains(int x, int y) {
        // 좌표가 사각형 내부에 있는지 확인하는 로직
        return x >= this.x && x <= this.x + width && y >= this.y && y <= this.y + height;
    }

    @Override
    public void move(int x, int y) {
        // 사각형을 이동시키는 로직
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
