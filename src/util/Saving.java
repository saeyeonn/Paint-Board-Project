package util;

import domain.panel.Canvas;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;

public class Saving extends JFileChooser {
    public Saving(Canvas canvas) {
        setFileFilter(new FileNameExtensionFilter("*.png", "png"));
        int imageValue = showSaveDialog(null);
        if (imageValue == APPROVE_OPTION) {
            File file = getSelectedFile();
            try {
                ImageIO.write(canvas.bufferedImage, "png", new File(file.getAbsolutePath()));
                System.out.println("saved Correctly " + file.getAbsolutePath());
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                System.out.println("Failed to save image");
            }
        }
        if (imageValue == JFileChooser.CANCEL_OPTION) {
            System.out.println("No file choosen");
        }

    }
}