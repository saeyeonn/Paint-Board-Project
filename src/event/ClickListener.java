package event;

import domain.button.Button;
import grouping.SelectedShape;
import repository.ButtonRepository;
import repository.SelectionRepository;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickListener implements ActionListener {

    private final SelectedShape selectedShape;

    public ClickListener(SelectedShape selectedShape) {
        this.selectedShape = selectedShape;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        JButton jButton = (JButton) event.getSource();
        Button button = ButtonRepository.getInstance().findByName(jButton.getName());
        System.out.println(button.getName() + "눌렸다 룰루");

        if (button.isSelectionButton()) {
            SelectionRepository.getInstance().updateAction(button);
        } else if (button.isColorButton()) {
            SelectionRepository.getInstance().updateColor(button);
        } else if (button.isActionButton()) {
            System.out.println("즉시 동작 버튼 : " + button.getButtonConstants());
        }
        System.out.println();
    }
}
