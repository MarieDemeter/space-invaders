package campus.valence;

import javax.swing.*;
import java.awt.*;

public class Block {
    private JPanel panel;
    private int STEP;

    public Block(int i, int nbOfBlock) {
        this.STEP = 35;
        this.panel = new JPanel();

        this.createBlock(i, nbOfBlock);
        new TimerBlockMove(this);
    }

    private void createBlock(int i, int nbOfBlock) {
        int width = 50;
        int widthFrame = 400;
        int widthGap = widthFrame - width * nbOfBlock;
        int gap = (int) widthGap / nbOfBlock;

        this.panel.setBackground(Color.BLUE);
        this.panel.setBounds((gap/2)*(i +1)+width* i, 5, width, 30);
    }

    public void moveY() {
        Rectangle bounds = panel.getBounds();
        if (this.panel.getY() <485) {
            panel.setBounds(bounds.x, bounds.y + this.STEP, bounds.width, bounds.height);
        }
    }


    public JPanel getPanel() {
        return panel;
    }

    public boolean intersects(FireBall fireBall) {
        return getPanel().getBounds().intersects(fireBall.getPanel().getBounds());
    }
}
