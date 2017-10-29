package view;

import controller.GameController;
import javafx.scene.control.Button;


/**
 * Created by William on 11/11/2016.
 */

public class MilitaryMenu extends AbstractMenu {
    /**
    * Implement the buttons and actions associated with
    * the buttons for the military menu
    */
    public MilitaryMenu() {
        Button btn1 = new Button("Attack");
        btn1.setOnAction(e -> {
                GameController.attacking();
                GameScreen.getInstance().getResources().update();
            });
        Button btn2 = new Button("Move");
        btn2.setOnAction(e -> {
                GameController.moving();
                GameScreen.getInstance().getResources().update();
            });
        this.addMenuItem(btn1);
        this.addMenuItem(btn2);
    }
}
