package clicker.controllers;

import clicker.income.MainIncome;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.util.Duration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TabMainController {

    @FXML
    private TabPane tabPane;

    @FXML
    private Tab tabBanana;
    @FXML
    private Tab tabCherry;

    @FXML
    private BananaController yyy_banana_controller = new BananaController();
    @FXML
    private CherryController yyy_cherry_controller = new CherryController();

    public void initialize() {
        tabPane.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Tab> observable,
                                                                        Tab oldValue, Tab newValue) -> {
            if (newValue == tabCherry) {
                System.out.println("IN CHERRY TAB");
                System.out.println("yyy_cherry_controller=" + yyy_cherry_controller);
                yyy_cherry_controller.handleTab2ButtonBar();
            } else if (newValue == tabBanana) {
                System.out.println("IN BANANA TAB");
                System.out.println("yyy_banana_controller=" + yyy_banana_controller);
                yyy_banana_controller.handleTab1ButtonFoo();
            } else {
                System.out.println("- another Tab -");
            }
        });

        Runnable task = () -> startBaseIncome();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(task);
    }

    private void startBaseIncome() {
        Timeline wanderer = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Modifying base income. Current value " + MainIncome.getBaseIncome());
                long normalIncomeInTime = MainIncome.getBaseIncome() + 100L;
                long bananaIncome = yyy_banana_controller.bananaIncome.getCurrentFruitIncome();
                System.out.println("xxxxxxbanana INCOME: " + bananaIncome);
                long total = normalIncomeInTime + bananaIncome;
                System.out.println("xxxxxxtotal INCOME: " + total);
                MainIncome.setBaseIncome(total);
            }
        }));
        wanderer.setCycleCount(Timeline.INDEFINITE);
        wanderer.play();
    }
}
