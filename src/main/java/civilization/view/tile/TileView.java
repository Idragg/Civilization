package civilization.view.tile;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;

public class TileView extends StackPane {
    private final Polygon polygon;

    public TileView(Paint color, double radius) {
        this.polygon = createHexagon(radius);
        this.polygon.setFill(color);
        this.polygon.setStroke(javafx.scene.paint.Color.BLACK);

        this.getChildren().add(polygon);
    }

    private Polygon createHexagon(double radius) {
        Polygon poly = new Polygon();
        for (int i = 0; i < 6; i++) {
            // Flat-topped hoekberekening
            double angle = Math.toRadians(60 * i);
            poly.getPoints().addAll(
                    radius * Math.cos(angle),
                    radius * Math.sin(angle)
            );
        }
        return poly;
    }
}