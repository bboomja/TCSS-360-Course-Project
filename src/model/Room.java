package src.model;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Set;

/**
 * The Room class represents a room in the game.
 * It stores the room's ID and the doors connected to the room.
 */
public class Room {
    private final EnumMap<Direction, Door> doors;
    private final Set<Direction> blockedDoors;
    private boolean visited = false;

    public Room() {
        doors = new EnumMap<>(Direction.class);
        blockedDoors = new HashSet<>();
    }

    public void setDoor(Direction direction, Door door) {
        doors.put(direction, door);
    }

    public void blockDoor(Direction direction) {
        blockedDoors.add(direction);
    }

    public void unblockDoor(Direction direction) {
        blockedDoors.remove(direction);
    }

    public boolean isBlocked(Direction direction) {
        return blockedDoors.contains(direction);
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isVisited() {
        return visited;
    }

    public Door getDoor(Direction direction) {
        return doors.get(direction);
    }

    @Override
    public String toString() {
        StringBuilder roomString = new StringBuilder();

        roomString.append("\n\t\t\t").append(checkMovement(Direction.N));
        roomString.append("\n\n").append(checkMovement(Direction.W));
        roomString.append("\t\tPlayer\t\t").append(checkMovement(Direction.E));
        roomString.append("\n\n\t\t\t").append(checkMovement(Direction.S));

        return roomString.toString();
    }

    private String checkMovement(Direction direction) {
        if (blockedDoors.contains(direction)) {
            return "BLOCKED";
        } else {
            Door door = doors.get(direction);
            if (door == null) {
                return "NO DOOR";
            } else if (door.getDoorState() == Door.DoorState.DEAD) {
                return "DEAD DOOR";
            } else {
                return "MOVE " + direction;
            }
        }
    }

    public void undeadRoom() {
        for (Direction direction : Direction.values()) {
            Door door = doors.get(direction);
            if (door != null && door.getDoorState() == Door.DoorState.DEAD) {
                door.reset();
            }
        }
    }
}
