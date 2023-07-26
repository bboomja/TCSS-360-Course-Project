package src.controller;

import src.model.Question;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TriviaGame {
    private List<Question> questions;
    private int currentQuestionIndex;
    private int score;

    public TriviaGame() {
        this.questions = new ArrayList<>();
        this.currentQuestionIndex = 0;
        this.score = 0;
    }

    public void startGame() {
        displayMainMenu();


        // shuffle the questions
        Collections.shuffle(questions);
    }
    public void askQuestion() {

        QuestionController questionController = new QuestionController();
        try {
            questions = questionController.loadQuestions("question.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Error: Question file not found.");
        }
    }
    private void displayMainMenu() {
        System.out.println("Welcome to Trivia Maze!");
        System.out.println("------------------------");
        System.out.println("1. Start New Game");
        System.out.println("2. Instructions");
        System.out.println("3. Exit");
        System.out.print("Please enter your choice (1, 2, or 3): ");

        Scanner scanner = new Scanner(System.in);

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                askQuestion();
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
    public boolean hasQuestions() {
        return currentQuestionIndex < questions.size();
    }

    public Question getCurrentQuestion() {
        if (hasQuestions()) {
            return questions.get(currentQuestionIndex);
        }
        return null;
    }

    public void nextQuestion() {
        currentQuestionIndex++;
    }

    public boolean isAnswerCorrect(int userChoice) {
        if (hasQuestions()) {
            Question currentQuestion = getCurrentQuestion();
            return (currentQuestion != null && userChoice == currentQuestion.getCorrectAnswerIndex());
        }
        return false;
    }

    public boolean checkAnswer(int userChoice) {
        return isAnswerCorrect(userChoice);
    }

    public void updateScore(int userChoice) {
            if (isAnswerCorrect(userChoice)) {
                score++; // Increment the score if the user's answer is correct
                System.out.println("Correct! Your score is now: " + score);
            } else {
                System.out.println("Incorrect! Your score remains: " + score);
            }
    }

    public int getScore() {
        return score;
    }

    public String getQuestion(int row, int col) {
        return "Question " + (row * 5 + col + 1);

    }
}
