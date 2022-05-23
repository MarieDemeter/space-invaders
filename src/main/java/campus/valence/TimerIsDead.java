package campus.valence;


import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class TimerIsDead {

    public TimerIsDead(SpaceCampus game) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerDead(game), 0, 100);
    }

    public static class TimerDead extends TimerTask {
        private SpaceCampus game;

        public TimerDead(SpaceCampus game) {
            this.game = game;
        }

        @Override
        public void run() {
            this.game.isDead();
        }
    }

}
