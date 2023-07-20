package src.model;

/**
 * The Door class represents a door in the game that connects rooms.
 * It can be locked or unlocked and may have an associated question.
 */
public class Door {
    private Question question;
    private Room connectedRoom;
    private boolean isLocked;

    /**
     * Connects the door to a specific room.
     *
     * @param room the room to connect the door to
     */
    public void connectRoom(Room room) {
        connectedRoom = room;
    }

    /**
     * Locks the door.
     */
    public void lock() {
        isLocked = true;
    }

    /**
     * Retrieves the associated question for the door.
     *
     * @return the question associated with the door
     */
    public Question getQuestion() {
        return question;
    }

    /**
     * Retrieves the room connected to the door.
     *
     * @return the connected room
     */
    public Room getConnectedRoom() {
        return connectedRoom;
    }

    /**
     * Checks if the door is locked.
     *
     * @return true if the door is locked, false otherwise
     */
    public boolean isLocked() {
        return isLocked;
    }
}
