package clicker;

import clicker.controllers.FruitController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ExtraButton implements CustomButton {
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
        System.out.println("button has been clicked " + button.getId() + "it has text: " + button.getText());
        System.out.println(button.getParent().getParent());
        fruitController.onButtonClicked(this);
    }

    public long getPrice() {
        return Long.valueOf(this.button.getText().substring(0, this.button.getText().length() - 2));
    }

    public Button getButton() {
        return this.button;
    }
}
