package src.controller;

import src.model.*;
import java.util.Scanner;

/**
 * The TriviaGame class is the main class for the game.
 * It contains the main method for the game.
 * It also contains the maze and the number of incorrect answers.
 *
 * @Shuaib Ali
 * @Hyun Jeon
 * @Yaxye Muxamed
 */

public class TriviaGame {
    private static final int mazeSize = 5; // The size of the maze
    private static Maze maze; // The maze
    private static int incorrectAnswerCount = 0;// The number of incorrect answers

    /**
     * The main method for the game.
     *
     * @param args The command line arguments.
     */

    public static void main(String[] args) {
        System.out.println("Current Directory: " + System.getProperty("user.dir"));

        Database.connectToDatabase();

        maze = new Maze();

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println(maze.toString());

            if (maze.isExitReached()) {
                System.out.println("Congratulations! You reached the finish!");
                break;
            }

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
            // Compare this snippet from src/model/Maze.java:
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
                    System.out.println("Correct! Door opens to " + direction + " Direction.");
                } else {
                    System.out.println("Incorrect. Door remains closed.");
                    maze.getPlayer().moveToPrevPosition();
                    incorrectAnswerCount++;

                    if (incorrectAnswerCount >= 3) {
                        System.out.println("GAME IS OVER! THE PLAYER IS TRAPPED.");
                        maze.lockAllDoors();

                        System.out.println("Would you like to restart the game? (Y/N)");
                        String input = scanner.nextLine().toUpperCase();

                        if (input.equals("Y")) {
                            System.out.println("Restarting the game...");
                            resetGame();
                            continue;  // Starts the next iteration of the game loop, effectively restarting the game
                        } else {
                            System.out.println("Ending the game...");
                            break;  // Exits the game loop, effectively ending the game
                        }
                    }
                }
            }
        }

        // Close the scanner
        scanner.close();
    }

    /**
     * Resets the game to its initial state.
     */

    private static void resetGame() {
        maze = new Maze();
        incorrectAnswerCount = 0;
    }
}

