package src.controller;

import src.model.Question;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionController {
    private List<Question> questions;

    public QuestionController() {
        this.questions = new ArrayList<>();
    }

    public List<Question> loadQuestions(String questionFile) throws FileNotFoundException {
        // Implementation goes here...
        return null;
    }

    public Question getNextQuestion() {
        // Implementation goes here...
        return null;
    }

    public void shuffleQuestions() {
        Collections.shuffle(questions);
    }
}
