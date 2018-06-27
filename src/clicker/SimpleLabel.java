package clicker;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SimpleLabel {

    @FXML
    public Label simpleLabel;

    private String labelText;

    public SimpleLabel (String text) {
        this.labelText = text;
    }

    public String getLabelText() {
        return this.labelText;
    }
}
