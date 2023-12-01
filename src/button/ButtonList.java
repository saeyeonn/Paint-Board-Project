package button;

import action.ButtonAction;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ButtonList {
    private final ArrayList<Button> buttons;

    // generate buttons with button settings defined in Button class
    private ButtonList(String filepath){
        ArrayList<File> fileList = new ArrayList<>();
        ArrayList<Button> buttonList = new ArrayList<>();

        File resourceFolder = new File(filepath);

        // load imageFiles by finding files end with ".png"
        if (resourceFolder.exists() && resourceFolder.isDirectory()) {
            File[] files = resourceFolder.listFiles((dir, name) -> name.toLowerCase().endsWith(".png"));

            if (files != null) {
                fileList.addAll(List.of(files));

                for (File file : fileList) { // generate each button with button name to image name without ".png"
                    Button button = new Button(filepath, file.getName().replace(".png", ""));
                    addListener(button); // add ButtonActionListener
                    buttonList.add(button); // generate buttonList
                }
            }
        }
        for (Button button : buttonList) {
            System.out.println("Button Name: " + button.getName()); //버튼 이름 확인하려고 임가영이 만듦
        }
        this.buttons = buttonList;
    }

    private void addListener(Button button) { // set border painting when user clicks button
            button.addActionListener(new ButtonAction());
            button.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    JButton srcButton = (JButton) e.getSource();
                    srcButton.setFocusPainted(true);
                }

                @Override
                public void focusLost(FocusEvent e) {
                    JButton srcButton = (JButton) e.getSource();
                    srcButton.setFocusPainted(false);
                }
            });
    }

    public static ButtonList create(String filepath){
        return new ButtonList(filepath);
    }

    public ArrayList<Button> getButtons(){
        return buttons;
    }
}
