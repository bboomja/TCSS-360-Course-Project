package src.controller;

import java.io.FileNotFoundException;

public class GameController {
    private QuestionController questionController;
    private ScoreController scoreController;
    private ThemeController themeController;

    public GameController(QuestionController questionController, ScoreController scoreController, ThemeController themeController) {
        this.questionController = questionController;
        this.scoreController = scoreController;
        this.themeController = themeController;
    }

    public void startGame() {
        try {
            questionController.loadQuestions("question.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Error: Question file not found.");
        }
    }

    public void endGame() {
        // Implementation goes here...
    }

    // Other methods as necessary...
}
