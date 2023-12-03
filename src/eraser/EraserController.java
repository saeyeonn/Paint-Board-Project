package eraser;

import window.PanelForm;

import java.awt.image.BufferedImage;

public class EraserController{

    public static boolean act=false;

    private PanelForm panelForm;

    public EraserController(){

        panelForm = new PanelForm();
        pixelEraser=new PixelEraser(panelForm);
    }

    private BufferedImage image;
    private LineEraser lineEraser;
    private PixelEraser pixelEraser;

    private int startX, startY, endX, endY;

        public void activateLineEraser() {
        LineEraser lineEraser = new LineEraser(image);

        lineEraser.eraseLine(startX, startY, endX, endY);
    }


    public void activatePixelEraser(boolean TF) {
        pixelEraser.setEraserActivated(TF);
        act=true;
        }
    public void deactivatePixelEraser() {
        act=false;





}}
