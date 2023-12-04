package repository;

import domain.button.Button;

import java.awt.*;

public class SelectionRepository {
    public static SelectionRepository instance = new SelectionRepository();

    private Button colorButton;
    private Button actionButton;

    public SelectionRepository() {
        // initialize Setting -> Black Pen
        this.colorButton = ButtonRepository.getInstance().findByName("14_black");
        this.actionButton = ButtonRepository.getInstance().findByName("25_pen");

        System.out.println("초기값 : " + colorButton);
        System.out.println("초기값 : " + actionButton);
    }

    public static SelectionRepository getInstance() {
        return instance;
    }

    public void updateColor(Button button) {
        System.out.println("색깔 저장값 변경" + this.colorButton.getButtonConstants() + "->" + button.getButtonConstants());
        this.colorButton = button;
    }

    public void updateAction(Button button) {
        System.out.println("행위 저장값 변경" + this.actionButton.getButtonConstants() + "->" + button.getButtonConstants());
        this.actionButton = button;
    }

    public Color getColorSelection() {
        return colorButton.getButtonConstants().getColor();
    }
}
