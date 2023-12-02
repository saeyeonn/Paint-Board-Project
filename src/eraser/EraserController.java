package eraser;

import action.ButtonAction;
import button.Button;

import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class EraserController implements MouseListener{

    private BufferedImage image;
    private LineEraser lineEraser;

    private int startX, startY, endX, endY;

    public EraserController(BufferedImage image) {
        this.image=image;

    }

    public void addButtonListener(Button eraserButton) {
        eraserButton.addActionListener(new ButtonAction());
        eraserButton.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                JButton clickedButton = (JButton) e.getSource();
                String buttonName = clickedButton.getName();
                if (buttonName.equals("21_lineEraser")) {
                    System.out.println("실험1");
                    activateLineEraser();
                } else if (buttonName.equals("22_pixelEraser")) {
                    activatePixelEraser();

            }



        }
        @Override
            public void focusLost(FocusEvent e) {

            }
        });}



        private void activateLineEraser() {
        LineEraser lineEraser = new LineEraser(image);

        lineEraser.eraseLine(startX, startY, endX, endY);
    }


    private void activatePixelEraser() {
        PixelEraser pixelEraser = new PixelEraser(image);
        pixelEraser.erasePixel(startX,startY);
    }

    public void useEraser(int startX, int startY, int endX, int endY) {
        // 필요한 기능 구현
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        startX = e.getX();
        startY = e.getY();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startX = e.getX();
        startY = e.getY();


    }

    @Override
    public void mouseReleased(MouseEvent e) {
        endX = e.getX();
        endY = e.getY();


    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
