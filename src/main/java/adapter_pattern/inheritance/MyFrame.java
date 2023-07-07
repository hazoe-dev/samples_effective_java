package adapter_pattern.inheritance;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MyFrame {
    protected int count = 0;
    protected JLabel label = new JLabel("Number clicks: ");
    protected JButton buttonClient = new JButton("Click");
    public MyFrame() {

        JFrame frame = new JFrame("Inheritance _ Adapter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,50, 500,500);
        frame.setVisible(true);

        JPanel panelAdaptee = new JPanel();
        frame.add(panelAdaptee);

        panelAdaptee.setBackground(Color.PINK);
        panelAdaptee.setSize(500, 500);
        panelAdaptee.setLayout(new BorderLayout());

        panelAdaptee.add(label, BorderLayout.CENTER);

        buttonClient.setSize(150, 30);
        panelAdaptee.add(buttonClient, BorderLayout.SOUTH);

    }

    public static void main(String[] args) {
        ActionListenerAdapter frame = new ActionListenerAdapter();
    }
}
