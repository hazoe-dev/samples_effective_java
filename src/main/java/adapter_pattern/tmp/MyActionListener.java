package adapter_pattern.tmp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {
    MyPanel panel;
    @Override
    public void actionPerformed(ActionEvent e) {
        int newCount = panel.getCount() + 1;
        panel.setCount(newCount);
        panel.getLabel().setText("Number clicks:" + newCount);
    }

    public void add(MyPanel panel) {
        this.panel = panel;
        panel.getButton().addActionListener(this);
    }
}
