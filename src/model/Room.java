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

    public boolean isVisited() {
        return visited;
    }

    public Door getDoor(Direction direction) {
        return doors.get(direction);
    }

    public void tryDoor(Direction direction, String userAnswer) {
        Door door = doors.get(direction);

        if (door != null && door.getDoorState() != Door.DoorState.DEAD) {
            door.attemptUnlock(userAnswer);  // attempt to unlock the door with the user's answer

            if (door.getDoorState() == Door.DoorState.DEAD) {
                blockDoor(direction);  // block the door in the room if it's locked
            }
        } else {
            System.out.println("There's no door in that direction, or the door is locked.");
        }
    }


    public Question getQuestion(Direction direction) {
        return questions.get(direction);
    }

    public boolean canAttemptQuestion(Direction direction) {
        return !blockedDoors.contains(direction) && doors.get(direction).getDoorState() != Door.DoorState.DEAD;
    }

    @Override
//    public String toString() {
//        StringBuilder roomString = new StringBuilder();
//
//        roomString.append("\n\t\t\t").append(checkMovement(Direction.N));
//        roomString.append("\n\n").append(checkMovement(Direction.W));
//        roomString.append("\t\tPlayer\t\t").append(checkMovement(Direction.E));
//        roomString.append("\n\n\t\t\t").append(checkMovement(Direction.S));
//
//        return roomString.toString();
//    }

    public String toString() {
        return "\n\t\t\t" + checkMovement(Direction.N) +
                "\n\n" + checkMovement(Direction.W) +
                "\t\tPlayer\t\t" + checkMovement(Direction.E) +
                "\n\n\t\t\t" + checkMovement(Direction.S);
    }

    private String checkMovement(Direction direction) {
        if (blockedDoors.contains(direction)) {
            return "BLOCKED";
        }
        Door door = doors.get(direction);
        if (door == null) {
            return "NO DOOR";
        }
        return door.getDoorState() == Door.DoorState.DEAD ? "DEAD DOOR" : "MOVE " + direction;
    }
    public void closeDoor(Direction direction) {
        Door door = doors.get(direction);
        if (door != null && door.getDoorState() == Door.DoorState.UNLOCKED) {
            door.lock();
        }
    }

    public void undeadRoom() {
        doors.values().stream()
                .filter(door -> door != null && door.getDoorState() == Door.DoorState.DEAD)
                .forEach(Door::reset);
    }
}
