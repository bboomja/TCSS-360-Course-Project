package src.model;

import java.io.Serializable;

/**
 * This class is responsible for managing the player's position
 * and actions within the game.
 * It also provides functionality for undoing moves and interacting
 * with the maze's boundaries.
 *
 * @author Shuaib Ali
 * @author Hyun Jeon
 * @author Yaxye Muxamed
 * @version Summer 2023
 */
public class Player implements Serializable {
    private int myX;
    private int myY;
    private int myPrevX;
    private int myPrevY;

    /**
     * Constructs a new Player object with default values.
     */
    public Player() {
        myX = 0;
        myY = 0;
        myPrevX = 0;
        myPrevY = 0;
    }

    /**
     * Gets the X coordinate of the player's position.
     *
     * @return The X coordinate.
     */
    public int getX() {
        return myX;
    }

    /**
     * Sets the X coordinate of the player's position.
     *
     * @param theX The new X coordinate.
     */
    public void setX(int theX) {
        this.myPrevX = this.myX;
        this.myX = theX;
    }

    /**
     * Gets the Y coordinate of the player's position.
     *
     * @return The Y coordinate.
     */
    public int getY() {
        return myY;
    }

    /**
     * Sets the Y coordinate of the player's position.
     *
     * @param theY The new Y coordinate.
     */
    public void setY(int theY) {
        this.myPrevY = this.myY;
        this.myY = theY;
    }

    /**
     * Moves the player to their previous position, effectively undoing the last move.
     */
    public void moveToPrevPosition() {
        this.myX = this.myPrevX;
        this.myY = this.myPrevY;
    }
}
