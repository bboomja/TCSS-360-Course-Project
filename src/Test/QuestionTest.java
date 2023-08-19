package src.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.model.Question;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionTest {

    private Question question;

    @BeforeEach
    public void setUp() {
        question = new Question(
                "What is the capital of France?",
                "Paris",
                "Berlin",
                "London",
                "Paris",
                "Madrid"
        );
    }

    @Test
    public void testGetQuestion() {
        assertEquals("What is the capital of France?", question.getQuestion());
    }

    @Test
    public void testGetAnswer() {
        assertEquals("Paris", question.getAnswer());
    }

    @Test
    public void testGetOptionA() {
        assertEquals("Berlin", question.getOptionA());
    }

    @Test
    public void testGetOptionB() {
        assertEquals("London", question.getOptionB());
    }

    @Test
    public void testGetOptionC() {
        assertEquals("Paris", question.getOptionC());
    }

    @Test
    public void testGetOptionD() {
        assertEquals("Madrid", question.getOptionD());
    }
}
