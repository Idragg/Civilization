package civilization.view;

import civilization.model.Settings;
import civilization.view.tile.TileView;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;

public class View extends Pane {
    private static final double RADIUS = Settings.TILE_SIZE_RADIUS;
    private TileView[][] tileArray;

    void addTile(int col, int row, Paint terrainColor) {
        // Zorg dat de array geïnitialiseerd is voordat we er iets in stoppen
        if (tileArray == null) {
            tileArray = new TileView[25][25]; // Vergroot indien nodig naar je mapgrootte
        }

        TileView tileView = new TileView(terrainColor, RADIUS);
        Point2D center = getTileCenter(col, row);

        tileView.setLayoutX(center.getX());
        tileView.setLayoutY(center.getY());

        tileArray[col][row] = tileView;
        this.getChildren().add(tileView);
    }

    void addUnitToTile(int col, int row, Paint playerColor, Image unitImage) {
        if (tileArray != null && tileArray[col][row] != null) {
            tileArray[col][row].setUnit(playerColor, unitImage);
        }
    }

    /**
     * Aangepast: cityImage is vervangen door cityLevel.
     * De TileView tekent nu zelf het huisje op basis van dit level.
     */
    void addCityToTile(int col, int row, Paint playerColor, String cityName, int cityLevel) {
        if (tileArray != null && tileArray[col][row] != null) {
            tileArray[col][row].setCity(cityName, playerColor, cityLevel);
        }
    }

    Point2D getTileCenter(int col, int row) {
        double horizontalSpacing = RADIUS * Math.sqrt(3);
        double verticalSpacing = RADIUS * 1.5;

        double xPos = col * horizontalSpacing;
        // Offset voor de oneven rijen (Pointy Top Hexagon grid)
        if (row % 2 != 0) {
            xPos += horizontalSpacing / 2.0;
        }
        double yPos = row * verticalSpacing;

        return new Point2D(xPos, yPos);
    }

    void clear() {
        this.getChildren().clear();
        this.tileArray = null;
    }

    TileView getTileView(int col, int row) {
        if (tileArray == null || col < 0 || row < 0 || col >= tileArray.length || row >= tileArray[0].length) {
            return null;
        }
        return tileArray[col][row];
    }
}