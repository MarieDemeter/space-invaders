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

    public void intersect(Shape other) {
//        return .getBounds2D().intersects(other.getBounds2D());
    }

    private void createDestroyer() {
        destroyer = new Destroyer(this);
        this.panel.add(destroyer.getPanel());
        this.panel.addKeyListener(new GameKeyListener(destroyer));
    }

    private void createBlocks() {
        int random = (int) (Math.random() * 6) + 1;
        for (int i = 0; i < random; i++) {
            Block block = new Block(i,random);
            this.blocks.add(block);
        }
        for (Block block : this.blocks) {
            this.panel.add(block.getPanel());
            //this.panel.repaint();
        }

//        JPanel panel1 = new JPanel();
//        panel1.setBounds(5, 5, 80, 30);
//        panel1.setBackground(Color.BLUE);
//        this.panel.add(panel1);
//
//        JPanel panel2 = new JPanel();
//        panel2.setBounds(100, 5, 80, 30);
//        panel2.setBackground(Color.BLUE);
//        this.panel.add(panel2);
    }

    public void fire(FireBall fireBall) {
        this.fireBalls.add(fireBall);
        this.panel.add(fireBall.getPanel());
    }


}
