package Window;

import javax.swing.*;
import java.awt.*;

public class ChangeImageSize {
    public void changeImageSize() {
        ImageIcon saveImageIconI = new ImageIcon("src/ImageSource/Save.png");
        ImageIcon openImageIconI = new ImageIcon("src/ImageSource/Picture.png");
        ImageIcon pixelEraserImageIconI = new ImageIcon("src/ImageSource/PixelEraser.png");
        ImageIcon lineEraserImageIconI = new ImageIcon("src/ImageSource/LineEraser.png");
        ImageIcon deleteAllImageIconI = new ImageIcon("src/ImageSource/DeleteAll.png");
        ImageIcon cutImageIconI = new ImageIcon("src/ImageSource/cut.png");
        ImageIcon pasteImageIconI = new ImageIcon("src/ImageSource/Paste.png");
        ImageIcon groupImageIconI = new ImageIcon("src/ImageSource/Group.png");
        ImageIcon ungroupImageIconI = new ImageIcon("src/ImageSource/Ungroup.png");
        ImageIcon selectColorImageIconI = new ImageIcon("src/ImageSource/ColorPalette.jpg");
        ImageIcon shapeColorImageIconI = new ImageIcon("src/ImageSource/ShapeColor.png");
        ImageIcon lineColorImageIconI = new ImageIcon("src/ImageSource/LineColor.png");
        ImageIcon backgroundColorImageIconI = new ImageIcon("src/ImageSource/BIcon.png");
        ImageIcon textBoxImageIconI = new ImageIcon("src/ImageSource/TextBox.png");

        Image save = saveImageIconI.getImage();
        Image open = openImageIconI.getImage();
        Image pixelEraser = pixelEraserImageIconI.getImage();
        Image lineEraser = lineEraserImageIconI.getImage();
        Image deleteAll = deleteAllImageIconI.getImage();
        Image cut = cutImageIconI.getImage();
        Image paste = pasteImageIconI.getImage();
        Image group = groupImageIconI.getImage();
        Image ungroup = ungroupImageIconI.getImage();
        Image selectColor = selectColorImageIconI.getImage();
        Image shapeColor = shapeColorImageIconI.getImage();
        Image lineColor = lineColorImageIconI.getImage();
        Image backgroundColor = backgroundColorImageIconI.getImage();
        Image textBox = textBoxImageIconI.getImage();

        Image saveImage = save.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
        Image openImage = open.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
        Image pixelEraserImage = pixelEraser.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
        Image lineEraserImage = lineEraser.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
        Image deleteAllImage = deleteAll.getScaledInstance(10, 10, Image.SCALE_SMOOTH);;
        Image cutImage = cut.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
        Image pasteImage = paste.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
        Image groupImage = group.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
        Image ungroupImage = ungroup.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
        Image selectColorImage = selectColor.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
        Image shapeColorImage = shapeColor.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
        Image lineColorImage = lineColor.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
        Image backgroundColorImage = backgroundColor.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
        Image textBoxImage = textBox.getScaledInstance(10, 10, Image.SCALE_SMOOTH);

        ImageIcon saveImageIcon = new ImageIcon(saveImage);
    }
}
