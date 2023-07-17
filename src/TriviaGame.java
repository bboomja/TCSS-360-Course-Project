package src;

import src.Question;

import java.util.Collections;
import java.util.List;

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

    public void updateScore() {

    }
    //Ali is fucked up
    public void saveCurrentState(){
        //save the current state of the game
        //save the score
        //save the current question
        //save the list of questions
    }


}
