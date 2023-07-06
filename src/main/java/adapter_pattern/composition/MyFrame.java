package adapter_pattern.composition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MyFrame {
    public MyFrame() {

        JFrame frame = new JFrame("Composition _ Adapter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,50, 500,500);
        frame.setVisible(true);

        PanelAdaptee panelAdaptee = new PanelAdaptee();
        frame.add(panelAdaptee);

        ActionListener actionListener = new ActionListenerAdapter(panelAdaptee);

        panelAdaptee.getButtonClient().addActionListener(actionListener);
    }

    public static void main(String[] args) {
        MyFrame myClient = new MyFrame();
    }
}
