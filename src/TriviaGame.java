package src;

import src.Question;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TriviaGame {

    private int score;
    private Question currentQuestion;
    private List<Question> questions;
    public void startGame(){
        //first display the question
        displayQuestion();
        displayMainMenu(); //this is a method that displays the main menu

        //read questions from file
        questions= questionReader(questions.txt);
        //this is a method that reads the questions from a file

        //shuffle the questions
        Collections.shuffle(questions);
        // Shuffle the list of questions
        Collections.shuffle(questionList);

        // Set initial score to 0
        score = 0;


    }
    private List<Question> questionReader(String filePath) {
        // Implement the method to read questions from the file and return a list of questions
        // You can use file I/O to read the questions from the file and create Question objects.
        // Add the Question objects to a list and return it.
        // You can handle exceptions in case the file is not found or there is an error during reading.
        // Sample code to read questions from a file and create Question objects:
        // 1. Open the file
        // 2. Read the lines one by one
        // 3. Create Question objects for each line and add them to a list
        // 4. Return the list of Question objects
        // Remember to close the file after reading.

        // Sample code:
        // List<Question> questionList = new ArrayList<>();
        // try {
        //     FileReader fileReader = new FileReader(filePath);
        //     BufferedReader bufferedReader = new BufferedReader(fileReader);
        //     String line;
        //     while ((line = bufferedReader.readLine()) != null) {
        //         // Create a Question object from the line and add it to the questionList
        //     }
        //     bufferedReader.close();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
        // return questionList;

        // Placeholder code to return an empty list
        return Collections.emptyList();
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
                startGame();
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
    private void displayInstructions() {
        System.out.println("Instructions");
        System.out.println("------------");
        System.out.println("You will be presented with a series of trivia questions.");
        System.out.println("You will be given 4 answer choices for each question.");
        System.out.println("You must enter the number corresponding to the correct answer choice.");
        System.out.println("Your score will be displayed after each question.");
        System.out.println("Good luck!");
        System.out.println();
        displayMainMenu();
    }

    public void displayQuestion() {
        if (currentQuestion != null) {
            System.out.println("Question: " + currentQuestion.getQuestionText());

            List<String> answerOptions = currentQuestion.getChoices();

            for (int i = 0; i < answerOptions.size(); i++) {
                System.out.println((i + 1) + ". " + answerOptions.get(i));
            }
        } else {
            System.out.println("No question available.");
        }
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
            boolean isCorrect = currentQuestion.checkAnswer(userChoice);

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

    public void saveCurrentState(){
        if (!questions.isEmpty()) {
            // Save the current question
            currentQuestion = questions.get(0);
            // Save the list of questions
            // For simplicity, we assume the current question is removed from the list of questions
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
        int choice = sc.nextInt();
        return choice;
    }

}
