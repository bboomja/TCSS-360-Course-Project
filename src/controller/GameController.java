package src.controller;

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
        // Implementation goes here...
    }

    public void endGame() {
        // Implementation goes here...
    }

    // Other methods as necessary...
}
