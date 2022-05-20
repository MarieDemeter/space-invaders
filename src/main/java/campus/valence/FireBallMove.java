package campus.valence;

import java.util.TimerTask;

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
