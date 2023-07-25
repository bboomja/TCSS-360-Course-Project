package src.controller;

import src.model.Question;

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

        questions.add(new Question("Who was the first president of the USA?",
                List.of("George Washington", "Thomas Jefferson", "John Adams"), 0, "Explanation 1"));
        questions.add(new Question("When was the World War 2?",
                List.of("1914-1918", "1939-1945", "1941-1945"), 1, "Explanation 2"));
        questions.add(new Question("How did Washington state get its name, and what historical figures influenced this decision?",
                List.of("Option 1", "Option 2", "Option 3"), 2, "Explanation 3"));
        questions.add(new Question("How did the construction of the Northern Pacific Railroad impact the growth" +
                " and development of Washington state in the late 19th century?",
                List.of(
                        "It facilitated faster transportation of goods and people, leading to economic growth.",
                        "It had no significant impact on the growth and development of Washington state.",
                        "It caused environmental damage and negatively affected indigenous communities."
                ),
                0, // The correct answer index (0-based index of the correct answer in the list)
                "Explanation for the correct answer."
        ));
        questions.add(new Question("What was the purpose of the Dawes Act of 1887?",
                List.of(
                        "To provide land grants to railroad companies.",
                        "To provide land grants to settlers.",
                        "To assimilate Native Americans into American society."
                ),
                2, // The correct answer index (0-based index of the correct answer in the list)
                "Explanation for the correct answer."
        ));
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

    public boolean checkAnswer(int userChoice) {
        if (hasQuestions()) {
            Question currentQuestion = getCurrentQuestion();
            return (currentQuestion != null && userChoice == currentQuestion.getCorrectAnswerIndex());
        }
        return false;
    }

    public void updateScore(int userChoice) {
        if (hasQuestions()) {
            Question currentQuestion = getCurrentQuestion();
            boolean isCorrect = (currentQuestion != null && userChoice == currentQuestion.getCorrectAnswerIndex());

            if (isCorrect) {
                score++; // Increment the score if the user's answer is correct
                System.out.println("Correct! Your score is now: " + score);
            } else {
                System.out.println("Incorrect! Your score remains: " + score);
            }
        } else {
            System.out.println("No question available.");
        }
    }

    public int getScore() {
        return score;
    }

    public String getQuestion(int row, int col) {
        return "Question " + (row * 5 + col + 1);

    }
}
