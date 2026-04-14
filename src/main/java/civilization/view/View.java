package civilization.view;

import civilization.view.tile.TileView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class View extends Pane {
    private static final double RADIUS = 30.0;

    public void addTile(int col, int row, Paint terrainColor) {
        double horizontalSpacing = RADIUS * 1.5;
        double verticalSpacing = Math.sqrt(3) * RADIUS;

        TileView tileView = new TileView(terrainColor, RADIUS);

        // xPos berekening
        double xPos = col * horizontalSpacing;

        // yPos berekening met verspringen per kolom
        double yPos = row * verticalSpacing;
        if (col % 2 != 0) {
            yPos += verticalSpacing / 2.0;
        }

        // Belangrijk: Omdat de polygon rond (0,0) is getekend,
        tileView.setLayoutX(xPos + RADIUS);
        tileView.setLayoutY(yPos + (verticalSpacing / 2.0));

        this.getChildren().add(tileView);
    }

    public void clear() {
        this.getChildren().clear();
    }

    public void addUnitToTile(int col, int row, Paint unitColor) {
        // Gebruik exact dezelfde xPos/yPos berekening als bij de tiles
        double horizontalSpacing = RADIUS * 1.5;
        double verticalSpacing = Math.sqrt(3) * RADIUS;

        double xPos = col * horizontalSpacing + RADIUS;
        double yPos = row * verticalSpacing + (verticalSpacing / 2.0);
        if (col % 2 != 0) yPos += verticalSpacing / 2.0;

        // Maak een simpele representatie van de pion (bijv. een cirkel)
        Circle unitMarker = new Circle(10, unitColor);
        unitMarker.setStroke(Color.WHITE);

        unitMarker.setLayoutX(xPos);
        unitMarker.setLayoutY(yPos);

        this.getChildren().add(unitMarker);
    }
}
