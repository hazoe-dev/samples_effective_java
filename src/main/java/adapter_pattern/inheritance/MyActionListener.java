package adapter_pattern.inheritance;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {
    protected int count;
    protected JLabel label;

    @Override
    public void actionPerformed(ActionEvent e) {
        label.setText("Number clicks: " + count++ );
    }
}
