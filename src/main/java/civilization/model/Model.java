package civilization.model;


import civilization.model.map.Map;
import civilization.model.map.Tile;
import civilization.model.units.Unit;
import civilization.model.units.Warrior;

public class Model {
    private Map map;

    public Model() {
        map = new Map(Settings.WIDTHMAP, Settings.HEIGHTMAP);

        // Test: Zet een Warrior op tegel (0,0)
        Tile testTile = map.getTile(0, 0);
        Unit mijnWarrior = new Warrior();
        map.getTile(2, 2).setUnit((Warrior) mijnWarrior);

        // Controleer in de console
        if (testTile.getOccupied()) {
            System.out.println("Unit succesvol geplaatst op tegel!");
        }
    }

    public Map getMap() {
        return map;
    }
}
