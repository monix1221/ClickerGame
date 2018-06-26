package clicker;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.List;

public class RoomData {
    private List<String> data;
    private List<Button> roomButtons;
    private List<Label> roomLabels;

    public RoomData(List<String> data, List<Button> roomButtons, List<Label> roomLabels) {
        this.data = data;
        this.roomButtons = roomButtons;
        this.roomLabels = roomLabels;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
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
