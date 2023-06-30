package adapter_pattern.composition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyClient {
    int count=0;
    JLabel label = new JLabel("Number clicks: ");
    MyActionListener listener;
    public MyClient() {
    }
    void show(){
        JFrame frame = new JFrame("Anonymous class");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,50, 500,500);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(Color.PINK);
        panel.setSize( 500,500);
        panel.setLayout(new BorderLayout());
        frame.add(panel);

        panel.add(label,BorderLayout.CENTER);

        JButton button = new JButton("Click");
        button.setSize(150,30);
        panel.add(button,BorderLayout.SOUTH);

        button.addActionListener(listener);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public MyActionListener getListener() {
        return listener;
    }

    public void setListener(MyActionListener listener) {
        this.listener = listener;
    }

    public static void main(String[] args) {
        MyClient myClient = new MyClient();
        myClient.setListener(new MyActionListener(myClient.getCount(),myClient.getLabel()));
        myClient.show();
    }

}
