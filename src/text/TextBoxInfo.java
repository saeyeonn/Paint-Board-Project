package text;

public class TextBoxInfo {
    // private static JTextField textBox;
    private int x;
    private int y;
    private int w;
    private int h;

    public TextBoxInfo() {

    }

    public TextBoxInfo(int w, int h) {
        this.w = w;
        this.h = h;
    }

    public void xAndy(int x, int y) {
        // TextBoxInfo.textBox = textField;
        this.x = x;
        this.y = y;
    }

    public void wAndh(int w, int h) {
        this.w = w;
        this.h = h;
    }

    // public static JTextField getTextBox() {
    //     return textBox;
    // }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getW() {
        return w;
    }
    
    public int getH() {
        return h;
    }
}
