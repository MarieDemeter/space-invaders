package campus.valence;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Destroyer {

    private static int STEP = 10;
    private final JPanel panel;
    private SpaceCampus game;

    Destroyer(SpaceCampus game) {
        panel = new JPanel();
        panel.setBounds(150, 500, 100, 30);
        panel.setBackground(Color.PINK);
        this.game = game;
    }

    public void moveLeft() {
        if (panel.getX() > 10) {
            moveX(-STEP);
        }
    }

    public void moveRight() {
        if (panel.getX() < 290) {
            moveX(STEP);
        }
    }

    private void moveX(int step) {
        Rectangle bounds = panel.getBounds();
        panel.setBounds(bounds.x + step, bounds.y, bounds.width, bounds.height);
    }

    public void destroyerFire() {
        int x = this.panel.getX();
        this.game.fire(new FireBall(x));
    }

    public JPanel getPanel() {
        return panel;
    }

}
