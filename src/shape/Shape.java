package shape;

import java.awt.*;

public interface Shape {
    void draw(Graphics2D g2d);
    boolean contains(int x, int y);
    void move(int x, int y);
    void setSelected(boolean selected);
    boolean getSelected();

}
