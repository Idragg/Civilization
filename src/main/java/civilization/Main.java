package civilization;

import civilization.model.Model;
import civilization.model.units.Unit;
import civilization.model.units.Warrior;
import civilization.view.Presenter;
import civilization.view.View;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Model model = new Model();
        View view = new View();
        Presenter presenter = new Presenter(model, view);

        Scene scene = new Scene(view, 1000,750);
        stage.setFullScreen(true);
        stage.setTitle("Civilization");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
