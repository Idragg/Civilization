package civilization;

import civilization.model.Model;
import civilization.view.Presenter;
import civilization.view.View;
import civilization.view.settings.SettingsPresenter;
import civilization.view.settings.ViewSettings;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
//    @Override
//    public void start(Stage stage) throws Exception {
//        Model model = new Model();
//        View view = new View();
//        Presenter presenter = new Presenter(model, view);
//
//        Scene scene = new Scene(view, 1000,750);
//        stage.setTitle("Civilization");
//        stage.setScene(scene);
//        stage.show();
//    }

    public void start(Stage stage2) throws Exception {
        ViewSettings viewSettings = new ViewSettings();
        Model model = new Model();
        SettingsPresenter presenter = new SettingsPresenter(model, viewSettings);
        Scene scene2 = new Scene(viewSettings,1000,750);
        stage2.setScene(scene2);
        stage2.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
