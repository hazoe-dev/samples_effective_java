package adapter_pattern.tmp;

import javax.swing.*;

public class MyClient {
    static MyActionListener listener = new MyActionListener();
    public static void main(String[] args) {
        JFrame frame = new JFrame("Composition with adapter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,50, 500,500);
        frame.setVisible(true);

        MyPanel panel = new MyPanel();
        frame.add(panel);
        listener.add(panel);
    }
}
