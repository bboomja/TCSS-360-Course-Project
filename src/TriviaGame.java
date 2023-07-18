package src;

import src.Question;
//@author : yaxyeM, HyunJ, ShuaibA
//@version Summer 2023.
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class TriviaGame {

    private int score;
    private Question currentQuestion;
    private List<Question> questions;
    public void startGame(){
        //read questions from file
        questions= questionReader(questions.text);
        //this is a method that reads the questions from a file

        //shuffle the questions
        Collections.shuffle(questions);
        // Shuffle the list of questions
        Collections.shuffle(questionList);

        // Set initial score to 0
        score = 0;




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
        //save the current state of the game
        // Set current question to the first question in the shuffled list
        currentQuestion = questionList.get(0);
        //save the score
        //save the current question
        //save the list of questions
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
