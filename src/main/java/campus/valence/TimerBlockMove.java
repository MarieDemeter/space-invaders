package campus.valence;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

public class TimerBlockMove {


    public TimerBlockMove(SpaceCampus game) {
        Timer timer = new Timer();
        int speed = 3500;
        if (game.getPoint() > 500) {
            speed = 3000;
        } else if (game.getPoint() > 1000) {
            speed = 2500;
        } else if (game.getPoint() > 1500){
            speed = 2000;
        } else if (game.getPoint() > 2000){
            speed = 1500;
        }
        timer.scheduleAtFixedRate(new TimerBlockMove.BlockMove(game), 0, speed);
    }

    public class BlockMove extends TimerTask {
        CopyOnWriteArrayList<Block> blocks;

        public BlockMove(SpaceCampus game) {
            this.blocks = game.getBlocks();
        }

        @Override
        public void run() {
            if (blocks.size() == 0) {
                return;
            }
            for (Block block : this.blocks) {
                block.moveY();
            }
        }
    }

}
