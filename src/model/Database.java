package src.model;

import org.sqlite.SQLiteDataSource;

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
 * can be acessed via getters.
 */
public class Database {
    /**
     * List holding the questions.
     */
    private static final List<Question> QUESTION_BANK = new ArrayList<>();

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
                String answer = rs.getString("Answer");
                QUESTION_BANK.add(new Question(question, answer));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * Returns a random Question object.
     *
     * @return a random Question object from QUESTION_BANK
     */
    public static Question getRandomQuestion() {
        Random rand = new Random();
        int index = rand.nextInt(QUESTION_BANK.size());
        return QUESTION_BANK.get(index);
    }

}
