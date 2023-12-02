package button;

import javax.swing.*;
import java.awt.*;

public class ImageConverter {
    private static int width = 25, height = 25;

    private ImageConverter() {
    }

    public static ImageIcon getIconImage(String filepath, String buttonName) {

        // set image size
        if (buttonName.equals("zoomIn") || buttonName.equals("zoomOut")) {
            width = height = 25;
        } else if (buttonName.equals("1pt") || buttonName.equals("3pt") || buttonName.equals("6pt") || buttonName.equals("9pt")
                || buttonName.equals("dot") || buttonName.equals("dash") || buttonName.equals("solid")) {
            width = 70;
            height = 40;
        }

        // generate scaled imageIcon
        Image scaledImage = new ImageIcon(filepath + "/" + buttonName + ".png")
                .getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);

        return new ImageIcon(scaledImage);
    }
}
