package civilization.model.map;

public class Map {
        private Tile[][] tiles;
        private int width;
        private int height;

        public Map(int width, int height) {
            this.width = width;
            this.height = height;
            this.tiles = new Tile[width][height];

            // Vul de array met tegels, anders is elke tegel nog 'null'!
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    // De volgorde moet zijn: Type, Row, Col
                    tiles[x][y] = new Tile(TerrainType.GRASSLAND, x, y);
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
        return tiles[row][col];
    }
}
