package campus.valence;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SpaceCampus {

    private JFrame frame;
    private JPanel panel;
    private Destroyer destroyer;
    private ArrayList<campus.valence.FireBall> fireBalls;
    private ArrayList<campus.valence.Block> blocks;

    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    public JPanel getPanel() {
        return panel;
    }

    SpaceCampus() {
        this.fireBalls = new ArrayList<>();
        this.blocks = new ArrayList<>();
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
        launch();

        new TimerFireBallMove(this.fireBalls);
        new TimerCollision(this);
    }

    public void launch() {
//        if(this.destroyer.isDead()) {
//          this.panel = new JPanel();
//          JPanel gameOver = new JPanel();
//          gameOver.setBackground(Color.black);
//          this.panel.add(gameOver);
//        }
        this.frame.setVisible(true);
    }

    private void createDestroyer() {
        destroyer = new Destroyer(this);
        this.panel.add(destroyer.getPanel());
        this.panel.addKeyListener(new GameKeyListener(destroyer));
    }

    private void createBlocks() {
        new TimerCreateBlock(this);
        new TimerBlockMove(this.blocks);
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
            FireBall fireBall = this.fireBalls.get(i);
            int j = 0;
            while (j < blocks.size()) {
                Block block = this.blocks.get(j);

                if (block.intersects(fireBall)) {
                    block.getPanel().setVisible(false);
                    fireBall.getPanel().setVisible(false);
                    blockIndexToDelete = j;
                    fireBallIndexToDelete = i;
                } else if (fireBall.getPanel().getBounds().getY() <= 5) {
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


}
