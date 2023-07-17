package src;

import src.Question;

import java.util.List;

public class TriviaGame {

    private int score;
    private Question currentQuestion;
    private List<Question> questions;
    public void startGame(){
        //read questions from file
        questions= questionReader(questions.text);
        //this is a method that reads the questions from a file

        //create a list of questions
        //shuffle the list
        //set score to 0
        //set current question to first question in list
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
