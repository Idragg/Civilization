package civilization.view;

import civilization.model.Model;
import civilization.model.map.Tile;
import civilization.view.tile.TileView;
import javafx.scene.Node;

public class Presenter {
    private Model model;
    private View view;

    private Tile selectedTile = null;

    public Presenter(Model model, View view) {
        this.model = model;
        this.view = view;

        view.generateGrid(model.getMap());

        addEventHandlers();
    }

    private void addEventHandlers() {
        for (Node node : view.getChildren()) {
            if (node instanceof TileView tileView) {
                tileView.setOnMouseClicked(event -> {
                    handleTileClick(tileView.getTile());
                });
            }
        }
    }
    private void handleTileClick(Tile clickedTile) {
        if (selectedTile == null) {
            // Logica voor selecteren
            if (clickedTile.getOccupied()) { // Check of er een unit op de tegel staat
                selectedTile = clickedTile;
                System.out.println("Geselecteerd: " + clickedTile.getTerrainType());
            }
        } else {
            selectedTile = null;
            view.generateGrid(model.getMap()); // Ververs het scherm
            addEventHandlers(); // Belangrijk: na generateGrid moet je de handlers opnieuw koppelen!
        }
    }
}