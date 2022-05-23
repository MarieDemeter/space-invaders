package campus.valence;

import javax.swing.*;
import java.awt.*;

public class FireBall {
    private int STEP;
    private JPanel panel;

    public FireBall(int x) {
        this.STEP = 15;
        this.createFireBall(x);
        new TimerFireBallMove(this);
    }

    private void createFireBall(int x) {
        this.panel = new JPanel();
        this.panel.setBounds((x + 50), 485, 10, 10);
        this.panel.setBackground(Color.red);
    }

    public void moveY() {
        Rectangle bounds = panel.getBounds();
        if (this.panel.getY() > 35) {
            panel.setBounds(bounds.x, bounds.y - this.STEP, bounds.width, bounds.height);
        }
    }


    public JPanel getPanel() {
        return panel;
    }
}
