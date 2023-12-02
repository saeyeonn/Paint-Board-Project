package window;

public class
WindowController {
    private WindowController() {
    }

    public static FrameForm initialize(){
        FrameForm frameForm = FrameForm.getInstance();
        return frameForm;
    }
}
