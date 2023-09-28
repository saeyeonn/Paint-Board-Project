package View;

import javax.swing.*;

public class Frame extends JFrame{

    public JFrame createFrame() {
        setTitle("Paint Board");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 530);
        setLocationRelativeTo(null);

        ImageIcon imageIcon = new ImageIcon("src/ImageSource/paintBoard.png");
        setIconImage(imageIcon.getImage());

        return this;
    }
}
