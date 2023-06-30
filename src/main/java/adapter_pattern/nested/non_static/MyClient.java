package adapter_pattern.nested.non_static;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyClient {
    int count=0;
    JLabel label;
    public MyClient() {

        JFrame frame = new JFrame("Non static nested class");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,50, 500,500);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(Color.PINK);
        panel.setSize( 500,500);
        panel.setLayout(new BorderLayout());
        frame.add(panel);

        label = new JLabel("Number clicks: ");
        panel.add(label,BorderLayout.CENTER);

        JButton button = new JButton("Click");
        button.setSize(150,30);
        panel.add(button,BorderLayout.SOUTH);

    }
    class MyActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            label.setText("Number clicks: " + count++ );
        }
    }
    public static void main(String[] args) {
        MyClient myClient = new MyClient();
    }

}

