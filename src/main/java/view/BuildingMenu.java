package view;

import controller.GameController;
import model.Building;
import model.Settlement;
import model.MapObject;
import model.TerrainTile;
import model.Civilization;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;


/**
 * This class should represents the bulding menu
 */
public class BuildingMenu extends AbstractMenu {
    /**
    * there should be an invest and demolish button for this menu
    * as well as functions associated with the buttons
    */
    public BuildingMenu() {
        Button btn1 = new Button("invest");
        btn1.setOnAction(e -> {
                TerrainTileFX terrainTile = GameController.getLastClicked();
                MapObject occupant = terrainTile.getTile().getOccupant();
                Civilization user = GameController.getCivilization();
                if (user.getTreasury().getCoins() >= 25) {
                    ((Building) terrainTile.getTile().getOccupant()).invest();
                    user.getTreasury().spend(25);
                } else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Do not have enough gold!");
                    alert.setHeaderText(null);
                    alert.setContentText("Cannot afford!");
                    alert.showAndWait();
                }
                GameScreen.getInstance().getResources().update();
            });
        Button btn2 = new Button("Demolish");
        btn2.setOnAction(e -> {
                TerrainTileFX terrainTile = GameController.getLastClicked();
                MapObject occupant = terrainTile.getTile().getOccupant();
                Civilization user = GameController.getCivilization();
                if (user.getNumSettlements() <= 1) {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Warning");
                    alert.setHeaderText(null);
                    String text = "Only 1 Settlement, cannot demolish!";
                    alert.setContentText(text);
                    alert.showAndWait();
                } else {
                    if (occupant instanceof Settlement) {
                        TerrainTile terrain = terrainTile.getTile();
                        ((Building) terrain.getOccupant()).demolish();
                        terrainTile.getTile().setOccupant(null);
                    } else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Warning");
                        alert.setHeaderText(null);
                        String text = "Not a Settlement, can't demolish!!";
                        alert.setContentText(text);
                        alert.showAndWait();
                    }
                }
                GameScreen.getInstance().getResources().update();
            });
        this.addMenuItem(btn1);
        this.addMenuItem(btn2);
    }
}
