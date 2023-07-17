package src;

import java.util.List;

public class Question {
    private String questionText;
    private List<String> choices;
    private int correctAnswer;

    public Question(String questionText, List<String> choices, int correctAnswer) {
        this.questionText = questionText;
        this.choices = choices;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getChoices() {
        return choices;
    }

    public boolean checkAnswers(int choice) {
        return choice == correctAnswer;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public void setCorrectAnswerIndex(int correctAnswerIndex) {
        this.correctAnswerIndex = correctAnswerIndex;
    }
}

