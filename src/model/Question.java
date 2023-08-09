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

    final private String myOptionA;
    final private String myOptionB;
    final private String myOptionC;
    final private String myOptionD;

    /**
     * Creates a new Question.
     *
     * @param theQuestion The question
     * @param theAnswer The answer to the question
     */
    public Question(final String theQuestion, final String theAnswer, final String theOptionA,
                    final String theOptionB, final String theOptionC, final String theOptionD) {
        myQuestion = theQuestion;
        myAnswer = theAnswer;
        this.myOptionA = theOptionA;
        this.myOptionB = theOptionB;
        this.myOptionC = theOptionC;
        this.myOptionD = theOptionD;
    }

    public String getOptionA() {
        return myOptionA;
    }

    public String getOptionB() {
        return myOptionB;
    }

    public String getOptionC() {
        return myOptionC;
    }

    public String getOptionD() {
        return myOptionD;
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
