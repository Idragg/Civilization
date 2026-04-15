package civilization.view.settings;

import civilization.model.player.Civilization;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.List;

public class ViewSettings extends GridPane {
    private ComboBox<Civilization> cmbCivilization;
    private Label lblTitel;
    private Label lblCivilization;
    private Label lblColor;
    private Label lblTipKleur;
    private Rectangle rectCivilization;
    private Button btnStart;


    public ViewSettings() {
        initializeNodes();
        layoutNodes();
    }

    private void initializeNodes() {
        lblTitel = new Label("Selection Menu Civ");
        cmbCivilization = new ComboBox<>();
        lblCivilization = new Label("Civilization");
        lblColor = new Label("Kleur");
        rectCivilization = new Rectangle();
        lblTipKleur = new Label("Click on the rectangle to select color");
        btnStart = new Button("Start Game");

    }

    private void layoutNodes() {
        this.add(lblTitel, 0, 0, 2, 1);
        GridPane.setColumnSpan(lblTitel, 2);
        lblTitel.setMaxWidth(Double.MAX_VALUE);
        lblTitel.setAlignment(Pos.TOP_CENTER);
        cmbCivilization.getItems().addAll();
        this.add(lblCivilization, 0, 1);
        this.add(cmbCivilization, 0, 2);
        this.setPadding(new Insets(10));

        this.add(lblColor, 0, 3);
        this.add(rectCivilization, 0, 4);
        rectCivilization.setStroke(Color.BLACK);
        rectCivilization.setFill(Color.TRANSPARENT);
        rectCivilization.setHeight(200);
        rectCivilization.setWidth(200);

        this.add(lblTipKleur, 0, 5);
        this.add(btnStart, 0, 6);

        this.setVgap(10);
        this.setHgap(10);
    }

    public void setCivilizations(List<Civilization> civilizations) {
        cmbCivilization.getItems().clear();
        cmbCivilization.getItems().addAll(civilizations);
        cmbCivilization.getSelectionModel().selectFirst();
    }

    ComboBox<Civilization> getCmbCivilization() {
        return cmbCivilization;
    }

    Label getLblCivilization() {
        return lblCivilization;
    }

    Label getLblColor() {
        return lblColor;
    }

    Rectangle getRectCivilization() {
        return rectCivilization;
    }

    Button getBtnStart() {
        return btnStart;
    }
}
