package campus.valence;

import javax.swing.*;
import java.awt.*;

public class FireBall extends Attack {

    public FireBall(int x) {
        super(15);
        this.createFireBall(x);
    }

    private void createFireBall(int x) {
        this.getPanel().setBounds((x + 50), 485, 10, 10);
        this.getPanel().setBackground(Color.red);
    }

}
