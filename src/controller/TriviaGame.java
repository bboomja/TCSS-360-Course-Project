package src.controller;

import src.model.Direction;
import src.model.Maze;

import java.util.Scanner;

public class TriviaGame {
    public static void main(String[] args) {
        System.out.println("Current Directory: " + System.getProperty("user.dir"));
        // Connect to the database and load questions
        // ...

        // Create the maze
        final int mazeSize = 5; // You can change this to any desired maze size
        Maze maze = new Maze();

        // Create a Scanner to get user input
        Scanner scanner = new Scanner(System.in);

        // Main game loop
        while (true) {
            // Print the current state of the maze
            System.out.println(maze.toString());

            // Check if the player has reached the goal
            if (maze.isExitReached()) {
                System.out.println("Congratulations! You reached the finish!");
                break;
            }

            // Get the user input for movement
            Direction direction = null;
            boolean validInput = false;

            while (!validInput) {
                System.out.print("Enter a direction (N, S, E, W): ");
                String input = scanner.nextLine().toUpperCase();

                try {
                    direction = Direction.valueOf(input);
                    validInput = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid direction. Please enter N, S, E, or W.");
                }
            }

            // Move the player and handle door interactions
            if (maze.movePlayer(direction)) {
                // Handle door interactions here if needed
                // ...
            }
        }

        // Close the scanner
        scanner.close();
    }
}
