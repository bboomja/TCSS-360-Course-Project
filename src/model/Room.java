package src.model;

import java.io.Serializable;

/**
 * This class is responsible for managing the properties of a room within the maze.
 * It provides methods to check whether the room is a wall and to set its wall status.
 * The class aids in building the maze's layout and determining movement feasibility.
 *
 * @author Hyun Jeon
 * @author Shuaib Ali
 * @author Yaxye Muxamed
 * @version Summer 2023
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
