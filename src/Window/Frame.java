package Window;

import javax.swing.*;

public class Frame extends JFrame{

    public void createFrame() {
        setTitle("Paint Board");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        ImageIcon imageIcon = new ImageIcon("src/ImageSource/paintBoard.png");
        setIconImage(imageIcon.getImage());
    }
}
