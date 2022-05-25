package campus.valence;

import javax.swing.*;
import java.awt.*;

public class Block {
    private JPanel panel;
    private JLabel label;
    private int STEP;
    private int nbToKill;

    public Block(int i, int nbOfBlock) {
        this.STEP = 40;
        this.panel = new JPanel();
        this.label = new JLabel();

        this.createBlock(i, nbOfBlock);
    }

    public int getNbToKill() {
        return nbToKill;
    }

    public void setNbToKill(int nbToKill) {
        this.nbToKill = nbToKill;
    }

    public JLabel getLabel() {
        return label;
    }

    private void createBlock(int i, int nbOfBlock) {
        int width = 50;
        int widthFrame = 400;
        int widthGap = widthFrame - width * nbOfBlock;
        int gap = (int) widthGap / nbOfBlock;

        ImageIcon invaderBlue = new ImageIcon("image/invaderBlue.png");
        ImageIcon invaderPurple = new ImageIcon("image/invaderPurple.png");
        ImageIcon invaderRed = new ImageIcon("image/invaderRed.png");
        ImageIcon invaderBrown = new ImageIcon("image/invaderBrown.png");
        JLabel labelInvader = new JLabel();

        int randomColor = (int) (Math.random()*9) +1;
        switch (randomColor) {
            case 1:
                labelInvader.setIcon(invaderPurple);
                this.nbToKill = 3;
                break;
            case 2:
                labelInvader.setIcon(invaderRed);
                this.nbToKill = 5;
                break;
            case 3:
                labelInvader.setIcon(invaderBrown);
                this.nbToKill = 7;
                break;
            default:
                labelInvader.setIcon(invaderBlue);
                this.nbToKill = 1;
                break;
        }
        this.panel.add(labelInvader);
        this.panel.setBounds((gap / 2) * (i + 1) + width * i, 35, width, 37);
    }

    public void moveY() {
        Rectangle bounds = panel.getBounds();
        if (this.panel.getY() < 485) {
            panel.setBounds(bounds.x, bounds.y + this.STEP, bounds.width, bounds.height);
        }
    }

    public JPanel getPanel() {
        return panel;
    }

    public boolean intersects(Attack fireBall) {
        return getPanel().getBounds().intersects(fireBall.getPanel().getBounds());
    }
}
