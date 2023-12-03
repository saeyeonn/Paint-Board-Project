package domain.button;

import domain.panel.Canvas;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Objects.requireNonNull;

public class Buttons {
    private final List<Button> buttons;
    public Buttons(String filepath, Canvas canvas) {
        ArrayList<Button> buttonList = new ArrayList<>();
        File buttonFiles = new File(filepath);

        List<File> buttons = new ArrayList<>(Arrays.stream(
                requireNonNull(buttonFiles.listFiles(
                        (dir, name) -> name.toLowerCase().endsWith(".png")))).toList());

        buttons.sort(Comparator.comparing(File::getName));

        for (File file : buttons) { // generate each button with button name to image name without ".png"
            Button button = new Button(filepath, file.getName().replace(".png", ""), canvas);
            buttonList.add(button); // generate buttonList
        }

        this.buttons = buttonList;
    }

    public static Buttons create(String buttonPath, Canvas canvas) {
        return new Buttons(buttonPath, canvas);
    }


    public List<Button> getButtons() {
        return buttons;
    }
}
