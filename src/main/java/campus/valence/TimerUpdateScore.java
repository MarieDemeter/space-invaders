package campus.valence;

import java.util.Timer;
import java.util.TimerTask;

public class TimerUpdateScore {

    public TimerUpdateScore(SpaceCampus game) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new UpdateScore(game), 0, 100);
    }

    public static class UpdateScore extends TimerTask {
        private SpaceCampus game;

        public UpdateScore(SpaceCampus game) {
            this.game = game;
        }

        @Override
        public void run() {
//            this.game.updateScore();
        }
    }

}
