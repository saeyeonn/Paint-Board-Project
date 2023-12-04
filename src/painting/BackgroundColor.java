package painting;

import domain.panel.Canvas;
import repository.SelectionRepository;

import java.awt.*;

public class BackgroundColor {
    public BackgroundColor(Canvas canvas, Color color) {
        canvas.changeBackground(color);
        System.out.println(color);
        canvas.repaint();
    }
}
