package campus.valence;

import java.util.Timer;
import java.util.TimerTask;

public class TimerFireBallMove {

    public TimerFireBallMove(FireBall fireBall) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new FireBallMove(fireBall), 0, 150);
    }

    public class FireBallMove extends TimerTask {
        FireBall fireBall;

        public FireBallMove(FireBall fireBall) {
            this.fireBall = fireBall;
        }

        @Override
        public void run() {
            this.fireBall.moveY();
        }
    }

}
