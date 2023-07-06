package adapter_pattern.inheritance;


import javax.swing.*;
import java.awt.event.ActionListener;

public class MyFrame {
    public MyFrame() {

        JFrame frame = new JFrame("Composition _ Adapter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,50, 500,500);
        frame.setVisible(true);

        ActionListenerAdapter panelAdaptee = new ActionListenerAdapter();
        frame.add(panelAdaptee);

    }

    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
    }
}
