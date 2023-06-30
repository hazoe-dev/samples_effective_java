package adapter_pattern.nested.anonymous;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyClient {
    int count=0;
    public MyClient() {

        JFrame frame = new JFrame("Anonymous class");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,50, 500,500);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(Color.PINK);
        panel.setSize( 500,500);
        panel.setLayout(new BorderLayout());
        frame.add(panel);

        JLabel label = new JLabel("Number clicks: ");
        panel.add(label,BorderLayout.CENTER);

        JButton button = new JButton("Click");
        button.setSize(150,30);
        panel.add(button,BorderLayout.SOUTH);

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Number clicks: " + count++ );
            }
        });
    }

    public static void main(String[] args) {
        MyClient myClient = new MyClient();
    }

}
