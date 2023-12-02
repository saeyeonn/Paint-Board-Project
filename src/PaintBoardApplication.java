import controller.SystemController;
import repository.ButtonRepository;

public class PaintBoardApplication {
    public static void main(String[] args) {
        SystemController.start();
        ButtonRepository.getInstance().printAllButtons();
    }
}

