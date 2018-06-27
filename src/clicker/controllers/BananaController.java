package clicker.controllers;

import clicker.CustomButton;
import clicker.RoomData;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BananaController extends FruitController {

    @FXML
    public Label bananaIncomeLabel;

    @FXML
    public void buyRoom() {
        System.out.println("Buy room in banana space");
        super.buyRoom();
    }

    public BananaController() {
        List<String> firstRoomData = new ArrayList<>(
                Arrays.asList("111 $", "222 $", "333 $/s"));
        List<Button> firstRoomButtons = new ArrayList<>();
        List<Label> firstRoomLabels = new ArrayList<>();

        List<String> secondRoomData = new ArrayList<>(
                Arrays.asList("444 $", "555 $", "666 $/s"));
        List<Button> secondRoomButtons = new ArrayList<>();
        List<Label> secondRoomLabels = new ArrayList<>();

        List<String> thirdRoomData = new ArrayList<>(
                Arrays.asList("777 $", "888 $", "999 $/s"));
        List<Button> thirdRoomButtons = new ArrayList<>();
        List<Label> thirdRoomLabels = new ArrayList<>();

        fruitController.firstRoomData = new RoomData(firstRoomData, firstRoomButtons, firstRoomLabels);
        fruitController.secondRoomData = new RoomData(secondRoomData, secondRoomButtons, secondRoomLabels);
        fruitController.thirdRoomData = new RoomData(thirdRoomData, thirdRoomButtons, thirdRoomLabels);
    }

    public void initialize() {
        System.out.println("Initialize banana controller");
        super.initialize();
        Runnable task = () -> updateBananaIncomeLabel();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(task);

        ExecutorService executorService2 = Executors.newCachedThreadPool();
        Runnable task2 = () -> increaseIncomeInTime();
        executorService2.execute(task2);
    }

    @Override
    public void onButtonClicked(CustomButton button) {
        System.out.println("BUTTON FROM BANANAAAAAAAAAA");
        super.onButtonClicked(button);
        if (button.getButton().isDisable()) {
            modifyBananaIncome(button);
        }
    }

    private void modifyBananaIncome(CustomButton button) {
        String parentId = button.getButton().getParent().getParent().getId();
        String firstRoomId = firstRoomHBox.getId();
        String secondRoomId = secondRoomHBox.getId();
        String thirdRoomId = thirdRoomHBox.getId();
        long value = 0L;
        if (Objects.equals(parentId, firstRoomId)) {
            System.out.println("Increasing banana income for button clicked in first room");
            String increasePerTime = firstRoomData.getData().get(2);
            value = Long.valueOf(increasePerTime.substring(0, increasePerTime.length() - 4));
        } else if (Objects.equals(parentId, secondRoomId)) {
            String increasePerTime = secondRoomData.getData().get(2);
            value = Long.valueOf(increasePerTime.substring(0, increasePerTime.length() - 4));
        } else if (Objects.equals(parentId, thirdRoomId)) {
            String increasePerTime = thirdRoomData.getData().get(2);
            value = Long.valueOf(increasePerTime.substring(0, increasePerTime.length() - 4));
        }
        bananaIncome.addOnTimeIncreaseFruitIncome(value);
    }

    public void increaseIncomeInTime() {
        Timeline wanderer = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                bananaIncome.increaseCurrentFruitIncome();
            }
        }));
        wanderer.setCycleCount(Timeline.INDEFINITE);
        wanderer.play();
    }

    public void updateBananaIncomeLabel() {
        Timeline wanderer = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                bananaIncomeLabel.setText(bananaIncome.getCurrentFruitIncome() + CURRENCY);
            }
        }));
        wanderer.setCycleCount(Timeline.INDEFINITE);
        wanderer.play();
    }

    public void handleTab1ButtonFoo() {
        System.out.println("handling banana");
    }

}
