package civilization.model.player;

public class Player {
    private int gold;
    private String name;
    private int r;
    private int g;
    private int b;

    public Player(String name) {
        this.name = name;
        gold = 0;
    }

    public int getGold() {
        return gold;
    }

    public String getName() {
        return name;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
