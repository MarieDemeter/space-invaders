package campus.valence;

import javax.swing.*;
import java.awt.*;

public abstract class Attack {
    private int STEP;
    private JPanel panel;

    public Attack(int STEP) {
        this.STEP = STEP;
        this.panel = new JPanel();
    }

    public void moveY() {
        Rectangle bounds = panel.getBounds();
        panel.setBounds(bounds.x, bounds.y - this.STEP, bounds.width, bounds.height);
    }

    public JPanel getPanel() {
        return panel;
    }
}
