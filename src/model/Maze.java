package src.model;

import java.util.Random;

/**
 * The Maze class represents the main game environment where the player navigates.
 */
public class Maze {
    private static final int MAZE_SIZE = 5;

    private Player player;
    private final Room[][] rooms;

    /**
     * Constructs a new Maze object with a default size.
     */
    public Maze() {
        player = new Player();
        rooms = new Room[MAZE_SIZE][MAZE_SIZE];
        initializeRooms();
    }

    public Player getPlayer() {
        return player;
    }

    /**
     * Initializes the rooms in the maze to be non-wall rooms.
     */
    private void initializeRooms() {
        for (int x = 0; x < MAZE_SIZE; x++) {
            for (int y = 0; y < MAZE_SIZE; y++) {
                rooms[x][y] = new Room();
            }
        }
    }

    /**
     * Moves the player in the specified direction, if possible.
     *
     * @param direction The direction in which to move the player.
     * @return True if the player successfully moved, false otherwise.
     */
    public boolean movePlayer(Direction direction) {
        int newX = player.getX();
        int newY = player.getY();

        if (direction == Direction.N && newY > 0) {
            newY--;
        } else if (direction == Direction.S && newY < MAZE_SIZE - 1) {
            newY++;
        } else if (direction == Direction.E && newX < MAZE_SIZE - 1) {
            newX++;
        } else if (direction == Direction.W && newX > 0) {
            newX--;
        } else {
            System.out.println("You cannot move further in that direction. You are at the edge of the maze.");
            return false;
        }

        if (!rooms[newX][newY].isWall()) {
            player.setX(newX);
            player.setY(newY);
            return true;
        } else {
            System.out.println("You cannot move further in that direction. You hit a wall.");
            return false;
        }
    }

    /**
     * Checks if the player has reached the exit of the maze.
     *
     * @return True if the player has reached the exit, false otherwise.
     */
    public boolean isExitReached() {
        return player.getX() == MAZE_SIZE - 1 && player.getY() == MAZE_SIZE - 1;
    }

    /**
     * Randomly generates walls in the maze, except for the start and finish positions.
     */
    public void generateMaze() {
        // Randomly create walls in the maze (except the start and finish positions)
        Random random = new Random();
        for (int x = 1; x < MAZE_SIZE - 1; x++) {
            for (int y = 1; y < MAZE_SIZE - 1; y++) {
                if (random.nextBoolean()) {
                    rooms[x][y].setWall(true);
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder mazeString = new StringBuilder();
        for (int y = 0; y < MAZE_SIZE; y++) {
            for (int x = 0; x < MAZE_SIZE; x++) {
                if (x == player.getX() && y == player.getY()) {
                    mazeString.append("[PLYR]");
                } else if (x == MAZE_SIZE - 1 && y == MAZE_SIZE - 1) {
                    mazeString.append("[FNSH]");
                } else if (rooms[x][y].isWall()) {
                    mazeString.append("[WALL]");
                } else {
                    mazeString.append("[ROOM]");
                }
            }
            mazeString.append("\n");
        }
        return mazeString.toString();
    }

    /**
     * Represents a room in the maze.
     */
    private static class Room {
        private boolean wall;

        /**
         * Constructs a new non-wall room.
         */
        public Room() {
            wall = false;
        }

        /**
         * Checks if the room is a wall.
         *
         * @return True if the room is a wall, false if it is a non-wall room.
         */
        public boolean isWall() {
            return wall;
        }

        /**
         * Sets the room to be a wall or a non-wall.
         *
         * @param wall True if the room should be a wall, false if it should be a non-wall room.
         */
        public void setWall(boolean wall) {
            this.wall = wall;
        }
    }
}
