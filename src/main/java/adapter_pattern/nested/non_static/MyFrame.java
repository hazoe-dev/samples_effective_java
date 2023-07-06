package adapter_pattern.nested.non_static;

import javax.swing.*;

public class MyFrame {
    public MyFrame() {

        JFrame frame = new JFrame("Nested class-Non static");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,50, 500,500);
        frame.setVisible(true);

        JPanel panel = new PanelAdaptee();
        frame.add(panel);
    }

    public static void main(String[] args) {
        MyFrame myClient = new MyFrame();
    }



}
