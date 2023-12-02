import controller.SystemController;
import repository.ButtonRepository;
import repository.SelectionRepository;

public class PaintBoardApplication {
    public static void main(String[] args) {
        SystemController.start();
        ButtonRepository.getInstance().printAllButtons();
        SelectionRepository selectionRepository = SelectionRepository.getInstance();
    }
}

