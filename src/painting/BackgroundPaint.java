//package painting;
//
//public class BackgroundPaint implements Paint {
//}

package painting;

import user.UserSelection;

import java.awt.*;

public class BackgroundPaint implements Paint {

    private static Color color;
    private static ColorType colorType;

    private static UserSelection userSelection;

    // get colorType of User selection
    @Override
    public Color Paint(ColorType white) {
        return null;
    }

    public void setColorType(UserSelection userSelection) {
        this.colorType = userSelection.getColorType();
        repaintPanel(userSelection);
    }
    @Override
    public Color getPaint() {
        color = colorType.getColorCode();
        return color;
    }
//    @Override
//    public void applyPaint(ColorType colorType) {
//        this.colorType = colorType;
//        repaintPanel(setUserSelection(userSelection));
//    }

    private void repaintPanel(UserSelection userSelection) {
        // Your existing logic for repainting the panel goes here
    }
}
