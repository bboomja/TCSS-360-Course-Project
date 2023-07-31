package src.model;

/**
 * The Player class represents the player in the game.
 */
public class Player {
    private int x;
    private int y;
    private int health;

    /**
     * Constructs a new Player object with default values.
     */
    public Player() {
        x = 0;
        y = 0;
        health = 100;
    }

    /**
     * Gets the X coordinate of the player's position.
     *
     * @return The X coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the X coordinate of the player's position.
     *
     * @param x The new X coordinate.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Gets the Y coordinate of the player's position.
     *
     * @return The Y coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the Y coordinate of the player's position.
     *
     * @param y The new Y coordinate.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Gets the player's health.
     *
     * @return The player's health.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Sets the player's health.
     *
     * @param health The new player's health.
     */
    public void setHealth(int health) {
        this.health = health;
    }
}
