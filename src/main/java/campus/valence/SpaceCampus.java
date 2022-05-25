package campus.valence;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class SpaceCampus {

    private JFrame frame;
    private JPanel panel;
    private Destroyer destroyer;
    private CopyOnWriteArrayList<Attack> fireBalls;
    private CopyOnWriteArrayList<campus.valence.Block> blocks;
    private JLabel score;
    private int point;

    public Destroyer getDestroyer() {
        return destroyer;
    }

    public CopyOnWriteArrayList<Block> getBlocks() {
        return blocks;
    }

    public JPanel getPanel() {
        return panel;
    }

    SpaceCampus() {
        this.score = new JLabel();
        this.point = 0;
        this.fireBalls = new CopyOnWriteArrayList<>();
        this.blocks = new CopyOnWriteArrayList<>();
        panel = new JPanel();
        panel.setFocusable(true);
        panel.setLayout(null);

        frame = new JFrame();
        frame.setTitle("SPACE CAMPUS");
        frame.setSize(400, 600);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);

        createDestroyer();
        createBlocks();
        printScore();
        launch();

        new TimerIsDead(this);
        new TimerFireBallMove(this.fireBalls);
        new TimerCollision(this);


    }

    public void launch() {
        this.frame.setVisible(true);
    }

    private void createDestroyer() {
        destroyer = new Destroyer(this);
        this.panel.add(destroyer.getPanel());
        this.panel.addKeyListener(new GameKeyListener(destroyer));
    }

    public int getPoint() {
        return point;
    }

    private void createBlocks() {
        new TimerCreateBlock(this);
//        this.frame.repaint();
        new TimerBlockMove(this);
    }

    public void fire(FireBall fireBall) {
        this.fireBalls.add(fireBall);
        this.panel.add(fireBall.getPanel());
    }

    public void collision() {
        if (fireBalls.size() == 0) {
            return;
        }

        Integer blockIndexToDelete = null;
        Integer fireBallIndexToDelete = null;

        int i = 0;
        while (i < fireBalls.size()) {
            Attack fireBall = this.fireBalls.get(i);
            int j = 0;
            while (j < blocks.size()) {
                Block block = this.blocks.get(j);
                if (block.intersects(fireBall)) {
                    if (block.getNbToKill() > 1) {
                        block.setNbToKill(block.getNbToKill() - 1);
                        fireBallIndexToDelete = i;
                    } else {
                        block.getPanel().setVisible(false);
                        blockIndexToDelete = j;
                        fireBallIndexToDelete = i;
                        this.point += 10;
                        this.updateScore();
                    }
                    fireBall.getPanel().setVisible(false);
                } else if (fireBall.getPanel().getBounds().getY() <= 35) {
                    fireBall.getPanel().setVisible(false);
                    fireBallIndexToDelete = i;
                }
                j++;
            }
            i++;
        }
        if (blockIndexToDelete != null) {
            this.blocks.remove((int) blockIndexToDelete);

        }

        if (fireBallIndexToDelete != null) {
            this.fireBalls.remove((int) fireBallIndexToDelete);
        }

    }

    public void isDead() {
        if (blocks.size() == 0) {
            return;
        }
        if (!this.getDestroyer().isDead()) {

            for (Block block : this.blocks) {
                if (block.getPanel().getBounds().getY() >= 490) {
                    this.destroyer.setDead(true);
                }
            }
        } else {
            System.exit(0);
//            this.panel.removeAll();
//            this.panel.setBackground(Color.black);
//            JLabel gameOver = new JLabel();
//            gameOver.setText("GAME OVER");
//            gameOver.setHorizontalTextPosition(JLabel.CENTER);
//            gameOver.setFont(new Font ("MV Boli", Font.PLAIN, 50));
//            gameOver.setOpaque(true);
//            this.panel.add(gameOver);
        }
    }

    public void printScore() {
        this.score.setBounds(0, 0, 400, 25);
        this.score.setText("SCORE : " + this.point);
        this.frame.add(score);
        new TimerUpdateScore(this);
    }

    public void updateScore() {
        this.score.removeAll();
        this.score.setText("SCORE : " + this.point);

    }
}
