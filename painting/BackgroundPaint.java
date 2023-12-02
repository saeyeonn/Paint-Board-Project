package painting;

import java.awt.*;

public class BackgroundPaint implements Paint {

    private static Color color;
    private static ColorType colorType;

    // get colorType of User selection
    
    @Override
    public Color Paint() {
        color = colorType.getColorCode();
        return color;
    }
}