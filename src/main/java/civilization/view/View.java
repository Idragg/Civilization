package civilization.view;

import civilization.model.map.Map;
import civilization.model.map.TerrainType;
import civilization.model.map.Tile;
import civilization.view.tile.TileView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class View extends Pane {

    public View() {
        initializeNodes();
        layoutNodes();
    }

    private void initializeNodes() {

    }

    private void layoutNodes() {

    }

    public void generateGrid(Map mapModel) {
        this.getChildren().clear();
        double radius = 30.0;
        // De horizontale afstand tussen twee kolommen
        double widthVal = Math.sqrt(3) * radius;
        // De verticale afstand tussen twee rijen (75% van de hoogte voor overlap)
        double heightVal = 2 * radius * 0.75;

        for (int col = 0; col < mapModel.getWidth(); col++) {
            for (int row = 0; row < mapModel.getHeight(); row++) {
                Tile tileData = mapModel.getTile(col, row);
                TileView tileView = new TileView(tileData);

                double xPos = col * widthVal;

                // Verspringen: elke oneven rij moet een halve breedte naar rechts
                if (row % 2 != 0) {
                    xPos += widthVal / 2.0;
                }

                double yPos = row * heightVal;

                tileView.setLayoutX(xPos);
                tileView.setLayoutY(yPos);
                this.getChildren().add(tileView);
            }
        }
    }

    private Paint determineColor(TerrainType type) {
        return switch (type) {
            case GRASSLAND -> Color.LIGHTGREEN;
            case DESERT -> Color.MOCCASIN;
            case OCEAN -> Color.AZURE;
            case MOUNTAIN -> Color.SADDLEBROWN;
            case FOREST -> Color.FORESTGREEN;
            default -> Color.GRAY;
        };
    }
}
