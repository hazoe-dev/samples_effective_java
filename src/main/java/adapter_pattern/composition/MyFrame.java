package adapter_pattern.composition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MyFrame {
    private int count = 0;
    private JLabel label = new JLabel("Number clicks: ");
    private JButton buttonClient = new JButton("Click");
    public MyFrame() {

        JFrame frame = new JFrame("Composition _ Adapter");
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

        ActionListener actionListener = new ActionListenerAdapter(count, label);

        buttonClient.addActionListener(actionListener);
    }

    public static void main(String[] args) {
        MyFrame myClient = new MyFrame();
    }
}
