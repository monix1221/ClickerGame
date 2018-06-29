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
    private static final double REFRESH_INTERVAL = 1;
    private static final long MAIN_INCOME_IN_TIME_INCREASE = 20L;

    @FXML
    private TabPane tabPane;

    @FXML
    private Tab tabBanana;
    @FXML
    private Tab tabCherry;
    @FXML
    private Tab tabPlum;

    @FXML
    private BananaController bananaController = new BananaController();
    @FXML
    private CherryController cherryController = new CherryController();
    @FXML
    private PlumController plumController = new PlumController();

    public void initialize() {
        tabPane.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Tab> observable,
                                                                        Tab oldValue, Tab newValue) -> {
            if (newValue == tabCherry) {
                System.out.println("IN CHERRY TAB");
                System.out.println("cherryController = " + cherryController);
                cherryController.handleCherryTab();
            } else if (newValue == tabBanana) {
                System.out.println("IN BANANA TAB");
                System.out.println("bananaController = " + bananaController);
                bananaController.handleBananaTab();
            } else if (newValue == tabPlum) {
                System.out.println("IN PLUM TAB");
                System.out.println("plumController = " + plumController);
                plumController.handlePlumTab();
            } else {
                System.out.println("- another Tab -");
            }
        });

        Runnable task = () -> startBaseIncome();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(task);
    }

    private void startBaseIncome() {
        Timeline wanderer = new Timeline(new KeyFrame(Duration.seconds(REFRESH_INTERVAL), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Modifying base income. Current value " + MainIncome.getBaseIncome());
                long normalIncomeInTime = MainIncome.getBaseIncome() + MAIN_INCOME_IN_TIME_INCREASE;

                long bananaIncome = bananaController.bananaIncome.getCurrentFruitIncome();
                System.out.println("xxxxxx banana INCOME: " + bananaIncome);

                long cherryIncome = cherryController.cherryIncome.getCurrentFruitIncome();
                System.out.println("xxxxxx cherry INCOME: " + cherryIncome);

                long plumIncome = plumController.plumIncome.getCurrentFruitIncome();
                System.out.println("xxxxxx plum INCOME: " + plumIncome);

                long total = normalIncomeInTime + bananaIncome + cherryIncome + plumIncome;
                System.out.println("xxxxxx total INCOME: " + total);
                MainIncome.setBaseIncome(total);
            }
        }));
        wanderer.setCycleCount(Timeline.INDEFINITE);
        wanderer.play();
    }
}
