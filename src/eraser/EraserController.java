package eraser;

import domain.panel.Canvas;

import java.awt.image.BufferedImage;

public class EraserController {
    public static boolean act = false;
    private BufferedImage image;
    private LineEraser lineEraser;
    private PixelEraser pixelEraser;

    public EraserController(Canvas canvas) {
            pixelEraser = new PixelEraser(canvas);
    }
    private int startX, startY, endX, endY;
    public void activateLineEraser() {
        LineEraser lineEraser = new LineEraser(image);
        lineEraser.eraseLine(startX, startY, endX, endY);
    }
     public void activatePixelEraser(boolean bool) {
        pixelEraser.setEraserActivated(bool);
        act = true;
    }
    public void NotActivatePixelEraser() {
        pixelEraser.setEraserActivated(false);
        act = false;
    }

}
