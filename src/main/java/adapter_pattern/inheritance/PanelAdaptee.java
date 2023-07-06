package adapter_pattern.inheritance;

import javax.swing.*;
import java.awt.*;

public class PanelAdaptee extends JPanel {
    protected int count = 0;
    protected JLabel label = new JLabel("Number clicks: ");
    protected JButton buttonClient = new JButton("Click");
    public PanelAdaptee() {
        setBackground(Color.PINK);
        setSize(500, 500);
        setLayout(new BorderLayout());

        add(label, BorderLayout.CENTER);

        buttonClient.setSize(150, 30);
        add(buttonClient, BorderLayout.SOUTH);
    }

    public JButton getButtonClient() {
        return buttonClient;
    }
}
