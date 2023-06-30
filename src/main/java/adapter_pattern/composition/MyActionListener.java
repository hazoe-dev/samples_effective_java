package adapter_pattern.composition;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {
    private int count;
    private JLabel label;
    public MyActionListener(){}
    public MyActionListener(int count, JLabel label) {
        this.count = count;
        this.label = label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        label.setText("Number clicks: " + count++ );
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
}
