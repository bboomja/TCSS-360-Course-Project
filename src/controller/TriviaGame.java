package src.controller;

import src.model.*;

import java.io.*;
import java.util.Scanner;

/**
 * The TriviaGame class is the main class for the game.
 * It contains the main method for the game.
 * It also contains the maze and the number of incorrect answers.
 *
 * @author Shuaib Ali
 * @author Hyun Jeon
 * @author Yaxye Muxamed
 */
public class TriviaGame {
    private static final String SAVE_ONE = "save1.txt";
    private static final String SAVE_TWO = "save2.txt";
    private static final String SAVE_THREE = "save3.txt";
    private static Maze myMaze; // The maze
    private static int myIncorrectAnswerCount = 0;// The number of incorrect answers
    //private static final Set<Question> askedQuestions = new HashSet<>();


    /**
     * The main method for the game.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        introGame();
    }

    private static void introGame() {
        System.out.println("Welcome to our Trivia Maze!");
        System.out.println("Our game theme is U.S. History.");
        System.out.println("Your goal is to reach the finish by answering questions correctly.");
        System.out.println("If you answer 3 questions incorrectly, the game ends.");
        System.out.print("Are you ready to play (Y/N): ");

        Scanner scanner = new Scanner(System.in);
        String playChoice = scanner.nextLine().toUpperCase();

        System.out.println();

        if (playChoice.equals("Y")) {
            Database.connectToDatabase();
            myMaze = new Maze();
            runGameLoop(scanner);
        } else if (playChoice.equals("N")) {
            System.out.println("Maybe next time! Goodbye.");
        } else {
            System.out.println("Invalid input. Please enter Y or N.");
            introGame();
        }
    }


    /**
     * Runs the main game loop.
     *
     * @param theScanner The scanner for user input.
     */
    private static void runGameLoop(Scanner theScanner) {
        while (true) {
            System.out.println(myMaze.toString());

            if (myMaze.isExitReached()) {
                System.out.println("Congratulations! You reached the finish!");
                break;
            }

            System.out.print("Enter a direction (N, S, E, W) or '1' to save, '2' to load: ");
            String input = theScanner.nextLine().toUpperCase();
            System.out.println();

            if (input.equals("1")) {
                saveGame();
                continue;
            } else if (input.equals("2")) {
                loadGame();
                continue;
            }

            Direction direction = null;
            boolean validInput = false;

            while (!validInput) {
                try {
                    direction = Direction.valueOf(input);
                    validInput = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid direction. Please enter N, S, E, W, or '1' to save, '2' to load.");
                    break;
                }
            }

            if (myMaze.movePlayer(direction)) {
                Question question = Database.getRandomQuestion();
                askQuestionAndProcessAnswer(question, theScanner, direction);
            } else {
                // The player is on the edge of the maze

                System.out.println("Invalid move. YOU ARE ON THE EDGE OF THE MAZE.");
            }
        }
    }

