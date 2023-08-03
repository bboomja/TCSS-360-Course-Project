package src.model;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Set;

/**
 * The Room class represents a room in the game.
 * It stores the room's ID, the doors connected to the room, and the questions for each door.
 */
public class Room {

    private Question question;
    private Door door;

    /**
     * The room's ID.
     */
    private final EnumMap<Direction, Door> doors;
    private final EnumMap<Direction, Question> questions; // Questions map
    private final Set<Direction> blockedDoors;
    private boolean visited = false;

    /**
     * Creates a new Room.
     */

    public Room() {
        doors = new EnumMap<>(Direction.class);
        questions = new EnumMap<>(Direction.class); // Questions map initialization
        blockedDoors = new HashSet<>();
    }

    public void setDoor(Direction direction, Door door) {
        doors.put(direction, door);
    }

    public void setQuestion(Direction direction, Question question) {
        questions.put(direction, question);
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

    /**
     * Returns the room's ID.
     *
     * @return The room's ID
     */

    public boolean isVisited() {
        return visited;
    }

    /**
     * Returns the door in the given direction.
     *
     * @param direction The direction of the door
     * @return The door in the given direction
     */

    public Door getDoor(Direction direction) {
        return doors.get(direction);
    }

    /**
     * Returns the question for the door in the given direction.
     *
     * @param direction The direction of the door
     * @return The question for the door in the given direction
     */

    public void tryDoor(Direction direction, String userAnswer) {
        Door door = doors.get(direction);

        if (door != null && door.getDoorState() != Door.DoorState.WALL) {
            door.attemptUnlock(userAnswer);  // attempt to unlock the door with the user's answer

            if (door.getDoorState() == Door.DoorState.DEAD) {
                System.out.println("Sorry, that's not correct. The door remains closed.");
                blockDoor(direction);  // block the door in the room if it's locked
            } else if (door.getDoorState() == Door.DoorState.WALL) {
                System.out.println("Sorry, that's not correct. The door has turned into a wall!");
                blockDoor(direction);  // block the door in the room if it's turned into a wall
            }
        } else if (door != null && door.getDoorState() == Door.DoorState.WALL) {
            System.out.println("There's a wall in that direction. You cannot go this way.");
        } else {
            System.out.println("There's no door in that direction.");
        }
    }

    /**
     * Returns the question in the given direction.
     * @param direction
     * @return
     */


    public Question getQuestion(Direction direction) {
        return questions.get(direction);
    }

    /**
     * Checks if the player can attempt the question in the given direction.
     * @param direction
     * @return
     */

    public boolean canAttemptQuestion(Direction direction) {
        return !blockedDoors.contains(direction) && doors.get(direction).getDoorState() != Door.DoorState.DEAD;
    }

    @Override
    public String toString() {
        return "\n\t\t\t" + checkMovement(Direction.N) +
                "\n\n" + checkMovement(Direction.W) +
                "\t\tPlayer\t\t" + checkMovement(Direction.E) +
                "\n\n\t\t\t" + checkMovement(Direction.S);
    }

    /**
     * Checks if the player can move in the given direction.
     * @param direction
     * @return
     */

    private String checkMovement(Direction direction) {
        if (blockedDoors.contains(direction)) {
            return "BLOCKED";
        }
        Door door = doors.get(direction);
        if (door == null) {
            return "NO DOOR";
        }
        switch(door.getDoorState()) {
            case DEAD:
                return "DEAD DOOR";
            case WALL:
                return "WALL";
            default:
                return "MOVE " + direction;
        }
    }

    /**
     * Unlocks the door in the given direction if it is locked.
     * @param direction
     */

    public void closeDoor(Direction direction) {
        Door door = doors.get(direction);
        if (door != null && door.getDoorState() == Door.DoorState.UNLOCKED) {
            door.lock();
        }
    }

    /**
     * Unlocks all doors in the room.
     */

    public void undeadRoom() {
        doors.values().stream()
                .filter(door -> door != null && door.getDoorState() == Door.DoorState.DEAD)
                .forEach(Door::reset);
    }
}
