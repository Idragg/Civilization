package civilization.model.player;

public class Player {
    private int gold;
    private String name;

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
}
