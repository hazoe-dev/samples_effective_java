package adapter_pattern.tmp;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    int count;
    JLabel label;
    JButton button;
    public MyPanel() {
        setBackground(Color.PINK);
        setSize( 500,500);
        setLayout(new BorderLayout());

        label = new JLabel("Number clicks:");
        label.setSize(150,100);
        add(label,BorderLayout.CENTER);

        button = new JButton("Click");
        button.setSize(150,30);
        add(button,BorderLayout.SOUTH);
    }

    public int getCount() {
        return count;
    }

    public JLabel getLabel() {
        return label;
    }

    public JButton getButton() {
        return button;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
