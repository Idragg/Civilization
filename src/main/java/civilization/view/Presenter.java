package civilization.view;

import civilization.model.Model;
import civilization.model.map.Map;
import civilization.model.map.TerrainType;
import civilization.model.map.Tile;
import civilization.model.player.City;
import civilization.model.player.Player;
import civilization.model.units.Settler;
import civilization.model.units.Unit;
import civilization.view.tile.TileView;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Presenter {
    private Model model;
    private View view;
    private Tile selectedTile;

    Image settlerImage = new Image(getClass().getResourceAsStream("/unitsCiv6/Settler_Civ6.jpg"));

    public Presenter(Model model, View view) {
        this.model = model;
        this.view = view;
        renderMap();
        addEventHandlers();

    }

    public void addEventHandlers() {
        Map map = model.getMap();

        for (int col = 0; col < map.getWidth(); col++) {
            for (int row = 0; row < map.getHeight(); row++) {
                // Haal de TileView op uit de View (deze moet in de tileArray zitten)
                TileView tileView = view.getTileView(col, row);

                if (tileView != null) {
                    final int finalCol = col;
                    final int finalRow = row;

                    tileView.setOnMouseClicked(event -> {
                        handleTileClick(finalCol, finalRow);
                    });
                }
            }
        }
    }

    public void handleTileClick(int col, int row) {
        Tile clickedTile = model.getMap().getTile(col, row);

        if (selectedTile != null && selectedTile == clickedTile) {
            if (selectedTile.getUnit() instanceof Settler) {
                model.settleCity(col, row);
                selectedTile = null;
                renderMap();
                addEventHandlers();
            }
            return;
        }

        if (selectedTile == null) {
            // STAP 1: select the unit you want to move
            if (clickedTile.getUnit() != null) {
                selectedTile = clickedTile;
                System.out.println("Unit geselecteerd op " + col + "," + row);
            }
        } else {
            Unit unit = selectedTile.getUnit();
            if (unit != null) {
                int distance = calculateDistance(selectedTile, clickedTile);

                if (distance <= unit.getMovementPoints()) {
                    moveUnit(selectedTile, clickedTile);
                } else {
                    handleMovementToBig();
                }

                selectedTile = null; // unselects tile
                renderMap(); // draws map after change
                addEventHandlers();
            }
        }
    }

    private int calculateDistance(Tile a, Tile b) {
        int col1 = a.getCol();
        int row1 = a.getRow();
        int col2 = b.getCol();
        int row2 = b.getRow();

        // De standaard Pointy-Top Axiale formule (zonder gedraaide assen)
        int q1 = col1 - (row1 - (row1 % 2)) / 2;
        int r1 = row1;

        int q2 = col2 - (row2 - (row2 % 2)) / 2;
        int r2 = row2;

        return (Math.abs(q1 - q2)
                + Math.abs(q1 + r1 - q2 - r2)
                + Math.abs(r1 - r2)) / 2;
    }

    private void handleMovementToBig() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Movement to big");
        alert.setHeaderText("Movement to big");
        alert.setContentText("Movement to big");
        alert.getButtonTypes().setAll(ButtonType.OK);
        alert.showAndWait();

    }

    private void moveUnit(Tile from, Tile to) {
        // 1. Haal de unit op
        Unit unit = from.getUnit();


        if (unit != null && to.getUnit() == null) {
            to.setUnit(unit);
            from.removeUnit();
            unit.setCoordinates(to.getCol(), to.getRow());
        }
    }

    // makes the map and places a unit on the board
    private void renderMap() {
        view.clear();
        Map map = model.getMap();
        Player player = model.getPlayer();

        for (int col = 0; col < map.getWidth(); col++) {
            for (int row = 0; row < map.getHeight(); row++) {
                Tile tile = map.getTile(col, row);
                view.addTile(col, row, getTerrainColor(tile.getTerrainType()));

                if (tile.hasCity()) {
                    City city = tile.getCity();
                    Player owner = city.getOwner();

                    // Gebruik de spelerkleur van de eigenaar van de stad
                    Color cityColor = Color.rgb(owner.getR(), owner.getG(), owner.getB());

                    // Bepaal het level op basis van inwoners
                    int level = city.getAmountInhabitants();

                    // Roep de methode aan zonder Image, maar met het level (int)
                    view.addCityToTile(col, row, cityColor, city.getNameCity(), level);
                }

                if (tile.getUnit() != null) {
                    // Gebruik hier de kleur van de huidige speler voor de unit marker
                    view.addUnitToTile(col, row, Color.rgb(player.getR(), player.getG(), player.getB()), settlerImage);
                }
            }
        }
    }

    // methode to give de hex a color
    private Paint getTerrainColor(TerrainType type) {
        return switch (type) {
            case GRASSLAND -> Color.LIGHTGREEN;
            case DESERT -> Color.MOCCASIN;
            case OCEAN -> Color.SKYBLUE;
            case MOUNTAIN -> Color.SADDLEBROWN;
            case FOREST -> Color.FORESTGREEN;
        };
    }

}