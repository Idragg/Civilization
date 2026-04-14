package civilization.model;

public class City {
    private String name;
    private int level;
    private int amountInhabitants;


    public City(String name, int level) {
        this.name = name;
        this.level = level;
        this.amountInhabitants = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAmountInhabitants() {
        return amountInhabitants;
    }

    public void setAmountInhabitants(int amountInhabitants) {
        this.amountInhabitants = amountInhabitants;
    }
}
