package text;

import javax.swing.JTextField;

public class TextBoxInfo {
    private static JTextField textBox;
    private int x;
    private int y;
    private static int w;
    private static int h;

    public TextBoxInfo(JTextField textField, int x, int y) {
        TextBoxInfo.textBox = textField;
        this.x = x;
        this.y = y;
    }

    public static JTextField getTextBox() {
        return textBox;
    }

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

    public static void setW(int w) {
        TextBoxInfo.w = w;
    }

    public static void setH(int h) {
        TextBoxInfo.h = h;
    }
}
