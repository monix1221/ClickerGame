package clicker;

public class Room {
    private RoomData firstRoom;
    private RoomData secondRoom;
    private RoomData thirdRoom;

    public Room (RoomData firstRoom, RoomData secondRoom, RoomData thirdRoom) {
        this.firstRoom = firstRoom;
        this.secondRoom = secondRoom;
        this.thirdRoom = thirdRoom;
    }

    public RoomData getFirstRoom() {
        return firstRoom;
    }

    public void setFirstRoom(RoomData firstRoom) {
        this.firstRoom = firstRoom;
    }

    public RoomData getSecondRoom() {
        return secondRoom;
    }

    public void setSecondRoom(RoomData secondRoom) {
        this.secondRoom = secondRoom;
    }

    public RoomData getThirdRoom() {
        return thirdRoom;
    }

    public void setThirdRoom(RoomData thirdRoom) {
        this.thirdRoom = thirdRoom;
    }
}
