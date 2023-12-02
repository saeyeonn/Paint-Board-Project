package eraser;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class PixelEraser implements Erase, MouseMotionListener {
    private BufferedImage bufferedImage;


    public PixelEraser(BufferedImage image) {
        this.bufferedImage = image;
    }

    @Override
    public void erasePixel(int x, int y) {
        Graphics2D g = bufferedImage.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 1, 1);
        g.dispose();
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
    }
}


