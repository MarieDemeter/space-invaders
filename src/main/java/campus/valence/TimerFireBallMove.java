package campus.valence;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class TimerFireBallMove {

    public TimerFireBallMove(ArrayList<FireBall> fireBalls) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new FireBallMove(fireBalls), 0, 100);
    }

    public class FireBallMove extends TimerTask {
        ArrayList<FireBall> fireBalls;

        public FireBallMove(ArrayList<FireBall> fireBalls) {
            this.fireBalls = fireBalls;
        }

        @Override
        public void run() {
            for (FireBall fireBall : this.fireBalls) {
                fireBall.moveY();
            }
        }
    }

}
