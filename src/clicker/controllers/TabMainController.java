package clicker.controllers;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class TabMainController {

    @FXML
    private TabPane tabPane;

    // Inject tab content
    @FXML
    private Tab tabBanana;
    @FXML
    private Tab tabCherry;

    // Inject tab controller
    @FXML
    private BananaController yyy_banana_controller = new BananaController();
    @FXML
    private CherryController yyy_cherry_controller = new CherryController();

    public void initialize() {
        tabPane.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Tab> observable,
                                                                        Tab oldValue, Tab newValue) -> {
            if (newValue == tabCherry) {
                System.out.println("IN CHERRY TAB");
                System.out.println("yyy_cherry_controller=" + yyy_cherry_controller); //if =null => inject problem
                yyy_cherry_controller.handleTab2ButtonBar();
            } else if (newValue == tabBanana) {
                System.out.println("IN BANANA TAB");
                System.out.println("yyy_banana_controller=" + yyy_banana_controller); //if =null => inject problem
                yyy_banana_controller.handleTab1ButtonFoo();
            } else {
                System.out.println("- another Tab -");
            }
        });
    }
}
