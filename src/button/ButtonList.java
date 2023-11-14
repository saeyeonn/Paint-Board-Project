package button;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ButtonList {
    private final ArrayList<Button> buttons;

    private ButtonList(String filepath){
        ArrayList<File> fileList = new ArrayList<>();
        ArrayList<Button> buttonList = new ArrayList<>();

        File resourceFolder = new File(filepath);

        if (resourceFolder.exists() && resourceFolder.isDirectory()) {
            File[] files = resourceFolder.listFiles((dir, name) -> name.toLowerCase().endsWith(".png"));

            if (files != null) {
                fileList.addAll(List.of(files));

                for (File file : fileList) {
                    buttonList.add(new Button(filepath, file.getName().replace(".png", "")));
                }
            }
        }
        this.buttons = buttonList;
    }

    public static ButtonList create(String filepath){
        return new ButtonList(filepath);
    }

    public ArrayList<Button> getButtons(){
        return buttons;
    }
}
