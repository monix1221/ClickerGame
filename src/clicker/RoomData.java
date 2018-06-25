package clicker;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;

public class RoomData {
    private String[] roomData = new String[3];
    private List<Button> roomButtons = new ArrayList<>();
    private List<Label> roomLabels = new ArrayList<>();

    public RoomData(String[] roomData, List<Button> roomButtons, List<Label> roomLabels) {
        this.roomData = roomData;
        this.roomButtons = roomButtons;
        this.roomLabels = roomLabels;
    }

    public String[] getRoomData() {
        return roomData;
    }

    public void setRoomData(String[] roomData) {
        this.roomData = roomData;
    }

    public List<Button> getRoomButtons() {
        return roomButtons;
    }

    public void setRoomButtons(List<Button> roomButtons) {
        this.roomButtons = roomButtons;
    }

    public List<Label> getRoomLabels() {
        return roomLabels;
    }

    public void setRoomLabels(List<Label> roomLabels) {
        this.roomLabels = roomLabels;
    }
}
