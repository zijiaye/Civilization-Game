package view;

import controller.GameController;
import javafx.scene.control.Button;
import model.Convertable;
import model.MapObject;
import model.TerrainTile;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class WorkerMenu extends AbstractMenu {
    /**
    * There should be a convert and move button
    * as well as the functions associated with those
    * buttons
    */
    public WorkerMenu() {
         //TODO
        Button btn1 = new Button("Move");
        btn1.setOnAction(e -> {
                GameController.moving();
                GameScreen.getInstance().getResources().update();
            });
        Button btn2 = new Button("Convert");
        btn2.setOnAction(e -> {
                TerrainTileFX terrainTile = GameController.getLastClicked();
                TerrainTile terrain = terrainTile.getTile();
                MapObject occupant = terrain.getOccupant();
                if (((Convertable) occupant).canConvert(terrain.getType())) {
                    terrain.setOccupant(((Convertable) occupant).convert());
                } else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("Cannot Convert!");
                    alert.showAndWait();
                }
            });
        this.addMenuItem(btn1);
        this.addMenuItem(btn2);
    }
}
