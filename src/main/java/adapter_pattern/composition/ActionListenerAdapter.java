package adapter_pattern.composition;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerAdapter implements ActionListener {
    private int count;
    private JLabel label;

    //interact with panel adaptee
    public ActionListenerAdapter(int count, JLabel label) {
        this.count = count;
        this.label = label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        label.setText("Number clicks: " + count++ );
    }
}
