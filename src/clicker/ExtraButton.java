package clicker;

import clicker.controllers.FruitController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ExtraButton {
    private String text;
    private FruitController fruitController;

    @FXML
    private Button button;

    public ExtraButton(String text, FruitController fruitController) {
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
