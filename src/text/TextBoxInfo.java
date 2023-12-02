package text;

import javax.swing.JTextField;

public class TextBoxInfo {
    private JTextField textBox;
    private int x;
    private int y;

    public TextBoxInfo(JTextField textField, int x, int y) {
        this.textBox = textField;
        this.x = x;
        this.y = y;
    }

    public JTextField getTextBox() {
        return textBox;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
