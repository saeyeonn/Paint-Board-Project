package util;

import domain.panel.Canvas;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ImageLoading extends JFileChooser {
    public ImageLoading(Canvas canvas) {
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG", "jpeg", "jpg", "png", "bmp", "gif");
        addChoosableFileFilter(filter);

        int imageValue = showOpenDialog(null);
        if (imageValue == APPROVE_OPTION) {
            File selectedFile = getSelectedFile();
            try {
                canvas.bufferedImage = ImageIO.read(new File(selectedFile.getAbsolutePath()));
                canvas.repaint();
                System.out.println("이미지 불러오기");
            } catch (IOException e1) {// TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }
}
