package window.box;

import button.ImageConverter;
import javax.swing.*;
import java.awt.*;

public class LineBoxForm extends JComboBox<ImageIcon>{

    // set resources
    private static String typeFilePath = "src/resource/lineType";
    private static String boldFilePath = "src/resource/lineBold";
    private static ImageIcon[] typeIconList = {ImageConverter.getIconImage(typeFilePath, "dash"),
            ImageConverter.getIconImage(typeFilePath, "dot"), ImageConverter.getIconImage(typeFilePath, "solid")};
    private static ImageIcon[] boldIconList = {ImageConverter.getIconImage(boldFilePath, "9pt"),
            ImageConverter.getIconImage(boldFilePath, "6pt"), ImageConverter.getIconImage(boldFilePath, "3pt"),
            ImageConverter.getIconImage(boldFilePath, "1pt")};


    private static final LineBoxForm lineTypeBox = new LineBoxForm(typeIconList);
    private static final LineBoxForm lineBoldBox = new LineBoxForm(boldIconList);

    private LineBoxForm(ImageIcon[] imageIconList) { // add choices
        setPreferredSize(new Dimension(80, 30));
        for (ImageIcon imageIcon : imageIconList) {
            addItem(imageIcon);
        }
    }

    public static LineBoxForm getLineTypeBox() {
        return lineTypeBox;
    }

    public static LineBoxForm getBoldTypeBox() {
        return lineBoldBox;
    }

}
