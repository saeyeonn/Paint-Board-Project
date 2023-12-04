package shape;

import java.awt.*;

public class Rectangular implements Shape{
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

    private Rectangular() {}
    public Rectangular(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isSelected = false;
        this.isResizing = false;
        this.resizingCorner = NO_RESIZE;
    }


    @Override
    public void drawBorder(Graphics2D graphics2D) {
        graphics2D.setColor(Color.BLACK);
        // System.out.println("사각형 그려보자");
        graphics2D.drawRect(x, y, width, height);
        // System.out.println("다 그렸다");

        if (isSelected) {
            Stroke oldStroke = graphics2D.getStroke();
            graphics2D.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{2}, 0));
            graphics2D.setColor(Color.BLUE);
            graphics2D.drawRect(x, y, width, height);
            graphics2D.setStroke(oldStroke);

            // 모서리 작은 동그라미 그리기
            graphics2D.setColor(Color.BLUE);
            graphics2D.fillOval(x - RESIZE_HANDLE_SIZE / 2, y - RESIZE_HANDLE_SIZE / 2, RESIZE_HANDLE_SIZE, RESIZE_HANDLE_SIZE);
            graphics2D.fillOval(x + width - RESIZE_HANDLE_SIZE / 2, y - RESIZE_HANDLE_SIZE / 2, RESIZE_HANDLE_SIZE, RESIZE_HANDLE_SIZE);
            graphics2D.fillOval(x + width - RESIZE_HANDLE_SIZE / 2, y + height - RESIZE_HANDLE_SIZE / 2, RESIZE_HANDLE_SIZE, RESIZE_HANDLE_SIZE);
            graphics2D.fillOval(x - RESIZE_HANDLE_SIZE / 2, y + height - RESIZE_HANDLE_SIZE / 2, RESIZE_HANDLE_SIZE, RESIZE_HANDLE_SIZE);
        }
        System.out.println("다시복귀");
    }

    @Override
    public boolean contains(int containX, int containY) {
        return containX >= x
                && containX <= x + width
                && containY >= y
                && containY <= y + height;
    }

    @Override
    public void move(int moveX, int moveY) {
        this.x = moveX;
        this.y = moveY;
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
