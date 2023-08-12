package src.model;

import java.io.Serializable;

/**
 * Represents a room in the maze.
 */
public class Room implements Serializable {
    private boolean myWall;

    /**
     * Constructs a new non-wall room.
     */
    public Room() {
        myWall = false;
    }

    /**
     * Checks if the room is a wall.
     *
     * @return True if the room is a wall, false if it is a non-wall room.
     */
    public boolean isWall() {
        return myWall;
    }

    /**
     * Sets the room to be a wall or a non-wall.
     *
     * @param theWall True if the room should be a wall, false if it should be a non-wall room.
     */
    public void setWall(boolean theWall) {
        this.myWall = theWall;
    }
}
