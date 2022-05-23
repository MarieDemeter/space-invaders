package campus.valence;

import java.util.Timer;
import java.util.TimerTask;

public class TimerBlockMove {


        public TimerBlockMove(Block block) {
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerBlockMove.BlockMove(block), 0, 3000);
        }

        public class BlockMove extends TimerTask {
            Block block;

            public BlockMove(Block block) {
                this.block = block;
            }

            @Override
            public void run() {
                this.block.moveY();
            }
        }

}
