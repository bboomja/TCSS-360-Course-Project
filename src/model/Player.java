package src.model;

/**
 * Represents a player in the game.
 * A player has a name and a score that can be tracked and updated.
 */
public class Player {

    private String name;
    private int score;

    /**
     * Constructs a new Player object with the given name.
     * The initial score is set to 0.
     *
     * @param name the name of the player
     */
    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    /**
     * Returns the name of the player.
     *
     * @return the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the current score of the player.
     *
     * @return the current score of the player
     */
    public int getScore() {
        return score;
    }

    /**
     * Sets the score of the player to the given value.
     *
     * @param score the new score to set for the player
     */
    public void setScore(int score) {
        this.score = score;
    }
}
