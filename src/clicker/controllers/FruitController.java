package clicker.controllers;

import clicker.*;
import clicker.income.BananaIncome;
import clicker.income.CherryIncome;
import clicker.income.FruitIncome;
import clicker.income.MainIncome;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FruitController implements GameAction {

    public String alertMessage = "All rooms are bought";
    public static String ALERT_TITLE = "Uppppppps";
    public static String CURRENCY = " $";

    public FruitController fruitController;

    private Boolean isSecondRoomBought = false;
    private Boolean isThirdRoomBought = false;

    protected static FruitIncome bananaIncome = new BananaIncome();
    protected static FruitIncome cherryIncome = new CherryIncome();

    @FXML
    protected HBox firstRoomHBox;
    @FXML
    protected HBox secondRoomHBox;
    @FXML
    protected HBox thirdRoomHBox;

    public  RoomData firstRoomData;
    public  RoomData secondRoomData;
    public  RoomData thirdRoomData;

    @FXML
    public Button buyRoomButton;

    @FXML
    public Label totalIncomeLabel;

    @FXML
    public void buyRoom() {
        System.out.println("Buy room in some space");

        // if money == ok
        if(!isSecondRoomBought) {
            System.out.println("buying second room");
            isSecondRoomBought = true;
            introduceNewRoom();
        } else if (!isThirdRoomBought) {
            System.out.println("buying third room");
            isThirdRoomBought = true;
            introduceNewRoom();
            buyRoomButton.setText("CANT BUY MORE");
            buyRoomButton.setOnAction(e -> AlertBox.display(ALERT_TITLE, alertMessage));
        } else {
            System.out.println("Cant buy more rooms");
        }
    }

    protected void introduceNewRoom() {
        if (isThirdRoomBought) {
            for (Button b: thirdRoomData.getRoomButtons()) {
                b.setDisable(false);
            }
        } else {
            if (isSecondRoomBought) {
                for (Button b : secondRoomData.getRoomButtons()) {
                    b.setDisable(false);
                }
            }
        }
    }

    public FruitController () {
        fruitController = this;

        List<String> firstRoomData = new ArrayList<>(
                Arrays.asList("000 $", "000 $", "000 $/s"));
        List<Button> firstRoomButtons = new ArrayList<>();
        List<Label> firstRoomLabels = new ArrayList<>();

        List<String> secondRoomData = new ArrayList<>(
                Arrays.asList("000 $", "000 $", "000 $/s"));
        List<Button> secondRoomButtons = new ArrayList<>();
        List<Label> secondRoomLabels = new ArrayList<>();

        List<String> thirdRoomData = new ArrayList<>(
                Arrays.asList("000 $", "000 $", "000 $/s"));
        List<Button> thirdRoomButtons = new ArrayList<>();
        List<Label> thirdRoomLabels = new ArrayList<>();

        fruitController.firstRoomData = new RoomData(firstRoomData, firstRoomButtons, firstRoomLabels);
        fruitController.secondRoomData = new RoomData(secondRoomData, secondRoomButtons, secondRoomLabels);
        fruitController.thirdRoomData = new RoomData(thirdRoomData, thirdRoomButtons, thirdRoomLabels);
    }


    protected void initialize() {
        System.out.println("Initialize fruit controller");
        List<HBox> rooms = new ArrayList<>();
        rooms.add(firstRoomHBox);
        rooms.add(secondRoomHBox);
        rooms.add(thirdRoomHBox);
        initSimpleButtons(rooms);
        initExtraButtons(rooms);
        initSimpleLabel(rooms);

        prepareData(firstRoomHBox, firstRoomData);
        prepareData(secondRoomHBox, secondRoomData);
        prepareData(thirdRoomHBox, thirdRoomData);

        setData(firstRoomData);
        setData(secondRoomData);
        setData(thirdRoomData);

        showData(firstRoomData);
        showData(secondRoomData);
        showData(thirdRoomData);

        disableButtonsOnGameBeginning();

        Runnable task = () -> updateTotalIncomeLabel();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(task);
    }

    private void disableButtonsOnGameBeginning() {
        for(Button button: secondRoomData.getRoomButtons()) {
            button.setDisable(true);
        }
        for(Button button: thirdRoomData.getRoomButtons()) {
            button.setDisable(true);
        }
    }

    private void setData(final RoomData roomData) {
        List<String> data = roomData.getData();
        List<Button> buttons = roomData.getRoomButtons();
        List<Label> labels = roomData.getRoomLabels();

        for (int i = 0; i < buttons.size() - 1; i++) {
            //buttons.get(i).setDisable(false);
            buttons.get(i).setText(data.get(0));
        }
        buttons.get(buttons.size() - 1).setText(data.get(1));
        labels.get(0).setText(data.get(2));
    }

    private void showData(final RoomData roomData) {
        List<Button> roomButtons = roomData.getRoomButtons();
        List<Label> roomLabels = roomData.getRoomLabels();
        for (Button b: roomButtons) {
            //System.out.println("button id: " + b.getId());
        }
        for (Label lab: roomLabels) {
            //System.out.println("label id: " + lab.getId());
        }
    }

    private void prepareData(HBox room, RoomData roomData) {
        List<Button> roomButtons = roomData.getRoomButtons();
        List<Label> roomLabels = roomData.getRoomLabels();
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
                SimpleButton controller = new SimpleButton("131313", fruitController);
                loader.setController(controller);
                createChildElement(loader, room);
            }
        }
    }

    private void initExtraButtons(List<HBox> rooms) {
        for (HBox room: rooms) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../resources/view/extraButton.fxml"));
            ExtraButton controller = new ExtraButton("extra", fruitController);
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
            //System.out.println("loaded item for room");
            room.getChildren().add(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onButtonClicked(CustomButton button) {
        System.out.println("BUTTON price: " + button.getPrice());
        if (MainIncome.getBaseIncome() >= button.getPrice()) {
            button.getButton().setDisable(true);
            MainIncome.decreaseMainIncome(button.getPrice());
        } else {
            button.getButton().setDisable(false);
        }
    }

    public void updateTotalIncomeLabel() {
        Timeline wanderer = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                totalIncomeLabel.setText(MainIncome.getBaseIncome() + CURRENCY);
            }
        }));
        wanderer.setCycleCount(Timeline.INDEFINITE);
        wanderer.play();
    }
}
