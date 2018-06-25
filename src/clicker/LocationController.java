package clicker;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LocationController {

    private static Stage stage;

    private static FirstLocationController firstLocationController = FirstLocationController.getInstance();
    private static SecondLocationController secondLocationController = SecondLocationController.getInstance();

    @FXML
    Button firstLocationButton;
    @FXML
    Button secondLoacationButton;
    @FXML
    Button thirdLocationButton;

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

    @FXML
    private void initialize() {
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
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/view/simpleButton.fxml"));
                SimpleButton controller = new SimpleButton("131313");
                loader.setController(controller);
                createChildElement(loader, room);
            }
        }
    }

    private void initExtraButtons(List<HBox> rooms) {
        for (HBox room: rooms) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/view/extraButton.fxml"));
            ExtraButton controller = new ExtraButton();
            loader.setController(controller);
            createChildElement(loader, room);
        }
    }

    private void initSimpleLabel(List<HBox> rooms) {
        for (HBox room: rooms) {
            FXMLLoader labelLoader = new FXMLLoader(getClass().getResource("../resources/view/simpleLabel.fxml"));
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

    @FXML
    public void firstLocationButtonOnClick() throws IOException {
        System.out.println("Warsaw button has been clicked");
        rewriteRoomToController(firstLocationController);
        firstLocationController.populateData();
        populateRoomWithControllersData(firstLocationController);
        reloadView();
    }

    private void populateRoomWithControllersData(Controller controller) {
        firstRoomButtons = controller.getRoom().getFirstRoom().getRoomButtons();
        firstRoomLabels = controller.getRoom().getFirstRoom().getRoomLabels();
        firstRoomData = controller.getRoom().getFirstRoom().getRoomData();

        secondRoomButtons = controller.getRoom().getSecondRoom().getRoomButtons();
        secondRoomLabels = controller.getRoom().getSecondRoom().getRoomLabels();
        secondRoomData = controller.getRoom().getSecondRoom().getRoomData();

        thirdRoomButtons = controller.getRoom().getThirdRoom().getRoomButtons();
        thirdRoomLabels = controller.getRoom().getThirdRoom().getRoomLabels();
        thirdRoomData = controller.getRoom().getThirdRoom().getRoomData();
    }

    private void rewriteRoomToController(Controller controller) {
        controller.room.getFirstRoom().setRoomButtons(firstRoomButtons);
        controller.room.getFirstRoom().setRoomLabels(firstRoomLabels);
        controller.room.getSecondRoom().setRoomButtons(secondRoomButtons);
        controller.room.getSecondRoom().setRoomLabels(secondRoomLabels);
        controller.room.getThirdRoom().setRoomButtons(thirdRoomButtons);
        controller.room.getThirdRoom().setRoomLabels(thirdRoomLabels);
    }

    @FXML
    public void secondLocationButtonOnClick() throws IOException {
        System.out.println("Moscow button has been clicked");
        rewriteRoomToController(secondLocationController);
        secondLocationController.populateData();
        populateRoomWithControllersData(secondLocationController);
        reloadView();
    }

    @FXML
    public void thirdLocationButtonOnClick() throws IOException {
        System.out.println("Tokyo button has been clicked");
    }

    public static void setStage(Stage stage) {
        LocationController.stage = stage;
    }

    private void reloadView() throws IOException {
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("../resources/view/locationView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
}
