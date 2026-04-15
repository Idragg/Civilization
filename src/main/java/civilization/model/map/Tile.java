package civilization.model.map;

import civilization.model.player.Civilization;
import civilization.model.units.Unit;
import civilization.model.units.Warrior;

public class Tile {
    private TerrainType terrainType;
    private Civilization civilization;
    private int row;
    private int col;
    private boolean occupied;
    private Unit unit;

    public Tile(TerrainType terrainType, int row, int col) {
        this.terrainType = terrainType;
        this.civilization = null;
        this.row = row;
        this.col = col;
    }

    public void setCivilization(Civilization civilization) {
        this.civilization = civilization;
    }

    public void setUnit(Unit unit) { this.unit = unit; }
    public void removeUnit() { this.unit = null; }

    public TerrainType getTerrainType() {
        return terrainType;
    }

    public Civilization getCivilization() {
        return civilization;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean getOccupied() {
        return occupied;
    }

    public void setUnit(Warrior warrior) {
        this.unit = warrior;
        this.occupied = true;
    }

    public Unit getUnit() {
        return unit;
    }
}
