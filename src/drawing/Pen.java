package drawing;

import javax.swing.*;
import java.awt.*;

public class Pen{




}

class Graphic extends JFrame {
    Graphics graphics = getGraphics();
    Graphics2D graphics2D = (Graphics2D) graphics;

    public Graphics2D getGraphics2D(){
        return graphics2D;
    };
}
