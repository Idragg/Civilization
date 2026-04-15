package civilization.model;


import civilization.model.map.Map;
import civilization.model.map.Tile;
import civilization.model.player.City;
import civilization.model.player.Civilization;
import civilization.model.player.Player;
import civilization.model.units.Settler;
import civilization.model.units.Unit;

import java.util.Arrays;
import java.util.List;

public class Model {
    private Map map;
    private Player player;
    private List<Civilization> civilizations;

    public Model() {
        map = new Map(Settings.WIDTHMAP, Settings.HEIGHTMAP);

        this.civilizations = Arrays.asList(
                new Civilization("Rome", "Trajan"),
                new Civilization("The Netherlands", "Wilhelmina")
        );

        // Test: Zet een Warrior op tegel (0,0)
        Tile testTile = map.getTile(0, 0);
        Unit mijnSettler = new Settler();
        map.getTile(2, 2).setUnit(mijnSettler);

        // Controleer in de console
        if (testTile.getOccupied()) {
            System.out.println("Unit succesvol geplaatst op tegel!");
        }
    }

    public void settleCity(int col, int row) {
        Tile tile = map.getTile(col, row);

        // Check of er een unit op de tegel staat en of er nog geen stad is
        if (tile.getUnit() != null && !tile.hasCity()) {
            // Maak een nieuwe stad aan met de huidige speler als eigenaar
            // We gebruiken de naam van de leider voor de stad (bijv. "Trajan's City")
            String cityName = player.getName() + " Grad";
            City newCity = new City(cityName, this.player, col, row);

            tile.setCity(newCity);

            // De unit (Settler) verdwijnt zodra de stad is gebouwd
            tile.removeUnit();
            System.out.println("Stad gesticht: " + cityName + " op " + col + "," + row);
        }
    }







    /// getters en setters

    public Map getMap() {
        return map;
    }

    public List<Civilization> getAvailableCivilizations() {
        return civilizations;
    }

    public void createPlayer(String name) {
        this.player = new Player(name);
    }

    public Player getPlayer() {
        return player;
    }
}
