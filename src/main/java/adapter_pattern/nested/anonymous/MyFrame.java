package adapter_pattern.nested.anonymous;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame {
    public MyFrame() {

        JFrame frame = new JFrame("Nested class - Anonymous");
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
