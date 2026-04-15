package civilization.view;

import civilization.model.Settings;
import civilization.view.tile.TileView;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;


public class View extends Pane {
    private static final double RADIUS = Settings.TILE_SIZE_RADIUS;
    private TileView[][] tileArray; // Handig om later tiles terug te vinden

    public void addTile(int col, int row, Paint terrainColor) {
        TileView tileView = new TileView(terrainColor, RADIUS);
        Point2D center = getTileCenter(col, row);

        tileView.setLayoutX(center.getX());
        tileView.setLayoutY(center.getY());

        if (tileArray == null) {
            // Fix: zorg dat de array bestaat (bijv. 20x20 of dynamisch)
            tileArray = new TileView[20][20];
        }
        tileArray[col][row] = tileView;
        this.getChildren().add(tileView);
    }

    // Deze methode is nu super simpel!
    public void addUnitToTile(int col, int row, Paint playerColor, Image unitImage) {
        if (tileArray != null && tileArray[col][row] != null) {
            // Als unitImage null is, zal TileView de visuals verwijderen
            tileArray[col][row].setUnit(playerColor, unitImage);
        }
    }

    private Point2D getTileCenter(int col, int row) {
        // Breedte van pointy hex = sqrt(3) * R
        // Hoogte van pointy hex = 2 * R
        double horizontalSpacing = RADIUS * Math.sqrt(3);
        double verticalSpacing = RADIUS * 1.5;

        // LET OP: Omdat je in je screenshot kolommen ziet verspringen,
        // gebruik je waarschijnlijk "Flat Top" logica in een "Pointy" grid.
        // Voor de oriëntatie in jouw screenshot (image_25f38c) moet dit het zijn:

        double xPos = col * horizontalSpacing;
        if (row % 2 != 0) {
            xPos += horizontalSpacing / 2.0;
        }
        double yPos = row * verticalSpacing;

        return new Point2D(xPos + (horizontalSpacing/2), yPos + RADIUS);
    }

    public void clear() {
       this.getChildren().clear();
       this.tileArray = null;
    }

    public TileView getTileView(int col, int row) {
        return tileArray[col][row];
    }
}