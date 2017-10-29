package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
/**
 * Created by Tian-Yo Yang on 11/11/2016.
 * This class represents the Start Screen for the Civ applicatios. This is the
 * layout that should be displayed upon running the Civ application.
 *
 * This class should have and display
 * 1. a background
 * 2. a list of Civilizations
 * 3. a Start button
 */
public class StartScreen extends StackPane {

    /**
    * constuctor of the start screen. Should set the background
    * image and display a list of civilizations and a start button
    */
    private String civ, enteredTown;
    private Button btn;
    private ListView<CivEnum> listview;

    public StartScreen() {
        Image image = new Image("file:src/main/java/view/civ_background.png");
        ImageView background = new ImageView(image);
        background.setFitWidth(1000);
        background.setFitHeight(800);
        Label label = new Label("Select a civilization to begin");
        label.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        label.setTextFill(Color.web("#a20d00"));
        btn = new Button("Enter");
        ObservableList<CivEnum> civSelect = FXCollections.observableArrayList(
            CivEnum.ANCIENT_EGYPT, CivEnum.QIN_DYNASTY, CivEnum.ROMAN_EMPIRE);
        listview = new ListView(civSelect);
        listview.setPrefWidth(20);
        listview.setPrefHeight(70);
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(350, 400, 50, 400));
        vbox.getChildren().addAll(label, listview, btn);
        this.getChildren().addAll(background, vbox);
    }

    /**
    * gets the start button
    * @return the start button
    */
    public Button getStartButton() {
        return btn;
    }
    /**
    * return a ListView of CivEnums representing the list of
    * available civilizations to choose from
    * @return listview of CivEnum
    */
    public ListView<CivEnum> getCivList() {
        return listview;
    }
}