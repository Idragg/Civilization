package civilization.view.tile;

import civilization.model.map.TerrainType;
import civilization.model.map.Tile;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class TileView extends StackPane {
    private Tile tile;
    private Polygon polygon;

    public TileView(Tile tile) {
        this.tile = tile;
        initializeNodes();
        layoutNodes();
    }

    private void initializeNodes() {
        double radius = 30.0; // De grootte van je tegel
        this.polygon = createHexagon(radius);
    }

    private void layoutNodes() {
        polygon.setStroke(Color.BLACK);
        polygon.setFill(determineColor(tile.getTerrainType()));
        this.getChildren().add(polygon);
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

    private Polygon createHexagon(double radius) {
        Polygon polygon = new Polygon();
        for (int i = 0; i < 6; i++) {
            // Voeg Math.toRadians(30) toe om de hexagon plat te leggen
            double angle = Math.toRadians(60 * i + 30);
            double x = radius * Math.cos(angle);
            double y = radius * Math.sin(angle);
            polygon.getPoints().addAll(x, y);
        }
        return polygon;
    }

    public Tile getTile() {
        return tile;
    }
}
