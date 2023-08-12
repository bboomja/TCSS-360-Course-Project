package src.model;

import java.io.Serializable;

/**
 * The Player class represents the player in the game.
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
        this.myPrevX = theX;
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
        this.myPrevY = theY;
        this.myY = theY;
    }
    public void moveToPrevPosition() {
        this.myX = myPrevX;
        this.myY = myPrevY;
    }

}