package adapter_pattern.composition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAdaptee extends JPanel{
    private int count = 0;
    private JLabel label = new JLabel("Number clicks: ");
    private JButton buttonClient = new JButton("Click");
    public PanelAdaptee() {
        setBackground(Color.PINK);
        setSize(500, 500);
        setLayout(new BorderLayout());

        add(label, BorderLayout.CENTER);

        buttonClient.setSize(150, 30);
        add(buttonClient, BorderLayout.SOUTH);
    }

    public int getCount() {
        return count;
    }

    public JLabel getLabel() {
        return label;
    }

    public JButton getButtonClient() {
        return buttonClient;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
