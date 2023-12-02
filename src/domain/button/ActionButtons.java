package domain.button;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Objects.requireNonNull;

public class ActionButtons {
    private final List<Button> buttons;

    private ActionButtons(String filepath) {
        ArrayList<Button> buttonList = new ArrayList<>();
        File buttonFiles = new File(filepath);

        List<File> buttons = new ArrayList<>(Arrays.stream(
                requireNonNull(buttonFiles.listFiles(
                        (dir, name) -> name.toLowerCase().endsWith(".png")))).toList());

        buttons.sort(Comparator.comparing(File::getName));

        for (File file : buttons) { // generate each button with button name to image name without ".png"
            Button button = new Button(filepath, file.getName().replace(".png", ""));
            buttonList.add(button); // generate buttonList
        }

        this.buttons = buttonList;
    }

    public static ActionButtons create(String buttonPath) {
        return new ActionButtons(buttonPath);
    }

    public List<Button> getButtons() {
        return buttons;
    }
}
