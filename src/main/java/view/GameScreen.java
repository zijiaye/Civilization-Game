package view;

import controller.GameController;
import javafx.scene.layout.BorderPane;

/**
 * This class represents the GameScreen class
 */
public class GameScreen extends BorderPane {
    private static ResourcesMenu resourcesmenu;
    private static GameScreen gamescreen;
    /**
     * Creates a new view into the game. this layout should include
     * the rescource bar, grid map, and action menus
     *
     */
    public GameScreen() {
        gamescreen = this;
        resourcesmenu = getResources();
        this.setCenter(GridFX.getInstance());
        this.setTop(resourcesmenu.getRootNode());
        this.setLeft(new BuildingMenu().getRootNode());
    }

    /**
     * This method should update the gridfx and the resouce bar
     */
    public void update() {
        resourcesmenu.update();
        GridFX.update();
    }
    /**
    * this method should return the resource menu
    * @return reosuce menu
    */
    public static ResourcesMenu getResources() {
        resourcesmenu = new ResourcesMenu();
        return resourcesmenu;
    }
    public static GameScreen getInstance() {
        return gamescreen;
    }
    /**
     * This method switches menus based on passed in game state.
     * Game.java calls this to selectively control which menus are displayed
     * @param state
     */
    public static void switchMenu(GameController.GameState state) {
        if (state == GameController.GameState.BUILDING) {
            GameScreen.gamescreen.setLeft(new BuildingMenu().getRootNode());
        } else if (state == GameController.GameState.MILITARY) {
            GameScreen.gamescreen.setLeft(new MilitaryMenu().getRootNode());
        } else if (state == GameController.GameState.NEUTRAL) {
            GameScreen.gamescreen.setLeft(new StatusMenu().getRootNode());
        } else if (state == GameController.GameState.RECRUITING) {
            GameScreen.gamescreen.setLeft(new RecruitMenu().getRootNode());
        } else {
            GameScreen.gamescreen.setLeft(new WorkerMenu().getRootNode());
        }
    }
}
