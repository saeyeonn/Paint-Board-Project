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
                if (canvas.bufferedImage != null) { // canvas.bufferedImage가 null이 아닌지 확인
                    ImageIO.write(canvas.bufferedImage, "png", new File(file.getAbsolutePath()));
                    System.out.println("saved Correctly " + file.getAbsolutePath());
                } else {
                    System.out.println("No image to save"); // canvas.bufferedImage가 null인 경우
                }
            } catch (IOException e1) {
                System.out.println("Failed to save image");
            }
        }
        if (imageValue == JFileChooser.CANCEL_OPTION) {
            System.out.println("No file choosen");
        }
    }
}