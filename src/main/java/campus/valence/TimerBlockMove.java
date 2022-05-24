package campus.valence;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

public class TimerBlockMove {


    public TimerBlockMove(CopyOnWriteArrayList<Block> blocks) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerBlockMove.BlockMove(blocks), 0, 1500);
    }

    public class BlockMove extends TimerTask {
        CopyOnWriteArrayList<Block> blocks;

        public BlockMove(CopyOnWriteArrayList<Block> blocks) {
            this.blocks = blocks;
        }

        @Override
        public void run() {
            if(blocks.size()==0){
                return;
            }
            for (Block block : this.blocks) {
                block.moveY();
            }
        }
    }

}
