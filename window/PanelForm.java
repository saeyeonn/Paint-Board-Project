package window;

import painting.BackgroundPaint;

import javax.swing.*;

import java.awt.*;

public class PanelForm extends JPanel{
    private static Color color = Color.WHITE;
    public PanelForm() {
        BackgroundPaint backgroundPaint = new BackgroundPaint();
        color = backgroundPaint.Paint();
        add(MiniBarForm.getInstance(), BorderLayout.NORTH); // add minibar
        setBackground(color);
        setLayout(new FlowLayout());
    }
}
