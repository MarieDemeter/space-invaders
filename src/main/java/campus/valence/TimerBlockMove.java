package campus.valence;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class TimerBlockMove {


    public TimerBlockMove(ArrayList<Block> blocks) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerBlockMove.BlockMove(blocks), 0, 2000);
    }

    public class BlockMove extends TimerTask {
        ArrayList<Block> blocks;

        public BlockMove(ArrayList<Block> blocks) {
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
