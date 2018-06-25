package clicker;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.List;

public class Controller {

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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
