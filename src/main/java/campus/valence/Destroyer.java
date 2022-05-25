package campus.valence;

import javax.swing.*;
import java.awt.*;

public class Destroyer {

    private static int STEP = 10;
    private final JPanel panel;
    private SpaceCampus game;
    private boolean isDead;

    Destroyer(SpaceCampus game) {
        this.isDead = false;
        panel = new JPanel();
        panel.setBounds(185, 500,40,42);

        ImageIcon vessel = new ImageIcon("src/main/java/image/vessel.png");
        JLabel label = new JLabel();
        label.setIcon(vessel);
        panel.add(label);
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

        if (this.game.getExtra() == 1){
            this.game.fire(new FireBall(x));
        } else if (this.game.getExtra() == 2) {
            this.game.fire(new FireBall(x+5));
            this.game.fire(new FireBall(x-5));
        } else if (this.game.getExtra() == 3) {
            this.game.fire(new FireBall(x));
            this.game.fire(new FireBall(x-10));
            this.game.fire(new FireBall(x+10));
        }else if (this.game.getExtra() == 4) {
            this.game.fire(new FireBall(x-5));
            this.game.fire(new FireBall(x-10));
            this.game.fire(new FireBall(x+5));
            this.game.fire(new FireBall(x+10));
        }

    }

    public JPanel getPanel() {
        return panel;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

}
