package campus.valence;

import javax.swing.*;
import java.awt.*;

public class Block {
    private JPanel panel;
    private JLabel label;
    private int STEP;
    private int nbToKill;

    public Block(int i, int nbOfBlock) {
        this.STEP = 35;
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

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public JLabel getLabel() {
        return label;
    }

    private void createBlock(int i, int nbOfBlock) {
        int width = 70;
        int widthFrame = 400;
        int widthGap = widthFrame - width * nbOfBlock;
        int gap = (int) widthGap / nbOfBlock;

        int randomColor = (int) (Math.random()*9) +1;
        switch (randomColor) {
            case 1:
                this.panel.setBackground(Color.YELLOW);
                this.nbToKill = 3;
                break;
            case 2:
                this.panel.setBackground(Color.GREEN);
                this.nbToKill = 5;
                break;
            case 3:
                this.panel.setBackground(Color.ORANGE);
                this.nbToKill = 7;
                break;
            default:
                this.panel.setBackground(Color.BLUE);
                this.nbToKill = 1;
                break;
        }
        this.label.setText(Integer.toString(nbToKill));
        this.panel.add(label);
        this.panel.setBounds((gap / 2) * (i + 1) + width * i, 35, width, 30);

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
