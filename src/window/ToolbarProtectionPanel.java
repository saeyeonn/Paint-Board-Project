package window;
import java.awt.*;
import javax.swing.*;

public class ToolbarProtectionPanel extends JPanel {
    public ToolbarProtectionPanel() {
        // Set Size and Background
        setPreferredSize(new Dimension(190, 300));
        setBackground(new Color(222, 0, 239));
        setLayout(new BorderLayout());

        add(new ToolBarForm(), BorderLayout.CENTER);
    }

}
