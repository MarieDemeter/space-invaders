package campus.valence;

import java.util.Timer;
import java.util.TimerTask;

public class TimerCollision {

    public TimerCollision(SpaceCampus game) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new Collision(game), 0, 100);
    }

    public static class Collision extends TimerTask {
        SpaceCampus game;

        public Collision(SpaceCampus game) {
            this.game = game;
        }

        @Override
        public void run() {
            this.game.collision();
        }
    }
}
