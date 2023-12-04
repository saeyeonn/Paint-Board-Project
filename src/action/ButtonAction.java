package action;

import domain.button.Button;
import domain.panel.Canvas;
import painting.BackgroundColor;
import repository.ButtonRepository;
import repository.SelectionRepository;
import text.TextBox;
import util.ImageLoading;
import util.Saving;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonAction implements ActionListener {
    private Canvas canvas;
    private static Color color;

    public ButtonAction(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton selectButton = (JButton) e.getSource();
        String name = selectButton.getName();

        Button button = ButtonRepository.getInstance().findByName(selectButton.getName());
        System.out.println(button.getName() + "눌렸다 룰루");

        if (button.isSelectionButton()) {
            SelectionRepository.getInstance().updateAction(button);
        } else if (button.isColorButton()) {
            SelectionRepository.getInstance().updateColor(button);
            color = button.getButtonConstants().getColor();
            System.out.println("color 변경 :" + color);

        } else if (button.isActionButton()) {
            System.out.println("즉시 동작 버튼 : " + button.getButtonConstants());
            if (button.getName().equals("15_customColor")) {
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        color = JColorChooser.showDialog(button, "Color Chooser", Color.LIGHT_GRAY);
                        canvas.requestFocusInWindow();
                    }
                });
            }
        }
        System.out.println();


        if (name.equals("28_textBox")) {
            TextBox textBox = new TextBox();
            textBox.setCreating();
            System.out.println("이제 텍박 만들 거임");

        } else if (name.equals("01_saving")) {
            Saving saving = new Saving(canvas);

        } else if (name.equals("02_imageLoading")) {
            ImageLoading imageLoading = new ImageLoading(canvas);

        } else if (name.equals("08_backgroundColor")) {
            BackgroundColor backgroundColor = new BackgroundColor(canvas, color);
            System.out.println("이제 배경 칠할거임 -> " + color);
        } else if (name.equals("17_line")) {
            canvas.setDrawLine(true);

        } else if (name.equals("18_rectangular")) {
            canvas.setDrawRectangle(true);

        } else if (name.equals("19_triangle")) {
            canvas.setDrawTriangle(true);

        } else if (name.equals("20_circle")) {
            canvas.setDrawCircle(true);

        } else if (name.equals("23_cut")) {
            canvas.getDoing().cut();
            System.out.println("이제 잘라내기 할 거임");

        } else if (name.equals("23_paste")) {
            canvas.getDoing().paste();
            System.out.println("이제 붙여넣기 할 거임");

        } else if (name.equals("zoomIn")) {
            canvas.getZoom().zoomIn();
            System.out.println("이제 줌인 할 거임");

        } else if (name.equals("zoomOut")) {
            canvas.getZoom().zoomOut();
            System.out.println("이제 줌아웃 할 거임");

        } else if (name.equals("redo")) {
            canvas.getDoing().redo();
            System.out.println("이제 리두 할 거임");

        } else if (name.equals("undo")) {
            canvas.getDoing().undo();
            System.out.println("이제 언두 할 거임");

        }
    }
}

