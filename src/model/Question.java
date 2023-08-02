//package src.model;
//
///**
// * The Question class represents a question in the game.
// * It stores the question and its answer.
// */
//public class Question {
//    /**
//     * The question.
//     */
//    private final String myQuestion;
//    /**
//     * The answer to the question.
//     */
//    private final String myAnswer;
//
//    /**
//     * Creates a new Question.
//     *
//     * @param theQuestion The question
//     * @param theAnswer The answer to the question
//     */
//    public Question(final String theQuestion, final String theAnswer) {
//        myQuestion = theQuestion;
//        myAnswer = theAnswer;
//    }
//
//    /**
//     * Returns the question.
//     *
//     * @return The question
//     */
//    public String getQuestion() {
//        return myQuestion;
//    }
//
//    /**
//     * Returns the answer.
//     *
//     * @return The answer to the question
//     */
//    public String getAnswer() {
//        return myAnswer;
//    }
//}
//


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

    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;

    /**
     * Creates a new Question.
     *
     * @param theQuestion The question
     * @param theAnswer The answer to the question
     */
    public Question(final String theQuestion, final String theAnswer, final String optionA,
                    final String optionB, final String optionC, final String optionD) {
        myQuestion = theQuestion;
        myAnswer = theAnswer;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
    }

    public String getOptionA() {
        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public String getOptionD() {
        return optionD;
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

    /**
     * Checks if the provided answer is correct.
     *
     * @param playerAnswer The player's answer
     * @return true if the player's answer matches the correct answer, false otherwise
     */
    public boolean isAnswerCorrect(String playerAnswer) {
        // Assuming case-insensitive answer checking
        return playerAnswer.equalsIgnoreCase(myAnswer);
    }
}
