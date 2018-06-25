package clicker;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    @FXML
    private Button enterButton;

    private Stage stage;

    @FXML
    public void enterGame() throws IOException {
        System.out.println("Game has been entered");
        stage = (Stage) enterButton.getScene().getWindow();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("../resources/view/locationView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        LocationController.setStage(stage);
        System.out.println("FINISHED");
        LocationController locationController = new LocationController();
        locationController.firstLocationButtonOnClick();
    }
}
