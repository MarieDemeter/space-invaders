package campus.valence;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

public class TimerFireBallMove {

    public TimerFireBallMove(CopyOnWriteArrayList<Attack> fireBalls) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new FireBallMove(fireBalls), 0, 100);
    }

    public class FireBallMove extends TimerTask {
        CopyOnWriteArrayList<Attack> fireBalls;

        public FireBallMove(CopyOnWriteArrayList<Attack> fireBalls) {
            this.fireBalls = fireBalls;
        }

        @Override
        public void run() {
            for (Attack fireBall : this.fireBalls) {
                fireBall.moveY();
            }
        }
    }

}
