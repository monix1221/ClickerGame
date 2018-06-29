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

public class PlumController extends FruitController {
    @FXML
    public Label plumIncomeLabel;

    @FXML
    public void buyRoom() {
        System.out.println("Buy room in plum space");
        super.buyRoom();
    }

    public PlumController() {
        List<String> firstRoomData = new ArrayList<>(
                Arrays.asList("299 $", "399 $", "499 $/s"));
        List<Button> firstRoomButtons = new ArrayList<>();
        List<Label> firstRoomLabels = new ArrayList<>();

        List<String> secondRoomData = new ArrayList<>(
                Arrays.asList("599 $", "699 $", "799 $/s"));
        List<Button> secondRoomButtons = new ArrayList<>();
        List<Label> secondRoomLabels = new ArrayList<>();

        List<String> thirdRoomData = new ArrayList<>(
                Arrays.asList("899 $", "999 $", "10000 $/s"));
        List<Button> thirdRoomButtons = new ArrayList<>();
        List<Label> thirdRoomLabels = new ArrayList<>();

        fruitController.firstRoomData = new RoomData(firstRoomData, firstRoomButtons, firstRoomLabels);
        fruitController.secondRoomData = new RoomData(secondRoomData, secondRoomButtons, secondRoomLabels);
        fruitController.thirdRoomData = new RoomData(thirdRoomData, thirdRoomButtons, thirdRoomLabels);
    }

    public void initialize() {
        System.out.println("Initialize plum controller");
        super.initialize();
        Runnable task = () -> updatePlumIncomeLabel();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(task);

        ExecutorService executorService2 = Executors.newCachedThreadPool();
        Runnable task2 = () -> increaseIncomeInTime();
        executorService2.execute(task2);
    }

    @Override
    public void onButtonClicked(CustomButton button) {
        System.out.println("Plum button has been clicked");
        super.onButtonClicked(button);
        if (button.getButton().isDisable()) {
            modifyPlumIncome(button);
        }
    }

    private void modifyPlumIncome(CustomButton button) {
        String parentId = button.getButton().getParent().getParent().getId();
        String firstRoomId = firstRoomHBox.getId();
        String secondRoomId = secondRoomHBox.getId();
        String thirdRoomId = thirdRoomHBox.getId();
        long value = 0L;
        if (Objects.equals(parentId, firstRoomId)) {
            System.out.println("Increasing plum income for button clicked in first room");
            String increasePerTime = firstRoomData.getData().get(2);
            value = Long.valueOf(increasePerTime.substring(0, increasePerTime.length() - 4));
        } else if (Objects.equals(parentId, secondRoomId)) {
            String increasePerTime = secondRoomData.getData().get(2);
            value = Long.valueOf(increasePerTime.substring(0, increasePerTime.length() - 4));
        } else if (Objects.equals(parentId, thirdRoomId)) {
            String increasePerTime = thirdRoomData.getData().get(2);
            value = Long.valueOf(increasePerTime.substring(0, increasePerTime.length() - 4));
        }
        plumIncome.addOnTimeIncreaseFruitIncome(value);
    }

    public void increaseIncomeInTime() {
        Timeline wanderer = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                plumIncome.increaseCurrentFruitIncome();
            }
        }));
        wanderer.setCycleCount(Timeline.INDEFINITE);
        wanderer.play();
    }

    public void updatePlumIncomeLabel() {
        Timeline wanderer = new Timeline(new KeyFrame(Duration.seconds(0.5), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                plumIncomeLabel.setText(plumIncome.getCurrentFruitIncome() + CURRENCY);
            }
        }));
        wanderer.setCycleCount(Timeline.INDEFINITE);
        wanderer.play();
    }

    public void handlePlumTab() {
        System.out.println("Switched to plum");
    }
}
