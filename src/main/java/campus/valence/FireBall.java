package campus.valence;

import javax.swing.*;
import java.awt.*;

public class FireBall {
    private int STEP;
    private JPanel panel;

    public FireBall(int x) {
        this.STEP = -15;
        this.createFireBall(x);
        new RepeatedTimer(this);
    }

    private void createFireBall(int x) {
        this.panel = new JPanel();
        this.panel.setBounds((x+50), 485, 10, 10);
        this.panel.setBackground(Color.red);
    }

    public void moveY() {
        Rectangle bounds = panel.getBounds();
        panel.setBounds(bounds.x, bounds.y + this.STEP, bounds.width, bounds.height);
    }

    public JPanel getPanel() {
        return panel;
    }
}
