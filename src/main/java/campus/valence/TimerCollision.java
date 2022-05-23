package campus.valence;

import java.util.Timer;
import java.util.TimerTask;

public class TimerCollision {

//    public TimerCollision(SpaceCampus game) {
//        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(new Collision(game), 0, 200);
//    }
//
//    public static class Collision extends TimerTask {
//        SpaceCampus game;
//
//        public Collision(SpaceCampus game) {
//            this.game = game;
//        }
//
//        @Override
//        public void run() {
//            this.game.collision();
//        }
//    }

    public TimerCollision(SpaceCampus game, FireBall fireball) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new Collision(game, fireball), 0, 100);
    }

    public static class Collision extends TimerTask {
        FireBall fireball;
        SpaceCampus game;

        public Collision(SpaceCampus game, FireBall fireBall) {
            this.game = game;
            this.fireball = fireBall;
        }

        @Override
        public void run() {
            this.game.collision();
        }
    }
}
