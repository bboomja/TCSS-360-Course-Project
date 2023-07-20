package src.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The Room class represents a room in the game.
 * It stores the room's ID and the doors connected to the room.
 */
public class Room {
    private String id;
    private List<Door> doors;

    /**
     * Constructs a Room object with the specified ID.
     *
     * @param id the ID of the room
     */
    public Room(String id) {
        this.id = id;
        this.doors = new ArrayList<>();
    }

    /**
     * Adds a door to the room.
     *
     * @param door the door to be added
     */
    public void addDoor(Door door) {
        doors.add(door);
    }

    /**
     * Removes a door from the room.
     *
     * @param door the door to be removed
     */
    public void removeDoor(Door door) {
        doors.remove(door);
    }

    /**
     * Returns the list of doors in the room.
     *
     * @return the list of doors
     */
    public List<Door> getDoors() {
        return doors;
    }

    /**
     * Returns the ID of the room.
     *
     * @return the ID of the room
     */
    public String getId() {
        return id;
    }

}
