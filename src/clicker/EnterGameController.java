package clicker;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.io.IOException;

public class EnterGameController {
    @FXML
    private Button enterButton;

    private Stage stage;

    @FXML
    public void enterGame() throws IOException {
        System.out.println("Game has been entered");
        stage = (Stage) enterButton.getScene().getWindow();
        TabPane root = (TabPane) FXMLLoader.load(getClass().getResource("../resources/view/tabPaneRootView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
}
