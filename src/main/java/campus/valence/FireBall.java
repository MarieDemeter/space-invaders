package campus.valence;

import javax.swing.*;
import java.awt.*;

public class FireBall extends Attack {

    public FireBall(int x) {
        super(20);
        this.createFireBall(x);
    }

    private void createFireBall(int x) {
        this.getPanel().setBounds((x + 20), 480, 5, 10);
        this.getPanel().setBackground(Color.red);
    }

}
