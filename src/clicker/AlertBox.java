package clicker;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
    private static final String OK_BUTTON_TEXT = "OK";

    public static void display(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(400);
        window.setMinHeight(200);

        Label label = new Label();
        label.setText(message);

        Button closeButton = new Button(OK_BUTTON_TEXT);
        closeButton.setOnAction(e -> window.close());
        VBox container = new VBox();
        container.getChildren().addAll(label, closeButton);
        container.setSpacing(25);
        container.setAlignment(Pos.CENTER);

        Scene scene = new Scene(container);
        window.setScene(scene);
        window.showAndWait();
    }
}
