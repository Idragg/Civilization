package civilization.view.tile;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;


public class TileView extends StackPane {
    private Polygon polygon;
    private final double radius;
    private Label lblCityName;

    // We gebruiken nu een Group om het getekende stadsicoon in te plaatsen
    private Group cityIconGroup;

    // Unit-nodes (blijven ongewijzigd)
    private Circle unitMarker;
    private ImageView unitImageView;

    public TileView(Paint terrainColor, double radius) {
        this.radius = radius;
        initializeNodes();

        drawHexagonPoints();

        this.polygon.setFill(terrainColor);
        this.polygon.setStroke(Color.BLACK);
        this.polygon.setStrokeWidth(1);
    }

    private void initializeNodes() {
        this.polygon = new Polygon();
        this.lblCityName = new Label();

        // Initialiseer de groep voor het stadsicoon
        this.cityIconGroup = new Group();

        // Styling voor label
        lblCityName.setTextFill(Color.WHITE);
        lblCityName.setStyle("-fx-font-weight: bold; -fx-background-color: rgba(0,0,0,0.5);");
        lblCityName.setVisible(false);

        // Voeg alles toe in de basisvolgorde. cityIconGroup vervangt imgCityView.
        this.getChildren().addAll(polygon, cityIconGroup, lblCityName);

        this.setPickOnBounds(false);
    }

    private void drawHexagonPoints() {
        polygon.getPoints().clear();
        for (int i = 0; i < 6; i++) {
            double angle = Math.toRadians(60 * i - 30);
            polygon.getPoints().addAll(
                    radius * Math.cos(angle),
                    radius * Math.sin(angle)
            );
        }
    }

    private void drawCityIcon(Paint playerColor, int level) {
        cityIconGroup.getChildren().clear(); // Wis het oude icoon

        // Bepaal de grootte van een enkel huisje (we maken ze klein zodat er meerdere passen)
        double houseWidth = radius * 0.35;
        double houseHeight = radius * 0.25;
        double roofHeight = radius * 0.15;

        // We gebruiken een lijst met vooraf gedefinieerde posities (offsets) voor de huisjes.
        // Dit zorgt ervoor dat ze netjes op de hexagon verdeeld worden.
        Point2D[] housePositions = new Point2D[] {
                new Point2D(0, 0),                       // 1. Midden
                new Point2D(-houseWidth * 0.7, houseHeight * 0.5),  // 2. Linksonder
                new Point2D(houseWidth * 0.7, -houseHeight * 0.5),  // 3. Rechtsboven
                new Point2D(-houseWidth * 0.7, -houseHeight * 0.5), // 4. Linksboven
                new Point2D(houseWidth * 0.7, houseHeight * 0.5),   // 5. Rechtsonder
                new Point2D(0, -houseHeight * 1.1),      // 6. Middenboven
                new Point2D(0, houseHeight * 1.1),       // 7. Middenonder
                new Point2D(-houseWidth * 1.4, 0),        // 8. Ver naar links
                new Point2D(houseWidth * 1.4, 0)          // 9. Ver naar rechts
        };

        // Bepaal hoeveel huisjes we gaan tekenen op basis van het level.
        // We voegen per X inwoners een huisje toe (bijv. per 2 inwoners).
        int numHouses = 1; // Altijd minstens 1 huisje

        if (level > 0) {
            // Formule: Voeg 1 huisje toe per 2 inwoners, met een maximum van 9 huisjes.
            numHouses = 1 + (level / 2);
        }
        if (numHouses > housePositions.length) {
            numHouses = housePositions.length; // Beperk tot het aantal posities
        }

        // Teken elk huisje op de toegewezen positie
        for (int i = 0; i < numHouses; i++) {
            Point2D pos = housePositions[i];

            // --- Het Lichaam van het Huis (Vierkant/Rechthoek) ---
            Rectangle body = new Rectangle(pos.getX() - houseWidth / 2, pos.getY() - houseHeight / 2, houseWidth, houseHeight);
            body.setFill(Color.BEIGE); // neutrale muurkleur
            body.setStroke(Color.BLACK);
            body.setStrokeWidth(0.5); // dunnere lijn voor kleinere huisjes

            // --- Het Dak (Driehoek/Polygon) ---
            Polygon roof = new Polygon();
            roof.getPoints().addAll(
                    pos.getX(), pos.getY() - houseHeight / 2 - roofHeight,         // Top van het dak
                    pos.getX() - houseWidth / 2 * 1.1, pos.getY() - houseHeight / 2, // Links onder
                    pos.getX() + houseWidth / 2 * 1.1, pos.getY() - houseHeight / 2  // Rechts onder
            );
            roof.setFill(playerColor); // Dakpannen hebben de spelerkleur
            roof.setStroke(Color.BLACK);
            roof.setStrokeWidth(0.5);

            cityIconGroup.getChildren().addAll(body, roof);
        }

        // Verschuif de hele groep een klein beetje omhoog
        cityIconGroup.setTranslateY(-radius * 0.05);
    }

    public void setUnit(Paint playerColor, Image unitImage) {
        if (unitMarker != null) this.getChildren().remove(unitMarker);
        if (unitImageView != null) this.getChildren().remove(unitImageView);

        if (unitImage != null) {
            unitMarker = new Circle(radius / 3.0, playerColor);
            unitMarker.setStroke(Color.WHITE);
            unitMarker.setStrokeWidth(2);

            unitImageView = new ImageView(unitImage);
            unitImageView.setFitHeight(radius * 1.2);
            unitImageView.setPreserveRatio(true);

            this.getChildren().addAll(unitMarker, unitImageView);

            lblCityName.toFront();
        }
    }


    public void setCity(String cityName, Paint playerColor, int level) {
        if (cityName == null) {
            lblCityName.setVisible(false);
            cityIconGroup.getChildren().clear(); // Verwijder het getekende huisje
            this.polygon.setStroke(Color.BLACK);
            this.polygon.setStrokeWidth(1);
            return;
        }

        lblCityName.setVisible(true);
        lblCityName.setText(cityName);

        // Teken het huisje met de spelerkleur en het juiste level
        drawCityIcon(playerColor, level);

        this.polygon.setStroke(playerColor);
        this.polygon.setStrokeWidth(3);

        polygon.toBack();
        cityIconGroup.toBack(); // Stad achter de unit
        polygon.toBack();
    }
}