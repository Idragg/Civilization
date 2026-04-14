package civilization.view.tile;

import civilization.model.Model;
import civilization.view.View;

public class TilePresenter {
    private TileView view;
    private Model model;

    public TilePresenter(TileView view, Model model) {
        this.view = view;
        this.model = model;
        updateView();
        addEventHandlers();

    }

    private void updateView() {

    }

    private void addEventHandlers() {

    }

    private void addWindowEventHandlers() {

    }
}
