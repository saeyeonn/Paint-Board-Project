package repository;

import domain.button.Button;

import java.util.ArrayList;
import java.util.List;

public class ButtonRepository {
    public static ButtonRepository instance = new ButtonRepository();

    private final List<Button> buttons = new ArrayList<>();

    private ButtonRepository() {
    }

    public static ButtonRepository getInstance() {
        return instance;
    }

    public void addAll(List<Button> buttonList) {
        buttonList
                .forEach(button -> buttons.add(button));
    }

    public void printAllButtons() {
        buttons.forEach(button -> System.out.println(button.getName() + "이 ButtonRepository에 들어있어요."));
    }

    public Button findByName(String name) {
        return buttons.stream()
                .filter(button -> button.getName().equals(name))
                .findFirst()
                .get();
    }
}
