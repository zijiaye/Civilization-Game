package runner;

import controller.GameController;
import model.Civilization;
import view.StartScreen;
import view.CivEnum;
import view.GameScreen;
import model.Map;
import model.QinDynasty;
import model.RomanEmpire;
import model.Egypt;
import model.Bandit;
import view.GridFX;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.util.Optional;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ListView;
/**
 * Created by Tian-Yo Yang on 11/11/2016.
 */
public class CivilizationGame extends Application {

    /**
     * this method is called upon running/launching the application
     * this method should display a scene on the stage
     */
    private String civ;
    private String enterTown;
    private Civilization user;
    public void start(Stage primaryStage) {
        //TODO
        primaryStage.setTitle("startscreen");
        StartScreen startscreen = new StartScreen();
        primaryStage.setTitle("Civilization Game");
        Scene scene = new Scene(startscreen);
        primaryStage.setScene(scene);
        startscreen.getStartButton().setOnAction(e -> {
                ListView<CivEnum> listview = startscreen.getCivList();
                civ = listview.getSelectionModel().getSelectedItem().toString();
                if (civ.equals("Ancient Egypt")) {
                    user = new Egypt();
                } else if (civ.equals("Qin Dynasty")) {
                    user = new QinDynasty();
                } else {
                    user = new RomanEmpire();
                }
                GameController.setCivilization(user);
                Dialog dialog = new TextInputDialog();
                dialog.setTitle("A new Settlement");
                dialog.setHeaderText("You have built a Settlement");
                dialog.setContentText("Enter the name of you first town: ");
                Optional<String> result = dialog.showAndWait();
                enterTown = " ";
                if (result.isPresent()) {
                    enterTown += result.get();
                }
                Map map = GridFX.getMap();
                Bandit bandit = new Bandit();
                GameController.setBandits(bandit);
                map.addEnemies(bandit, 5);
                map.putSettlement(enterTown, user, 1, 1);
                primaryStage.setScene(startGame());
            });
        primaryStage.show();
    }
    /**
     * This is the main method that launches the javafx application
     */
    public static void main(String[] args) {
        launch(args);
    }
    /**
    * This method is responsible for setting the scene to the corresponding
    * layout.
    * and returning the scene.
    * @return Scene
    */

    public Scene startGame() {
        GameScreen gamescreen = new GameScreen();
        Scene scene = new Scene(gamescreen);
        gamescreen.update();
        return scene;

    }




}
