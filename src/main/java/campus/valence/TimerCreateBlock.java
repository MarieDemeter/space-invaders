package campus.valence;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class TimerCreateBlock {

    public TimerCreateBlock(SpaceCampus game) {
        Timer timer = new Timer();
        int speed = 1950;
//        if (game.getPoint() > 500) {
//            speed = 3200;
//        } else if (game.getPoint() > 1000) {
//            speed = 2700;
//        } else if (game.getPoint() > 1500){
//            speed = 2200;
//        } else if (game.getPoint() > 2000){
//            speed = 1700;
//        }
        timer.scheduleAtFixedRate(new CreateBlock(game), 0, speed);
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
