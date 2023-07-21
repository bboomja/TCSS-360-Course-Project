package src.model;

/**
 * Represents a theme that is used for a specific quiz,
 * each theme has a background and a quiz topic associated with it.
 */
public class Theme {

    /** The background associated with this theme. */
    private String background;

    /** The quiz topic associated with this theme. */
    private String quizTopic;

    /**
     * Constructs a new theme with the given background and quiz topic.
     *
     * @param background the background to be set for this theme
     * @param quizTopic the quiz topic to be set for this theme
     */
    public Theme(String background, String quizTopic) {
        this.background = background;
        this.quizTopic = quizTopic;
    }

    /**
     * Sets the background for this theme.
     *
     * @param background the new background to be set
     */
    public void setBackground(String background) {
        this.background = background;
    }

    /**
     * Sets the quiz topic for this theme.
     *
     * @param quizTopic the new quiz topic to be set
     */
    public void setQuizTopic(String quizTopic) {
        this.quizTopic = quizTopic;
    }

    /**
     * Retrieves the background associated with this theme.
     *
     * @return the current background of this theme
     */
    public String getBackground() {
        return background;
    }

    /**
     * Retrieves the quiz topic associated with this theme.
     *
     * @return the current quiz topic of this theme
     */
    public String getQuizTopic() {
        return quizTopic;
    }
}
