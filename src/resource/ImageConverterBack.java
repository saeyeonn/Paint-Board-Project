package resource;

import javax.swing.*;
import java.awt.*;

import static java.awt.Image.SCALE_SMOOTH;

public class ImageConverterBack {
    private ImageConverterBack() {
    }

    public static ImageIcon convertToImageIcon(
            String path,
            int width,
            int height
    ) {
        Image scaledImage = new ImageIcon(path)
                .getImage()
                .getScaledInstance(width, height, SCALE_SMOOTH);

        return new ImageIcon(scaledImage);
    }

}
