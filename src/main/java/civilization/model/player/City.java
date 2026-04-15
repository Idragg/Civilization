package civilization.model.player;

import civilization.model.Model;
import civilization.model.map.Tile;

public class City {
    private Model model;
    private String nameCity;
    private int level;
    private int amountInhabitants;
    private Player owner;
    private int col;
    private int row;

    // city states
    public City(String nameCity) {
        this.nameCity = nameCity;
        this.level = 3;
        this.amountInhabitants = 5;
    }

    // own cities of player = settler
    public City(String nameCity, Player owner, int col, int row) {
        this.nameCity = nameCity;
        this.level = 0;
        this.owner = owner;
        this.col = col;
        this.row = row;
        this.amountInhabitants = 1;
    }

    public void settleCity(int col, int row) {
        Tile tile = model.getMap().getTile(col, row);

        // Check of er al een stad staat en of er een unit is die kan settlen
        if (!tile.hasCity() && tile.getUnit() != null) {
            // Gebruik de gegevens van de huidige speler en de locatie
            City newCity = new City("Rome", model.getPlayer(), col, row);
            tile.setCity(newCity);

            // Verwijder de unit (de settler offert zich op)
            tile.removeUnit();
        }
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
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

    public Player getOwner() {
        return owner;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}
