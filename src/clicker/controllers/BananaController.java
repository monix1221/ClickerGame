package clicker.controllers;

import clicker.RoomData;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BananaController extends FruitController {

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

    @Override
    public void onButtonClicked() {
        System.out.println("BUTTON FROM BANANAAAAAAAAAA");
        super.onButtonClicked();
    }

    @FXML
    public void buyRoom() {
        System.out.println("Buy room in banana space");
        super.buyRoom();

    }

    public void initialize() {
        System.out.println("Initialize banana controller");
        super.initialize();
    }

    public void handleTab1ButtonFoo() {
        System.out.println("handling banana");
    }
}
