package civilization;

import civilization.model.Model;
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

        Scene scene = new Scene(view, 1200, 800);
        stage.setTitle("Civilization");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
