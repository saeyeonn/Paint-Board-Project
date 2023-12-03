package domain.box;

import domain.box.constants.BoldType;
import resource.ImageConverterBack;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class BoldTypeBox {
    private final JComboBox<ImageIcon> box;

    private BoldTypeBox(List<ImageIcon> icons) {
        JComboBox<ImageIcon> imageIconJComboBox = new JComboBox<>();
        imageIconJComboBox.setPreferredSize(new Dimension(80, 30));

        icons.forEach(imageIconJComboBox::addItem);
        this.box = imageIconJComboBox;
    }

    public static BoldTypeBox create() {
        List<ImageIcon> imageIcons = generateImageIcons();
        return new BoldTypeBox(imageIcons);
    }

    private static List<ImageIcon> generateImageIcons() {
        final String filePath = "src/resource/linebold/%s.png";

        return Arrays.stream(BoldType.values())
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
