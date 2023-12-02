package eraser;

public class EraserController {

    private Erase current;

    public void setEraser(Erase eraser) {
        this.current = eraser;
    }


    public void useEraser(int startX, int startY, int endX, int endY) {
        if (current != null) {
            current.eraseLine(startX, startY, endX, endY);

        }
    }
}
