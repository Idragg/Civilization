package civilization.model.units;

public class Settler extends Unit{
    private final static int MAX_HEALTH = 100;
    private int health;
    private int position;

    public Settler(int position) {
        this.position = position;
        this.health = MAX_HEALTH;
    }
}
