package civilization.model.map;

import civilization.model.player.Civilization;

public class Tile {
    private TerrainType terrainType;
    private Civilization civilization;
    private int row;
    private int col;
    private boolean occupied;

    public Tile(TerrainType terrainType, int row, int col) {
        this.terrainType = terrainType;
        this.civilization = null;
        this.row = row;
        this.col = col;
    }

    public void setCivilization(Civilization civilization) {
        this.civilization = civilization;
    }

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
}
