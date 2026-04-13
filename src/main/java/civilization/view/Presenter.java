package civilization.view;

import civilization.model.Model;

public class Presenter {
    private Model model;
    private View view;

    public Presenter(View view, Model model) {
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
