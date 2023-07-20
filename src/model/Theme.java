package src.model;

public class Theme {
    private String background;
    private String quizTopic;

    public Theme(String background, String quizTopic) {
        this.background = background;
        this.quizTopic = quizTopic;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public void setQuizTopic(String quizTopic) {
        this.quizTopic = quizTopic;
    }

    public String getBackground() {
        return background;
    }

    public String getQuizTopic() {
        return quizTopic;
    }
}
