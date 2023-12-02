package window.box;

import window.box.constants.BoldType;
import window.box.constants.LineType;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static java.awt.Image.SCALE_SMOOTH;

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

        List<Image> scaledImages = Arrays.stream(BoldType.values())
                .map(fileName ->
                        new ImageIcon(String.format(filePath, fileName.getName()))
                                .getImage()
                                .getScaledInstance(190, 45, SCALE_SMOOTH))
                .toList();

        return scaledImages
                .stream()
                .map(ImageIcon::new)
                .toList();
    }

    public JComboBox<ImageIcon> getBox() {
        return box;
    }
}
