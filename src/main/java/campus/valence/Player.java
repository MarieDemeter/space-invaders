package campus.valence;

public class Player {
    private String name;
    private boolean isDead;

    public Player(String name) {
        this.name = name;
        this.isDead = false;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }
}
