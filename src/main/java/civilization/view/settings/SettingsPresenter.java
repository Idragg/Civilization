package civilization.view.settings;

import civilization.model.Model;
import civilization.model.player.Civilization;
import civilization.view.Presenter;
import civilization.view.View;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.List;
import java.util.Random;

public class SettingsPresenter {
    private Model model;
    private ViewSettings view;

    public SettingsPresenter(Model model, ViewSettings view) {
        this.model = model;
        this.view = view;
        model.createPlayer("Bob");

        List<Civilization> data = model.getAvailableCivilizations();
        view.setCivilizations(data);
        updateView();
        addEventHandlers();
    }

    private void updateView() {
    }

    private void addEventHandlers() {
        view.getRectCivilization().setOnMouseClicked(event -> {
            Random rand = new Random();
            int r = rand.nextInt(256);
            int g = rand.nextInt(256);
            int b = rand.nextInt(256);
            view.getRectCivilization().setFill(Color.rgb(r, g, b));
            model.getPlayer().setR(r);
            model.getPlayer().setG(g);
            model.getPlayer().setB(b);
        });

        view.getBtnStart().setOnAction(event -> {
            Stage stage = new Stage();
            View gameView = new View();
            Presenter presenter = new Presenter(model, gameView);
            Scene scene = new Scene(gameView);
            stage.setScene(scene);
            stage.setTitle("InGame - Civilization");
            stage.show();
            ((Stage) view.getScene().getWindow()).close();
        });
    }


}