    // ...
    /**
     * Presents a question to the player, processes the answer, and updates
     * game state accordingly.
     *
     * @param theQuestion The question to be asked
     * @param theScanner The scanner for user input
     * @param theDirection The direction in which the door is located
     */
    private static void askQuestionAndProcessAnswer(Question theQuestion,
                                                    Scanner theScanner, Direction theDirection) {
        System.out.println("Here's a question! If you answer correctly, the door will open.");
        System.out.println("Question: " + theQuestion.getQuestion());
        System.out.println("A: " + theQuestion.getOptionA());
        System.out.println("B: " + theQuestion.getOptionB());
        System.out.println("C: " + theQuestion.getOptionC());
        System.out.println("D: " + theQuestion.getOptionD());

        String userAnswer;
        while (true) {
            System.out.print("Your answer (A, B, C, D): ");
            String userAnswers = theScanner.nextLine().toUpperCase();

            switch (userAnswers) {
                case "A" -> userAnswer = theQuestion.getOptionA();
                case "B" -> userAnswer = theQuestion.getOptionB();
                case "C" -> userAnswer = theQuestion.getOptionC();
                case "D" -> userAnswer = theQuestion.getOptionD();
                default -> {
                    System.out.println("Invalid choice. Please enter A, B, C, or D.");
                    continue; // Loop back and ask the user for the answer choice again
                }
            }

            if (userAnswer.equalsIgnoreCase(theQuestion.getAnswer())) {
                System.out.println("Correct! Door opens to " + theDirection + " Direction.");
            } else {
                System.out.println("Incorrect. Door remains closed.");
                System.out.println("Failed attempts: " + (myIncorrectAnswerCount + 1) + "/3");
                myMaze.getPlayer().moveToPrevPosition();
                myIncorrectAnswerCount++;

                if (myIncorrectAnswerCount == 3) {
                    handleGameEnd(theScanner);
                }
            }
            break; // Exit the loop once the user's answer is processed
        }
    }
// ...


    /**
     * Handles the end of the game, providing options to restart or end.
     *
     * @param theScanner The scanner for user input
     */
    private static void handleGameEnd(Scanner theScanner) {
        System.out.println("GAME IS OVER! THE PLAYER IS TRAPPED.");
        myMaze.lockAllDoors();

        System.out.print("Would you like to restart the game? (Y/N): ");
        String input = theScanner.nextLine().toUpperCase();

        if (input.equals("Y")) {
            restartGame();
        } else {
            endGame(theScanner);
        }
    }

    /**
     * Restarts the game by resetting the game state and reconnecting to the database.
     */
    private static void restartGame() {
        System.out.println("Restarting the game...");
        resetGame();
        Database.resetUsedQuestions(); // Reset used questions
        Database.connectToDatabase();
    }


    /**
     * Ends the game and exits the applications.
     *
     * @param theScanner The scanner for user input.
     */
    private static void endGame(Scanner theScanner) {
        System.out.println("Ending the game...");
        theScanner.close();
        System.exit(0);
    }

    /**
     * Resets the game to its initial state.
     */
    private static void resetGame() {
        myMaze = new Maze();
        myIncorrectAnswerCount = 0;
    }

    /**
     * Saves the current game state to a specified save file.
     */
    private static void saveGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a save file (1, 2, 3): ");
        String userOption = scanner.nextLine();

        String saveFileName;
        switch (userOption) {
            case "1" -> saveFileName = SAVE_ONE;
            case "2" -> saveFileName = SAVE_TWO;
            case "3" -> saveFileName = SAVE_THREE;
            default -> {
                System.out.println("Invalid save file option.");
                return;
            }
        }

        String currentDir = System.getProperty("user.dir");
        String filePath = currentDir + File.separator + saveFileName;

        try (FileOutputStream fileStream = new FileOutputStream(filePath);
             ObjectOutputStream objectStream = new ObjectOutputStream(fileStream)) {
            objectStream.writeObject(myMaze);
            System.out.println("Game saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving the game.");
            e.printStackTrace();
        }
    }


    /**
     * Loads a saved game state from a specified save file.
     */
    private static void loadGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a save file to load (1, 2, 3): ");
        String userLoadOption = scanner.nextLine();

        String loadFileName;
        switch (userLoadOption) {
            case "1" -> loadFileName = SAVE_ONE;
            case "2" -> loadFileName = SAVE_TWO;
            case "3" -> loadFileName = SAVE_THREE;
            default -> {
                System.out.println("Invalid load file option.");
                return;
            }
        }

        try (FileInputStream fileStream = new FileInputStream(loadFileName);
             ObjectInputStream objectStream = new ObjectInputStream(fileStream)) {
            myMaze = (Maze) objectStream.readObject();
            System.out.println("Game loaded successfully!");
            Database.resetUsedQuestions(); // Reset used questions
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading the game.");
        }
    }

}


