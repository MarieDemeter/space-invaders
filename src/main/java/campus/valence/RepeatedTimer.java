package campus.valence;

import java.util.Timer;
import java.util.TimerTask;

public class RepeatedTimer {

    public RepeatedTimer(FireBall fireBall) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new FireBallMove(fireBall), 0, 500);
    }
}
