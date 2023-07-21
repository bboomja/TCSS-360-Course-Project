package src.controller;

import src.model.Question;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * This class manages a trivia game.
 * It provides functionalities such as starting the game,
 * displaying questions, and updating the score.
 *
 * @author yaxyeM, HyunJ, ShuaibA
 * @version Summer 2023
 */

public class TriviaGame {

    private int score;
    private Question currentQuestion;
    private List<Question> questions;

    public void startGame() {
        // read questions from file
        try {
            questions = questionReader("question.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // shuffle the questions
        Collections.shuffle(questions);

        // set initial score to 0
        score = 0;

        // display main menu
        displayMainMenu();
    }

    private void displayMainMenu() {
        System.out.println("Welcome to Trivia Maze!");
        System.out.println("------------------------");
        System.out.println("1. Start New Game");
        System.out.println("2. Instructions");
        System.out.println("3. Exit");
        System.out.print("Please enter your choice (1, 2, or 3): ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                displayQuestion();
                break;
            case 2:
                displayInstructions();
                break;
            case 3:
                System.out.println("Thank you for playing Trivia Maze. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
                displayMainMenu();
        }
    }

    // need to put in the UML diagram
    private void displayInstructions(){
        System.out.println("Instructions");
        System.out.println("------------");
        System.out.println("You will be presented with a series of trivia questions.");
        System.out.println("For each question, you will be presented with a set of answer choices.");
        System.out.println("You will be asked to select the correct answer choice.");
        System.out.println("If you select the correct answer, your score will be incremented by 1.");
        System.out.println("If you select the incorrect answer, your score will remain unchanged.");
        System.out.println("At the end of the game, your final score will be displayed.");
        System.out.println("Good luck!");
        System.out.println();
        displayMainMenu();
    }

    /**
     * Displays the current question to the player.
     * If there is a valid current question, it prints the question text
     * along with the answer options.
     * The answer options are numbered starting from 1.
     * If there is no current question available, it prints a message
     * indicating the absense of a question.
     */

    public void displayQuestion() {
        if (questions.size() > 0) {
            currentQuestion = questions.get(0);
            System.out.println("Question: " + currentQuestion.getQuestionText());

            List<String> answerOptions = currentQuestion.getChoices();

            for (int i = 0; i < answerOptions.size(); i++) {
                System.out.println((i + 1) + ". " + answerOptions.get(i));
            }
        } else {
            System.out.println("No question available.");
        }
    }

    private List<Question> questionReader(String questionFile) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(questionFile));
        List<Question> questions = new ArrayList<>();
        // Load your questions into the questions List here...

        return questions;
    }

    /**
     * Updates the player's score based on the correctness of their answer.
     * Retrieves the user's answer choice and compares it with the correct answer
     * stored in the current question.
     * If the user's answer is correct, the score is incremented by 1.
     * Otherwise, the score remains unchanged.
     * The updated score is displayed to the player.
     */

    public void updateScore() {
        int userChoice = getUserChoice();

        if (currentQuestion != null) {
            boolean isCorrect = currentQuestion.checkAnswers(userChoice);

            if (isCorrect) {
                score ++; // Increment the score if the user's answer is correct
                System.out.println("Correct! Your score is now: " + score);
            } else {
                System.out.println("Incorrect! Yore score remains: " + score );
            }
        } else {
            System.out.println("No question available.");
        }
    }

    /**
     * @param choice The user's answer choice
     * @return
     */

    public boolean submitAnswer(int choice) {
        // Fetch the current question
        currentQuestion = questions.get(0);

        // Check if the user's choice matches the correct answer
        boolean isCorrect = choice == currentQuestion.getAnswer();

        // If the answer is correct, update the score
        if (isCorrect) {
            updateScore();
        }

        // Move to the next question regardless of whether the answer was correct
        questions.remove(currentQuestion);

        // Return whether the answer was correct
        return isCorrect;
    }

    public void save() {
        if (!questions.isEmpty()) {
            currentQuestion = questions.get(0);
            questions = questions.subList(1, questions.size());
            questions.remove(0);
        } else {
            System.out.println("No questions available.");
        }
    }

    /**
     * Helper method.
     * Retrieves the user's answer choice from the console.
     *
     * @return The user's answer choice as an integer
     */

    private int getUserChoice() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your answer choice: ");
        int userChoice = sc.nextInt();
        return userChoice;
    }

}
