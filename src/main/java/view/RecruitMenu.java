package view;

import controller.GameController;
import javafx.scene.control.Button;
import model.Unit;
import model.MapObject;
import model.Civilization;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import java.util.Optional;
import javafx.scene.control.Dialog;

/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class RecruitMenu extends AbstractMenu {

    public RecruitMenu() {
        Button btn = new Button("Select");
        ListView<String> list = new ListView<String>();
        ObservableList<String> units = FXCollections.observableArrayList(
            "melee unit", "range unit", "hybrid unit", "siege unit", "settlers",
            "farmers", "coal miners", "anglers", "master builders");
        list.setItems(units);
        btn.setOnAction(e -> {
                TerrainTileFX terrainTile = GameController.getLastClicked();
                MapObject occupant = terrainTile.getTile().getOccupant();
                String compare = list.getSelectionModel().getSelectedItem();
                Unit select;
                if (compare.equals("melee unit")) {
                    select = GameController.getCivilization().getMeleeUnit();
                    if (select.isAffordable()) {
                        terrainTile.getTile().setOccupant(select);
                        select.applyInitialCosts();
                    } else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText(null);
                        alert.setContentText("Cannot afford!");
                        alert.showAndWait();
                    }
                } else if (compare.equals("range unit")) {
                    select = GameController.getCivilization().getRangedUnit();
                    if (select.isAffordable()) {
                        terrainTile.getTile().setOccupant(select);
                        select.applyInitialCosts();
                    } else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText(null);
                        alert.setContentText("Cannot afford!");
                        alert.showAndWait();
                    }
                } else if (compare.equals("hybrid unit")) {
                    select = GameController.getCivilization().getHybridUnit();
                    if (select.isAffordable()) {
                        terrainTile.getTile().setOccupant(select);
                        select.applyInitialCosts();
                    } else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText(null);
                        alert.setContentText("Cannot afford!");
                        alert.showAndWait();
                    }
                } else if (compare.equals("siege unit")) {
                    select = GameController.getCivilization().getSiegeUnit();
                    if (select.isAffordable()) {
                        terrainTile.getTile().setOccupant(select);
                        select.applyInitialCosts();
                    } else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText(null);
                        alert.setContentText("Cannot afford!");
                        alert.showAndWait();
                    }
                } else if (compare.equals("settlers")) {
                    String t = "temp";
                    select = GameController.getCivilization().getSettlerUnit(t);
                    if (select.isAffordable()) {
                        Dialog dialog = new TextInputDialog();
                        dialog.setTitle("A new Settlement");
                        dialog.setHeaderText("You have built a Settlement");
                        String text = "Enter the name of you first town: ";
                        dialog.setContentText(text);
                        Optional<String> result = dialog.showAndWait();
                        String name = " ";
                        if (result.isPresent()) {
                            name += result.get();
                        }
                        Civilization user = GameController.getCivilization();
                        select = user.getSettlerUnit(name);
                        terrainTile.getTile().setOccupant(select);
                        select.applyInitialCosts();
                    } else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText(null);
                        alert.setContentText("Cannot afford!");
                        alert.showAndWait();
                    }
                } else if (compare.equals("farmers")) {
                    select = GameController.getCivilization().getFarmerUnit();
                    if (select.isAffordable()) {
                        terrainTile.getTile().setOccupant(select);
                        select.applyInitialCosts();
                    } else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText(null);
                        alert.setContentText("Cannot afford!");
                        alert.showAndWait();
                    }
                } else if (compare.equals("coal miners")) {
                    Civilization user = GameController.getCivilization();
                    select = user.getCoalMinerUnit();
                    if (select.isAffordable()) {
                        terrainTile.getTile().setOccupant(select);
                        select.applyInitialCosts();
                    } else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText(null);
                        alert.setContentText("Cannot afford!");
                        alert.showAndWait();
                    }
                } else if (compare.equals("anglers")) {
                    select = GameController.getCivilization().getAnglerUnit();
                    if (select.isAffordable()) {
                        terrainTile.getTile().setOccupant(select);
                        select.applyInitialCosts();
                    } else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText(null);
                        alert.setContentText("Cannot afford!");
                        alert.showAndWait();
                    }
                } else if (compare.equals("master builders")) {
                    Civilization user = GameController.getCivilization();
                    select = user.getMasterBuilderUnit();
                    select.applyInitialCosts();
                    if (select.isAffordable()) {
                        terrainTile.getTile().setOccupant(select);
                    } else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText(null);
                        alert.setContentText("Cannot afford!");
                        alert.showAndWait();
                    }
                }

                GameScreen.getInstance().update();
                GameScreen.getInstance().getResources().update();
            });
        this.addMenuItem(list);
        this.addMenuItem(btn);
    }
}
