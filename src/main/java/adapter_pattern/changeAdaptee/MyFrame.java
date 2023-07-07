package adapter_pattern.changeAdaptee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame  implements ActionListener {
    private int count;
    private JLabel label;
    private JButton buttonClient;

    //interact with panel adaptee
    public MyFrame() {
        JFrame frame = new JFrame("Composition with adapter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,50, 500,500);
        frame.setVisible(true);

        JPanel panelAdaptee = new JPanel();
        panelAdaptee.setBackground(Color.PINK);
        panelAdaptee.setSize( 500,500);
        panelAdaptee.setLayout(new BorderLayout());

        label = new JLabel("Number clicks:");
        label.setSize(150,100);
        panelAdaptee.add(label,BorderLayout.CENTER);

        buttonClient = new JButton("Click");
        buttonClient.setSize(150,30);
        panelAdaptee.add(buttonClient,BorderLayout.SOUTH);

        frame.add(panelAdaptee);
        buttonClient.addActionListener(this);
    }

    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        label.setText("Number clicks: " + count++);
    }
}
