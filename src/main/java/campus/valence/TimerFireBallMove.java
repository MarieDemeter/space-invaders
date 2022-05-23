package campus.valence;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class TimerFireBallMove {

    public TimerFireBallMove(ArrayList<Attack> fireBalls) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new FireBallMove(fireBalls), 0, 100);
    }

    public class FireBallMove extends TimerTask {
        ArrayList<Attack> fireBalls;

        public FireBallMove(ArrayList<Attack> fireBalls) {
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
