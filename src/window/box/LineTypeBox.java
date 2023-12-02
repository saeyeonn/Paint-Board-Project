package window.box;

import util.ImageConverterBack;
import window.box.constants.LineType;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class LineTypeBox {

    private final JComboBox<ImageIcon> box;

    private LineTypeBox(List<ImageIcon> icons) {
        JComboBox<ImageIcon> imageIconJComboBox = new JComboBox<>();
        imageIconJComboBox.setPreferredSize(new Dimension(80, 30));

        icons.forEach(imageIconJComboBox::addItem);
        this.box = imageIconJComboBox;
    }

    public static LineTypeBox create() {
        List<ImageIcon> imageIcons = generateImageIcons();
        return new LineTypeBox(imageIcons);
    }

    private static List<ImageIcon> generateImageIcons() {
        final String filePath = "src/resource/linetype/%s.png";

        return Arrays.stream(LineType.values())
                .map(fileName -> {
                    String combinedFilePath = String.format(filePath, fileName.getName());
                    return ImageConverterBack.convertToImageIcon(combinedFilePath, 70, 40);
                })
                .toList();
    }

    public JComboBox<ImageIcon> getBox() {
        return box;
    }
}
