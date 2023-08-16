package src.model;

import java.io.Serializable;

/**
 * The Question class represents a question in the game.
 * It stores the question and its answer.
 *
 * @author Hyun Jeon
 * @author Shuaib Ali
 * @author Yaxye Muxamed
 * @version Summer 2023
 */
public class Question implements Serializable {

    /**
     * The question text.
     */
    private final String myQuestion;

    /**
     * The answer to the question.
     */
    private final String myAnswer;

    /**
     * Option A for multiple choice.
     */
    final private String myOptionA;

    /**
     * Option B for multiple choice.
     */
    final private String myOptionB;

    /**
     * Option C for multiple choice.
     */
    final private String myOptionC;

    /**
     * Option D for multiple choice.
     */
    final private String myOptionD;

    /**
     * Creates a new Question instance.
     *
     * @param theQuestion The text of the question
     * @param theAnswer The correct answer to the question
     * @param theOptionA Option A for multiple choice
     * @param theOptionB Option B for multiple choice
     * @param theOptionC Option C for multiple choice
     * @param theOptionD Option D for multiple choice
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

    /**
     * Gets option A for multiple choice.
     *
     * @return Option A
     */
    public String getOptionA() {
        return myOptionA;
    }

    /**
     * Gets option B for multiple choice.
     *
     * @return Option B
     */
    public String getOptionB() {
        return myOptionB;
    }

    /**
     * Gets option C for multiple choice.
     *
     * @return Option C
     */
    public String getOptionC() {
        return myOptionC;
    }

    /**
     * Gets option D for multiple choice.
     *
     * @return Option D
     */
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
