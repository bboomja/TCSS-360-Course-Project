package src.controller;

public class ScoreController {
    private int score;

    public ScoreController() {
        this.score = 0;
    }

    public void incrementScore() {
        this.score++;
    }

    public void resetScore() {
        this.score = 0;
    }

    public int getScore() {
        return this.score;
    }
}
