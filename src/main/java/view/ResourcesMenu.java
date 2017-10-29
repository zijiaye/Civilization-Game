package view;

import controller.GameController;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import model.Civilization;

public class ResourcesMenu {
    private Text strategyLevel;
    private Text resource;
    private Text settlements;
    private Text money;
    private Text food;
    private Text happiness;
    private HBox hbox;
    private Civilization user;
    /**
    * creates a resource bar and display the current state of
    * your civilization's resouces
    */
    public ResourcesMenu() {
        user = GameController.getCivilization();
        strategyLevel = new Text("Strat Level: "
            + user.getStrategy().getStrategyLevel());
        resource = new Text("Resources: " + user.getResources());
        settlements = new Text("Settlements: " + user.getNumSettlements());
        money = new Text("Gold: " + user.getTreasury().getCoins());
        food = new Text("Food: " + user.getFood());
        happiness = new Text("Happiness: " + user.getHappiness());
        hbox = new HBox(15);
        hbox.getChildren().addAll(strategyLevel, resource,
            settlements, money, food, happiness);
    }
    /**
    * should update all the resouce values to the current
    * state of your resource values
    */
    public void update() {
        user = GameController.getCivilization();
        strategyLevel = new Text("Strat Level: "
            + user.getStrategy().getStrategyLevel());
        resource = new Text("Resources: " + user.getResources());
        settlements = new Text("Settlements: " + user.getNumSettlements());
        money = new Text("Gold: " + user.getTreasury().getCoins());
        food = new Text("Food: " + user.getFood());
        happiness = new Text("Happiness: " + user.getHappiness());
        hbox = new HBox(15);
        hbox.getChildren().addAll(strategyLevel, resource,
            settlements, money, food, happiness);
        GameScreen.getInstance().setTop(hbox);
    }
    /**
    * updates the resource bar and returns the resource bar
    * @return a hbox representation of the resource bar
    */
    public HBox getRootNode() {
        this.update();
        return hbox;
    }
}