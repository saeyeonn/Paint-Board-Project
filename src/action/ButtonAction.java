package action;

import domain.button.Button;
import domain.panel.Board;
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
    private Board board;
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

            if (button.getName().equals("15_customColor")) {
                button.addActionListener(e1 -> {
                    color = JColorChooser.showDialog(new Container(), "Color Chooser", Color.LIGHT_GRAY);
                });

            }

        } else if (button.isActionButton()) {
            System.out.println("즉시 동작 버튼 : " + button.getButtonConstants());
        }
        System.out.println();


        if (name.equals("28_textBox")) {
            TextBox textBox = new TextBox();
            textBox.setCreating();
        } else if (name.equals("01_saving")) {
           Saving saving = new Saving(canvas);
        } else if (name.equals("02_imageLoading")) {
            ImageLoading imageLoading = new ImageLoading(canvas);
        } else if (name.equals("08_backgroundColor")) {
            BackgroundColor backgroundColor = new BackgroundColor(canvas, color);
            System.out.println("이제 배경 칠할거임 -> " + color);
        } else if (name.equals("16_reset")) {
            canvas.repaint();
        } else if (name.equals("17_line")) {
            canvas.setDrawLine(true);
        } else if (name.equals("18_rectangular")) {
            canvas.setDrawRectangle(true);
        } else if (name.equals("19_triangle")) {
            canvas.setDrawTriangle(true);
        } else if (name.equals("20_circle")) {
            canvas.setDrawCircle(true);
        } else if (name.equals("22_pixelEraser")){
            canvas.setEraser(true);
        }
    }
}

