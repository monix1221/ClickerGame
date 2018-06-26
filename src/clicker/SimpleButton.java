package clicker;

import clicker.controllers.FruitController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SimpleButton {
    private FruitController fruitController;

    private String text;

    @FXML
    private Button button;

    public SimpleButton(String text, FruitController fruitController) {
        this.text = text;
        this.fruitController = fruitController;
    }

    @FXML
    public void onButtonClicked() {
        System.out.println("button has been clicked " + button.getId());
        System.out.println(button.getParent().getParent());
        button.setDisable(true);
        fruitController.onButtonClicked();
    }
}
