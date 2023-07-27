package src.controller;

import src.model.Database;
import src.model.Direction;
import src.model.Maze;
import src.model.Room;

import java.util.Scanner;

/**
 * Trivia Maze Start.
 */
public class TriviaGame {
    public static void main(String[] args) {
        System.out.println("Current Directory: " + System.getProperty("user.dir"));
        // Connect to the database and load questions
        Database.loadQuestionsFromDatabase();

        // Create the maze
        final int mazeSize = 5; // You can change this to any desired maze size
        Maze maze = new Maze(mazeSize);

        // Create a Scanner to get user input
        Scanner scanner = new Scanner(System.in);

        // Main game loop
        while (true) {
            // Print the current state of the maze
            System.out.println(maze.toString());

            // Check if the player has reached the goal
            if (maze.goalReached()) {
                System.out.println("Congratulations! You reached the finish!");
                break;
            }

            // Get the user input for movement
            System.out.print("Enter a direction (N, S, E, W): ");
            String input = scanner.nextLine().toUpperCase();
            Direction direction = Direction.valueOf(input);

            // Move the player and handle door interactions
            if (maze.canMovePlayer(direction)) {
                maze.movePlayer(direction);
                Room currentRoom = maze.getCurrentRoom();
                if (currentRoom.getDoor(direction) != null) {
                    handleDoorInteraction(currentRoom, scanner);
                }
            } else {
                System.out.println("You can't move in that direction.");
            }
        }

        // Close the scanner
        scanner.close();
    }

    private static void handleDoorInteraction(Room room, Scanner scanner) {
        Direction direction = null;
        for (Direction dir : Direction.values()) {
            if (room.getDoor(dir) != null) {
                direction = dir;
                break;
            }
        }

        if (direction == null) {
            System.out.println("Invalid door direction.");
            return;
        }

        //Room nextRoom = room.getDoor(direction).isDead() ? room : room.getDoor(direction).getDoorState() == Room.Door.DoorState.UNLOCKED ? room.getDoor(direction) : room;

//        if (room.getDoor(direction).getDoorState() == Room.Door.DoorState.UNLOCKED) {
//            System.out.println("You can pass through the door.");
//        } else {
//            System.out.println("This door is locked. Answer the question to unlock it.");
//            System.out.println("Question: " + room.getDoor(direction).getQuestion());
//            System.out.print("Your answer: ");
//            String userAnswer = scanner.nextLine().trim();
//            room.getDoor(direction).attemptUnlock(userAnswer);
//        }
//
//        if (nextRoom != room) {
//            nextRoom.setVisited(true);
//        }
    }
}
