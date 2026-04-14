package civilization.view;

import civilization.model.Model;
import civilization.model.map.Map;
import civilization.model.map.Tile;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Presenter {
    private Model model;
    private View view;

    public Presenter(Model model, View view) {
        this.model = model;
        this.view = view;
        renderMap();
    }

    private void renderMap() {
        view.clear();
        Map map = model.getMap();

        for (int col = 0; col < map.getWidth(); col++) {
            for (int row = 0; row < map.getHeight(); row++) {
                Tile tile = map.getTile(col, row);
                Paint color = getTerrainColor(tile.getTerrainType());

                // De Presenter vertelt de View wat hij moet doen met simpele types (int, Paint)
                view.addTile(col, row, color);
            }
        }
    }

    private Paint getTerrainColor(civilization.model.map.TerrainType type) {
        return switch (type) {
            case GRASSLAND -> Color.LIGHTGREEN;
            case DESERT -> Color.MOCCASIN;
            case OCEAN -> Color.AZURE;
            case MOUNTAIN -> Color.SADDLEBROWN;
            case FOREST -> Color.FORESTGREEN;
        };
    }
}