package src.Test;

import src.model.Database;
import src.model.Question;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest {

    @BeforeEach
    void setUp() {
        Database.connectToDatabase();  // Connects to the database and fills up the QUESTION_BANK
    }

    @Test
    void testGetRandomQuestion() {
        Question q1 = Database.getRandomQuestion();
        assertNotNull(q1);  // Check if a question is returned

        Question q2 = Database.getRandomQuestion();
        assertNotNull(q2);

        // Checks if two consecutive calls don't return the same question
        assertNotEquals(q1.getQuestion(), q2.getQuestion());
    }

    @Test
    public void testGetRandomQuestionIncreasesUsedQuestionsSize() {
        int initialSize = Database.getUsedQuestionsSize();
        Database.getRandomQuestion();
        int newSize = Database.getUsedQuestionsSize();
        assertTrue(newSize == initialSize + 1, "Expected USED_QUESTIONS size to increase by 1 after getting a random question");
    }

    @Test
    public void testResetUsedQuestions() {
        // First, get a random question to ensure USED_QUESTIONS is not empty
        Database.getRandomQuestion();

        // Now, reset
        Database.resetUsedQuestions();

        // Check if USED_QUESTIONS is empty after reset
        assertEquals(0, Database.getUsedQuestionsSize(), "Expected USED_QUESTIONS size to be 0 after reset");
    }

    @AfterEach
    void tearDown() {
        Database.resetUsedQuestions();  // Clean up after each test to ensure no state is maintained between tests
    }
}
