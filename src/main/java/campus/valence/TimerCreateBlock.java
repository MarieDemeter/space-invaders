package campus.valence;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class TimerCreateBlock {

    public TimerCreateBlock(SpaceCampus game) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new CreateBlock(game), 0, 3000);
    }

    public static class CreateBlock extends TimerTask {
        private SpaceCampus game;
        private int lineNb;

        public CreateBlock(SpaceCampus game) {
            this.game = game;
            this.lineNb = 0;
        }

        @Override
        public void run() {

            int random = (int) (Math.random() * 4) + 1;
            for (int i = 0; i < random; i++) {
                Block block = new Block(i, random);
                this.game.getBlocks().add(block);
            }
            for (Block block : this.game.getBlocks()) {
                this.game.getPanel().add(block.getPanel());
            }
            this.game.getPanel().repaint();

        }
    }

}
