package clicker;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ExtraButton {
    private String text;

    @FXML
    private Button button;

    public ExtraButton () {
        
    }

    public ExtraButton(String text) {
        this.text = text;
    }

    @FXML
    public void onButtonClicked() {
        System.out.println("button has been clicked " + button.getId());
        System.out.println(button.getParent().getParent());
    }
}
