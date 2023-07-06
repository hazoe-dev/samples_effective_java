package adapter_pattern.composition;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerAdapter implements ActionListener {
    private PanelAdaptee panelAdaptee;

    public ActionListenerAdapter(PanelAdaptee panelAdaptee) {
        this.panelAdaptee = panelAdaptee;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int count = panelAdaptee.getCount()+1;
        panelAdaptee.setCount(count);
        panelAdaptee.getLabel().setText("Number clicks: " + count);
    }
}
