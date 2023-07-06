package adapter_pattern.inheritance;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerAdapter extends PanelAdaptee implements ActionListener {
    public ActionListenerAdapter() {
        buttonClient.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        label.setText("Number clicks: "+ count++);
    }
}
