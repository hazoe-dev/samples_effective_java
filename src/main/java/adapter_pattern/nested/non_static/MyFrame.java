package adapter_pattern.nested.non_static;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame {
    private int count = 0;
    private JLabel label = new JLabel("Number clicks: ");
    private JButton buttonClient = new JButton("Click");
    public MyFrame() {

        JFrame frame = new JFrame("Nested class-Non static");
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

        buttonClient.addActionListener(new ActionListenerAdapter());
    }

    class ActionListenerAdapter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            label.setText("Number clicks: " + count++);
        }
    }

    public static void main(String[] args) {
        MyFrame myClient = new MyFrame();
    }



}
