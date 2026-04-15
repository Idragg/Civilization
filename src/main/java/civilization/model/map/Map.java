package civilization.model.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Map {
        private Tile[][] tiles;
        private int width;
        private int height;

        public Map(int width, int height) {
            this.width = width;
            this.height = height;
            this.tiles = new Tile[width][height];

            Random rand = new Random();
            // Vul de array met tegels, anders is elke tegel nog 'null'!
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    // De volgorde moet zijn: Type, Row, Col
                    List<TerrainType> terrainTypes = new ArrayList<>();
                    terrainTypes.addAll(Arrays.asList(TerrainType.values()));
                    TerrainType terrainType = terrainTypes.get(rand.nextInt(terrainTypes.size()));
                    tiles[x][y] = new Tile(terrainType, x, y);
                }
            }
        }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Tile getTile(int row, int col) {
        if (col >= 0 && col < width && row >= 0 && row < height) {
            return tiles[col][row];
        }
        return null;
    }
}
