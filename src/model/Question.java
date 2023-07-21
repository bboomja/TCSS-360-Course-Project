package src.model;

import java.util.List;

/**
 * Represents a question in a trivia game.
 * A question consists of a question text, a list of choices,
 * and the index of the correct answer.
 */
public class Question {
    private String questionText;
    private List<String> choices;
    private int correctAnswer;

    /**
     * Constructs a new Question object with the specified question text,
     * choices, and correct answer.
     *
     * @param questionText the text of the question
     * @param choices the list of choices for the question
     * @param correctAnswer the index of the correct answer in the choices list
     */
    public Question(String questionText, List<String> choices, int correctAnswer) {
        this.questionText = questionText;
        this.choices = choices;
        this.correctAnswer = correctAnswer;
    }

    /**
     * Returns the text of the question.
     *
     * @return the text of the question
     */
    public String getQuestionText() {
        return questionText;
    }

    /**
     * Returns the list of choices for the question.
     *
     * @return the list of choices
     */
    public List<String> getChoices() {
        return choices;
    }

    /**
     * Checks if the given choice is the correct answer.
     *
     * @param choice the user's selected choice
     * @return true if the choice is the correct answer, false otherwise
     */
    public boolean checkAnswers(int choice) {
        return choice == correctAnswer;
    }

    public int getAnswer() {
        return 0;
    }

//    public int getCorrectAnswerIndex() {
//        return correctAnswerIndex;
//    }
//
//    public void setCorrectAnswerIndex(int correctAnswerIndex) {
//        this.correctAnswerIndex = correctAnswerIndex;
//    }
}

