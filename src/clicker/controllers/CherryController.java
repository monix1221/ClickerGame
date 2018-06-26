package clicker.controllers;

import clicker.RoomData;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CherryController extends FruitController {

    @FXML
    public void buyRoom() {
        System.out.println("Buy room in cherry space");
        this.canBuyNewRoom = false;
        super.buyRoom();
    }

    public CherryController() {
        List<String> firstRoomData = new ArrayList<>(
                Arrays.asList("101 $", "202 $", "303 $/s"));
        List<Button> firstRoomButtons = new ArrayList<>();
        List<Label> firstRoomLabels = new ArrayList<>();

        List<String> secondRoomData = new ArrayList<>(
                Arrays.asList("404 $", "505 $", "606 $/s"));
        List<Button> secondRoomButtons = new ArrayList<>();
        List<Label> secondRoomLabels = new ArrayList<>();

        List<String> thirdRoomData = new ArrayList<>(
                Arrays.asList("707 $", "808 $", "909 $/s"));
        List<Button> thirdRoomButtons = new ArrayList<>();
        List<Label> thirdRoomLabels = new ArrayList<>();

        fruitController.firstRoomData = new RoomData(firstRoomData, firstRoomButtons, firstRoomLabels);
        fruitController.secondRoomData = new RoomData(secondRoomData, secondRoomButtons, secondRoomLabels);
        fruitController.thirdRoomData = new RoomData(thirdRoomData, thirdRoomButtons, thirdRoomLabels);
    }

    public void handleTab2ButtonBar() {
        System.out.println("handlig cherry");
    }

    @Override
    public void onButtonClicked() {
        System.out.println("BUTTON FROM CHERRRYYYYY");
        super.onButtonClicked();
    }

    public void initialize() {
        System.out.println("Initialize cherry controller");
        super.initialize();
    }
}
