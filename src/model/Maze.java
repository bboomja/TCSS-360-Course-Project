package src.model;

import java.io.Serializable;
import java.util.*;

/**
 * The Maze class represents the main game environment where the player navigates.
 *
 * @author Hyun Jeon
 * @author Shuaib Ali
 * @author Yaxye Muxamed
 * @version Summer 2023
 */
public class Maze implements Serializable {
    private static final int MAZE_SIZE = 3;

    private final Player myPlayer;
    private final Room[][] myRooms;

    /**
     * Constructs a new Maze object with a default size.
     */
    public Maze() {
        myPlayer = new Player();
        myRooms = new Room[MAZE_SIZE][MAZE_SIZE];
        initializeRooms();
    }

    /**
     * Initializes the rooms in the maze to be non-wall rooms.
     */
    private void initializeRooms() {
        for (int x = 0; x < MAZE_SIZE; x++) {
            for (int y = 0; y < MAZE_SIZE; y++) {
                myRooms[x][y] = new Room();
            }
        }
    }

    /**
     * Moves the player in the specified direction, if possible.
     *
     * @param theDirection The direction in which to move the player.
     * @return True if the player successfully moved, false otherwise.
     */
    public boolean movePlayer(Direction theDirection) {
        // Get the current coordinates of the player
        int newX = myPlayer.getX();
        int newY = myPlayer.getY();

        // Check if the desired direction is valid and within the maze bounds
        if (theDirection == Direction.N && newY > 0) {
            // If moving North is valid, update the new Y coordinate accordingly
            newY--;
        } else if (theDirection == Direction.S && newY < MAZE_SIZE - 1) {
            // If moving South is valid, update the new Y coordinate accordingly
            newY++;
        } else if (theDirection == Direction.E && newX < MAZE_SIZE - 1) {
            // If moving East is valid, update the new X coordinate accordingly
            newX++;
        } else if (theDirection == Direction.W && newX > 0) {
            // If moving West is valid, update the new X coordinate accordingly
            newX--;
        } else {
            // If the desired direction is invalid or beyond the maze bounds,
            // print a message and return false (indicating the move is not successful)
            //System.out.println("You cannot move further in that direction. You are at the edge of the maze.");
            return false;
        }

        // Check if the destination cell is not a wall (i.e., it's a valid move)
        if (!myRooms[newX][newY].isWall()) {
            // If the destination cell is not a wall, update the player's position
            myPlayer.setX(newX);
            myPlayer.setY(newY);
            return true; // Return true to indicate that the move is successful
        } else {
            // If the destination cell is a wall, print a message and return false
            // (indicating that the move is not successful)
            //System.out.println("You cannot move further in that direction. You hit a wall.");
            return false;
        }
    }


    /**
     * Locks all doors in the maze except for the one the player entered from.
     * This method is called when the player answers three questions incorrectly.
     * The player will be forced to answer questions correctly to proceed.
     * This method is called from the incrementIncorrectAnswerCount() method.
     */
    public void lockAllDoors() {
        for (Direction direction : Direction.values()) {
            int x = myPlayer.getX();
            int y = myPlayer.getY();

            switch (direction) {
                case N:
                    if (y > 0) y--;
                    break;
                case S:
                    if (y < MAZE_SIZE - 1) y++;
                    break;
                case E:
                    if (x < MAZE_SIZE - 1) x++;
                    break;
                case W:
                    if (x > 0) x--;
                    break;
            }

            if (myRooms[x][y] != null && !myRooms[x][y].isWall()) {
                myRooms[x][y].setWall(true);
            }
        }
    }

    /**
     * Checks if the player has reached the exit of the maze.
     *
     * @return True if the player has reached the exit, false otherwise.
     */
    public boolean isExitReached() {
        return myPlayer.getX() == MAZE_SIZE - 1 && myPlayer.getY() == MAZE_SIZE - 1;
    }

    /**
     * Returns a string representation of the maze.
     *
     * @return A string representation of the maze.
     */
    @Override
    public String toString() {
        StringBuilder mazeString = new StringBuilder();
        for (int y = 0; y < MAZE_SIZE; y++) {
            for (int x = 0; x < MAZE_SIZE; x++) {
                if (x == myPlayer.getX() && y == myPlayer.getY()) {
                    mazeString.append("[PLYR]");
                } else if (x == MAZE_SIZE - 1 && y == MAZE_SIZE - 1) {
                    mazeString.append("[FNSH]");
                } else if (myRooms[x][y].isWall()) {
                    mazeString.append("[WALL]");
                } else {
                    mazeString.append("[Maze]");
                }
            }
            mazeString.append("\n");
        }
        return mazeString.toString();
    }


    /**
     * Returns the player object.
     *
     * @return The player object.
     */
    public Player getPlayer() {
        return myPlayer;
    }

}

