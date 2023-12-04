package action;

import domain.panel.Canvas;
import eraser.EraserController;
import eraser.PixelEraser;
import shape.Shape;
import text.TextBox;
import util.ImageLoading;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class PanelMouseListener {
    private Canvas canvas;
    private TextBox textBox;
    private PixelEraser pixelEraser;


    public PanelMouseListener(Canvas canvas) {
        this.canvas = canvas;
        addMouseListener();
    }

    private void addMouseListener() {
        textBox = new TextBox(canvas);
        pixelEraser = new PixelEraser(canvas);

        canvas.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textBox.click(e);
                textBox.arrangeTextBoxes(); // 위치 설정 추가
            }

            @Override
            public void mousePressed(MouseEvent e) {
            /*    if (pixelEraser != null && EraserController.act) {
                    pixelEraser.setEraserActivated(true);
                    System.out.println(EraserController.act);
                } else {
                    pixelEraser.setEraserNotActivated();
                }*/
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }


}
