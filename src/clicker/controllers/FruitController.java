package clicker.controllers;

import clicker.ExtraButton;
import clicker.SimpleButton;
import clicker.SimpleLabel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FruitController {
    @FXML
    private HBox firstRoom;
    @FXML
    private HBox secondRoom;
    @FXML
    private HBox thirdRoom;

    public static String[] firstRoomData = {"000 $", "000 $", "000 $/s"};
    public static List<Button> firstRoomButtons = new ArrayList<>();
    public static List<Label> firstRoomLabels = new ArrayList<>();

    public static String[] secondRoomData = {"000 $", "000 $", "000 $/s"};
    public static List<Button> secondRoomButtons = new ArrayList<>();
    public static List<Label> secondRoomLabels = new ArrayList<>();

    public static String[] thirdRoomData = {"000 $", "000 $", "000 $/s"};
    public static List<Button> thirdRoomButtons = new ArrayList<>();
    public static List<Label> thirdRoomLabels = new ArrayList<>();


    protected void initialize() {
        System.out.println("Initialize banana controller");
        List<HBox> rooms = new ArrayList<>();
        rooms.add(firstRoom);
        rooms.add(secondRoom);
        rooms.add(thirdRoom);
        initSimpleButtons(rooms);
        initExtraButtons(rooms);
        initSimpleLabel(rooms);

        prepareData(firstRoom, firstRoomButtons, firstRoomLabels);
        prepareData(secondRoom, secondRoomButtons, secondRoomLabels);
        prepareData(thirdRoom, thirdRoomButtons, thirdRoomLabels);

        setData(firstRoomButtons, firstRoomLabels, firstRoomData);
        setData(secondRoomButtons, secondRoomLabels, secondRoomData);
        setData(thirdRoomButtons, thirdRoomLabels, thirdRoomData);

        showData(firstRoomButtons, firstRoomLabels);
        showData(secondRoomButtons, secondRoomLabels);
        showData(thirdRoomButtons, thirdRoomLabels);
    }

    private void setData(List<Button> buttons, List<Label> labels, String[] data) {
        for (int i = 0; i < buttons.size() - 1; i++) {
            buttons.get(i).setDisable(false);
            buttons.get(i).setText(data[0]);
        }
        buttons.get(buttons.size() - 1).setText(data[1]);
        labels.get(0).setText(data[2]);
    }

    private void showData(List<Button> roomButtons, List<Label> roomLabels) {
        for (Button b: roomButtons) {
            System.out.println("button id: " + b.getId());
        }
        for (Label lab: roomLabels) {
            System.out.println("label id: " + lab.getId());
        }
    }

    private void prepareData(HBox room, List<Button> roomButtons, List<Label> roomLabels) {
        int id = 0;
        ObservableList<Node> children = room.getChildren();
        for (Node node: children) {
            Pane pane = (Pane) node;
            ObservableList<Node> childNodes = pane.getChildren();
            for (Node n: childNodes) {
                if (n instanceof  Button) {
                    Button b = (Button) n;
                    b.setId(String.valueOf(id));
                    roomButtons.add(b);
                }
                if (n instanceof Label) {
                    Label label = (Label) n;
                    label.setId(String.valueOf(id));
                    roomLabels.add(label);
                }
                id++;
            }
        }
    }

    private void initSimpleButtons(List<HBox> rooms) {
        for (HBox room: rooms) {
            for (int i = 0; i < 5; i++) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../../resources/view/simpleButton.fxml"));
                SimpleButton controller = new SimpleButton("131313");
                loader.setController(controller);
                createChildElement(loader, room);
            }
        }
    }

    private void initExtraButtons(List<HBox> rooms) {
        for (HBox room: rooms) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../resources/view/extraButton.fxml"));
            ExtraButton controller = new ExtraButton();
            loader.setController(controller);
            createChildElement(loader, room);
        }
    }

    private void initSimpleLabel(List<HBox> rooms) {
        for (HBox room: rooms) {
            FXMLLoader labelLoader = new FXMLLoader(getClass().getResource("../../resources/view/simpleLabel.fxml"));
            SimpleLabel labelController = new SimpleLabel("abs");
            labelLoader.setController(labelController);
            createChildElement(labelLoader, room);
        }
    }

    private void createChildElement(FXMLLoader loader, HBox room) {
        Pane pane = null;
        try {
            pane = loader.load();
            System.out.println("loaded item for room");
            room.getChildren().add(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*
    protected Room room;

    protected void populateData() {
        setData(room.getFirstRoom().getRoomButtons(), room.getFirstRoom().getRoomLabels(), room.getFirstRoom().getRoomData());
        setData(room.getSecondRoom().getRoomButtons(), room.getSecondRoom().getRoomLabels(), room.getSecondRoom().getRoomData());
        setData(room.getThirdRoom().getRoomButtons(), room.getThirdRoom().getRoomLabels(), room.getThirdRoom().getRoomData());
    }

    private void setData(List<Button> buttons, List<Label> labels, String[] data) {
        for (int i = 0; i < buttons.size() - 1; i++) {
            buttons.get(i).setDisable(false);
            buttons.get(i).setText(data[0]);
        }
        buttons.get(buttons.size()-1).setText(data[1]);
        labels.get(0).setText(data[2]);
    }
     */

}
