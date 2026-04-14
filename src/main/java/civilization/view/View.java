package civilization.view;

import civilization.view.tile.TileView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;

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
}
