package clicker;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;

public class SecondLocationController extends Controller {

    private static final SecondLocationController instance = getInstance();
    private SecondLocationController() {
        String[] firstRoomData = {"202 $", "303 $", "404 $/s"};
        List<Button> firstRoomButtons = new ArrayList<>();
        List<Label> firstRoomLabels = new ArrayList<>();

        String[] secondRoomData = {"505 $", "606 $", "707 $/s"};
        List<Button> secondRoomButtons = new ArrayList<>();
        List<Label> secondRoomLabels = new ArrayList<>();

        String[] thirdRoomData = {"808 $", "909 $", "1010 $/s"};
        List<Button> thirdRoomButtons = new ArrayList<>();
        List<Label> thirdRoomLabels = new ArrayList<>();

        this.room = new Room(new RoomData(firstRoomData, firstRoomButtons, firstRoomLabels),
                new RoomData(secondRoomData, secondRoomButtons, secondRoomLabels),
                new RoomData(thirdRoomData, thirdRoomButtons, thirdRoomLabels));
    }

    public static SecondLocationController getInstance() {
        if (instance == null) {
            return new SecondLocationController();
        }
        return instance;
    }
}
