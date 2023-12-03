package eraser;

public interface Erase {

    void erasePixel(int x, int y);
    default void eraseLine(int startX, int startY, int endX, int endY) {};
}
