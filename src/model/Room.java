package src.model;

import java.util.EnumMap;

/**
 * The Room class represents a room in the game.
 * It stores the room's ID and the doors connected to the room.
 */
public class Room {
    private final EnumMap<Direction, Door> doors;
    private final RoomBlocker myBlockedDoors;
    private boolean myVisited = false;

    public Room(final RoomBlocker theBlocker, final Door theNorthDoor,
                final Door theSouthDoor, final Door theEastDoor,
                final Door theWestDoor) {
        myBlockedDoors = theBlocker;
        doors = new EnumMap<>(Direction.class);
        setDoor(Direction.N, theNorthDoor);
        setDoor(Direction.S, theSouthDoor);
        setDoor(Direction.E, theEastDoor);
        setDoor(Direction.W, theWestDoor);
    }

    private void setDoor(Direction direction, Door door) {
        if (myBlockedDoors.isBlocked(direction)) {
            doors.put(direction, door);
        }
    }

    public void setVisited(final boolean theVisited) {
        myVisited = theVisited;
    }

    public boolean getVisited() {
        return myVisited;
    }

    public Door getDoor(final Direction direction) {
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

    private String checkMovement(final Direction direction) {
        Door door = getDoor(direction);
        if (door == null) {
            return "BLOCKED";
        } else if (door.getDoorState() == Door.DoorState.DEAD) {
            return "DEAD DOOR";
        } else {
            return "MOVE " + direction;
        }
    }

    public void undeadRoom() {
        for (Direction direction : Direction.values()) {
            Door door = getDoor(direction);
            if (door != null && door.getDoorState() == Door.DoorState.DEAD) {
                door.reset();
            }
        }
    }
}
