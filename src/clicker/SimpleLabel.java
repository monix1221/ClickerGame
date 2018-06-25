package clicker;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class SimpleLabel {

    @FXML
    public Label labelABC;

    private String labelText;

    public SimpleLabel (String text) {
        this.labelText = text;
        System.out.println(text);
    }

    public String getLabelText() {
        return this.labelText;
    }
}
