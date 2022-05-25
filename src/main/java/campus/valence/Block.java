package campus.valence;

import javax.swing.*;
import java.awt.*;

public class Block {
    private JPanel panel;
    private int STEP;
    private int nbToKill;
    private String url;
    private int extra;

    public Block(int i, int nbOfBlock) {
        this.STEP = 40;
        this.url = "";
        this.createBlock(i, nbOfBlock);
    }

    public int getExtra() {
        return extra;
    }

    public int getNbToKill() {
        return nbToKill;
    }

    public void setNbToKill(int nbToKill) {
        this.nbToKill = nbToKill;
    }


    private void createBlock(int i, int nbOfBlock) {
        int width = 50;
        int widthFrame = 400;
        int widthGap = widthFrame - width * nbOfBlock;
        int gap = widthGap / nbOfBlock;

        int randomColor = (int) (Math.random()*9) +1;
        switch (randomColor) {
            case 1:
                this.url = "src/main/java/image/invaderPurple.png";
                this.nbToKill = 3;
                this.extra = 2;
                break;
            case 2:
                this.url = "src/main/java/image/invaderRed.png";
                this.nbToKill = 5;
                this.extra = 3;
                break;
            case 3:
                this.url = "src/main/java/image/invaderBrown.png";
                this.nbToKill = 7;
                this.extra = 4;
                break;
            default:
                this.url = "src/main/java/image/invaderBlue.png";
                this.nbToKill = 1;
                this.extra = 1;
                break;
        }

        this.panel = new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                ImageIcon imageIcon = new ImageIcon(url);
                g2d.drawImage(imageIcon.getImage(), 0, 0, this);
                g2d.dispose();
            }
        };
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
