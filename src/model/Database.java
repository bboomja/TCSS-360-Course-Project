package src.model;

import org.sqlite.SQLiteDataSource;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class handles connection to the QuestionAnswer table of
 * the Table database and loading the contents into ArrayList that
 * can be accessed via getters.
 *
 * @author Hyun Jeon
 * @author Shuaib Ali
 * @author Yaxye Muxamed
 * @version Summer 2023
 */
public class Database implements Serializable {
    /**
     * List holding the questions.
     */
    private static final List<Question> QUESTION_BANK = new ArrayList<>();
    private static final List<Question> USED_QUESTIONS = new ArrayList<>();


    /**
     * Establishes a connection to the database and loads table values into ArrayLists.
     */
    public static void connectToDatabase() {
        // Create DataSource object
        SQLiteDataSource ds = new SQLiteDataSource();
        // Set DataSource URL
        ds.setUrl("jdbc:sqlite:Table.db");
        // Set where we want to get our questions and answers from
        String query = "SELECT * FROM QuestionAnswer";
        // Set up the connection
        try (Connection conn = ds.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String question = rs.getString("Question");
                String answer = rs.getString(  "Answer");
                String optionA = rs.getString("Choice1");
                String optionB = rs.getString("Choice2");
                String optionC = rs.getString("Choice3");
                String optionD = rs.getString("Choice4");
                QUESTION_BANK.add(new Question(question, answer, optionA, optionB, optionC, optionD));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * Gets the list of questions.
     *
     * @return The list of questions.
     */

    public static Question getRandomQuestion() {
        if (QUESTION_BANK.isEmpty()) {
            // Handle the case where no questions are available
            return null;
        }

        // Find an unused question
        Random rand = new Random();
        int index;
        do {
            index = rand.nextInt(QUESTION_BANK.size());
        } while (USED_QUESTIONS.contains(QUESTION_BANK.get(index)));

        Question selectedQuestion = QUESTION_BANK.get(index);
        USED_QUESTIONS.add(selectedQuestion); // Mark the question as used
        return selectedQuestion;
    }

    public static int getUsedQuestionsSize() {
        return USED_QUESTIONS.size();
    }

    /**
     * Gets the list of questions.
     *
     */

    public static void resetUsedQuestions() {
        USED_QUESTIONS.clear();
    }

}
