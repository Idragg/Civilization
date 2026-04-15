package civilization.model.units;

public abstract class Unit {
    private int health = 100;
    private int movementPoints = 3;
    private int col;
    private int row;

    public void setCoordinates(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }

    public int getMovementPoints() {
        return movementPoints;
    }
}
