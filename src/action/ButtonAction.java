package action;

import domain.button.constants.ButtonConstants;
import domain.panel.Canvas;
import drawing.DrawingController;
import eraser.EraserController;
import text.TextBox;
import util.ImageLoading;
import util.Saving;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;

public class ButtonAction implements ActionListener {
    private Canvas canvas;
    public ButtonAction(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton selectButton = (JButton) e.getSource();
        String name = selectButton.getName();

        if (name.equals("28_textBox")) {
            TextBox textBox = new TextBox();
            textBox.setCreating();
        } else if (name.equals("01_saving")) {
           Saving saving = new Saving(canvas);
        } else if (name.equals("02_imageLoading")) {
           ImageLoading imageLoading = new ImageLoading(canvas);
        }
    }
}
