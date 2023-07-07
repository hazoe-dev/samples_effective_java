package adapter_pattern.inheritance;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerAdapter extends MyFrame implements ActionListener {
    //interact with panel adaptee
    public ActionListenerAdapter() {
        buttonClient.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        label.setText("Number clicks: "+ count++);
    }
}
