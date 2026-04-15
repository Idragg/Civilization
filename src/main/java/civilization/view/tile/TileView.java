package civilization.view.tile;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;

public class TileView extends StackPane {
    private Polygon polygon;
    private final double radius;

    public TileView(Paint terrainColor, double radius) {
        this.radius = radius;
        // 1. Maak eerst het object aan
        this.polygon = new Polygon();

        // 2. Vul het object met punten
        drawHexagonPoints();

        // 3. Styling
        this.polygon.setFill(terrainColor);
        this.polygon.setStroke(Color.BLACK);
        this.polygon.setStrokeWidth(1);

        // 4. Toevoegen aan StackPane
        this.getChildren().add(polygon);

        // Voorkom dat de StackPane gaat "wiebelen" door marges
        this.setPickOnBounds(false);
    }


    private void drawHexagonPoints() {
        polygon.getPoints().clear();
        for (int i = 0; i < 6; i++) {
            // Pointy-top hoek: 30, 90, 150, 210, 270, 330
            double angle = Math.toRadians(60 * i - 30);
            polygon.getPoints().addAll(
                    radius * Math.cos(angle),
                    radius * Math.sin(angle)
            );
        }
    }

    // makes the unit with a color and a image = rol of unit
    public void setUnit(Paint playerColor, Image unitImage) {
        // Verwijder oude unit-layers als die er zijn (zodat je niet stapelt)
        this.getChildren().removeIf(node -> node instanceof Circle || node instanceof ImageView);

        if (unitImage != null) {
            // 1. De cirkel marker
            Circle unitMarker = new Circle(radius / 3.0, playerColor);
            unitMarker.setStroke(Color.WHITE);
            unitMarker.setStrokeWidth(2);

            // 2. De afbeelding
            ImageView unitImageView = new ImageView(unitImage);
            unitImageView.setFitHeight(radius * 1.2);
            unitImageView.setPreserveRatio(true);

            // Omdat dit een StackPane is, worden ze automatisch gecentreerd!
            // Geen layoutX of translateY gedoe meer nodig.
            this.getChildren().addAll(unitMarker, unitImageView);
        }
    }
}