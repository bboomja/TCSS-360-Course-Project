package src.controller;

import src.model.*;

import javax.xml.crypto.Data;
import java.util.Scanner;

public class TriviaGame {
    public static void main(String[] args) {
        System.out.println("Current Directory: " + System.getProperty("user.dir"));

        Database.connectToDatabase();

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
                Question question = Database.getRandomQuestion();
                System.out.println("Here's a question! If you answer correctly, the door will open.");
                System.out.println("Question: " + question.getQuestion());
                System.out.println("A: " + question.getOptionA());
                System.out.println("B: " + question.getOptionB());
                System.out.println("C: " + question.getOptionC());
                System.out.println("D: " + question.getOptionD());

                System.out.print("Your answer (A, B, C, D): ");
                String userAnswers = scanner.nextLine().toUpperCase();

                String userAnswer;
                switch (userAnswers) {
                    case "A":
                        userAnswer = question.getOptionA();
                        break;
                    case "B":
                        userAnswer = question.getOptionB();
                        break;
                    case "C":
                        userAnswer = question.getOptionC();
                        break;
                    case "D":
                        userAnswer = question.getOptionD();
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter A, B, C, or D.");
                        continue;
                }

                if (userAnswer.equalsIgnoreCase(question.getAnswer())) {
                    System.out.println("Correct! The door opens.");
                } else {
                    System.out.println("Sorry, that's not correct. The door remains closed.");
                    maze.getPlayer().moveToPrevPosition();
                }
            }
        }

        // Close the scanner
        scanner.close();
    }
}
