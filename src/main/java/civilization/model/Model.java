package civilization.model;


import civilization.model.map.Map;
import civilization.model.map.Tile;
import civilization.model.player.Civilization;
import civilization.model.player.Player;
import civilization.model.units.Settler;
import civilization.model.units.Unit;
import civilization.model.units.Warrior;

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
