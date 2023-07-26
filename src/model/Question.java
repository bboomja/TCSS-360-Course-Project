package src.model;

/**
 * The Question class represents a question in the game.
 * It stores the question and its answer.
 */
public class Question {
    /**
     * The question.
     */
    private final String myQuestion;
    /**
     * The answer to the question.
     */
    private final String myAnswer;

    /**
     * Creates a new Question.
     *
     * @param theQuestion The question
     * @param theAnswer The answer to the question
     */
    public Question(final String theQuestion, final String theAnswer) {
        myQuestion = theQuestion;
        myAnswer = theAnswer;
    }

    /**
     * Returns the question.
     *
     * @return The question
     */
    public String getQuestion() {
        return myQuestion;
    }

    /**
     * Returns the answer.
     *
     * @return The answer to the question
     */
    public String getAnswer() {
        return myAnswer;
    }
}

