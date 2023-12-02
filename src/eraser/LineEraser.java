package eraser;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class LineEraser implements Erase, MouseListener {
    private final BufferedImage bufferedImage;

    // LineEraser 생성자
    public LineEraser(BufferedImage image) {
        this.bufferedImage = image;
    }


    @Override
    public void erasePixel(int x, int y) {
        //아무것도 안하는 코드
    }

    @Override
    public void eraseLine(int startX, int startY, int endX, int endY) {
        Graphics2D g = bufferedImage.createGraphics();
        g.setColor(Color.WHITE);
        g.setStroke(new BasicStroke(2));
        g.drawLine(startX, startY, endX, endY);
        g.dispose();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Graphics2D g = bufferedImage.createGraphics();
        System.out.println("찍힘");
        int x = e.getX();
        int y = e.getY();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("눌림");
        int x = e.getX();
        int y = e.getY();

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

    }

    @Override
    public void mouseExited(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

    }
}
