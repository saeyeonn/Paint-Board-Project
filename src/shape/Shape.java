package shape;

import java.awt.*;

public interface Shape {
    void drawBorder(Graphics2D graphics2D);
    boolean contains(int x, int y);
    void move(int x, int y);
    void setSelected(boolean selected);
    boolean getSelected();
    Shape getShape();

}
