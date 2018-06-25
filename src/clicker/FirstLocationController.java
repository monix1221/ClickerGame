package clicker;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;

public class FirstLocationController extends Controller {

    private static final FirstLocationController instance = getInstance();

    private FirstLocationController() {
        String[] firstRoomData = {"111 $", "333 $", "111 $/s"};
        List<Button> firstRoomButtons = new ArrayList<>();
        List<Label> firstRoomLabels = new ArrayList<>();

        String[] secondRoomData = {"222 $", "666 $", "222 $/s"};
        List<Button> secondRoomButtons = new ArrayList<>();
        List<Label> secondRoomLabels = new ArrayList<>();

        String[] thirdRoomData = {"444 $", "999 $", "355 $/s"};
        List<Button> thirdRoomButtons = new ArrayList<>();
        List<Label> thirdRoomLabels = new ArrayList<>();

        this.room = new Room(new RoomData(firstRoomData, firstRoomButtons, firstRoomLabels),
                new RoomData(secondRoomData, secondRoomButtons, secondRoomLabels),
                new RoomData(thirdRoomData, thirdRoomButtons, thirdRoomLabels));
    }

    public static FirstLocationController getInstance() {
        if (instance == null) {
            return new FirstLocationController();
        }
        return instance;
    }
}
