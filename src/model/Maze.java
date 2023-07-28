package src.model;

/**
 * The Maze class represents the main game environment where the player navigates.
 */
public class Maze {
    private static final int NORTH_DOOR_INDEX = 0;
    private static final int SOUTH_DOOR_INDEX = 1;
    private static final int EAST_DOOR_INDEX = 2;
    private static final int WEST_DOOR_INDEX = 3;

    private int myX;
    private int myY;
    private final Room[][] myMaze;
    private final int mazeSize;

    public Maze(final int size) {
        mazeSize = size;
        myX = 0;
        myY = 0;
        myMaze = new Room[mazeSize][mazeSize];
        roomSetup();
    }

    public int getX() {
        return myX;
    }

    public int getY() {
        return myY;
    }

    public void setX(final int x) {
        myX = x;
    }

    public void setY(final int y) {
        myY = y;
    }

    private void roomSetup() {
        for (int xMazeCoord = 0; xMazeCoord < myMaze.length; xMazeCoord++) {
            for (int yMazeCoord = 0; yMazeCoord < myMaze[xMazeCoord].length; yMazeCoord++) {
                assignDoorsAndRoom(xMazeCoord, yMazeCoord);
            }
        }
    }

    private void assignDoorsAndRoom(int xMazeCoord, int yMazeCoord) {
        boolean west = xMazeCoord - 1 >= 0;
        boolean south = yMazeCoord < myMaze[xMazeCoord].length - 1;
        boolean east = xMazeCoord < myMaze.length - 1;
        boolean north = yMazeCoord > 0;

        Door northDoor = north ? myMaze[xMazeCoord][yMazeCoord - 1].getDoor(Direction.S) : new Door();
        Door southDoor = new Door();
        Door eastDoor = new Door();
        Door westDoor = west ? myMaze[xMazeCoord - 1][yMazeCoord].getDoor(Direction.E) : new Door();

        myMaze[xMazeCoord][yMazeCoord] =
                new Room(new RoomBlocker(north, south, east, west),
                        northDoor, southDoor, eastDoor, westDoor);
    }

    public void movePlayer(final Direction direction) {
        if (canMovePlayer(direction)) {
            switch (direction) {
                case N -> myY--;
                case S-> myY++;
                case E -> myX++;
                case W-> myX--;
            }
        }
    }

    public boolean canMovePlayer(final Direction direction) {
        Door localDoor = getCurrentRoom().getDoor(direction);
        return localDoor != null && !localDoor.isDead();
    }

    public Room getCurrentRoom() {
        return myMaze[myX][myY];
    }

    public boolean isPossible() {
        for (Room[] rooms : myMaze) {
            for (Room room : rooms) {
                room.setVisited(false);
            }
        }
        return isPossibleHelper(myX, myY);
    }

    private boolean isPossibleHelper(final int x, final int y) {
        if (!myMaze[x][y].getVisited()) {
            if (x == mazeSize - 1 && y == mazeSize - 1) {
                return true;
            }
            myMaze[x][y].setVisited(true);
            for (int directionIndex = 0; directionIndex < 4; directionIndex++) {
                if (isValidMove(x, y, directionIndex)) {
                    if (isPossibleHelper(newX(x, directionIndex), newY(y, directionIndex))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isValidMove(int x, int y, int directionIndex) {
        Direction direction = convertToDirection(directionIndex);
        Door door = myMaze[x][y].getDoor(direction);
        return door != null && !door.isDead();
    }


    private Direction convertToDirection(int directionIndex) {
        switch (directionIndex) {
            case 0: return Direction.N;
            case 1: return Direction.S;
            case 2: return Direction.E;
            case 3: return Direction.W;
            default: throw new IllegalArgumentException("Invalid direction index");
        }
    }


    private int newX(int x, int directionIndex) {
        return switch (directionIndex) {
            case EAST_DOOR_INDEX -> x + 1;
            case WEST_DOOR_INDEX -> x - 1;
            default -> x;
        };
    }

    private int newY(int y, int directionIndex) {
        return switch (directionIndex) {
            case NORTH_DOOR_INDEX -> y - 1;
            case SOUTH_DOOR_INDEX -> y + 1;
            default -> y;
        };
    }

    public boolean goalReached() {
        return myX == mazeSize - 1 && myY == mazeSize - 1;
    }

    @Override
    public String toString() {
        StringBuilder mazeString = new StringBuilder();
        for (int i = 0; i < myMaze.length; i++) {
            mazeString.append("\n");
            for (int j = 0; j < myMaze[i].length; j++) {
                mazeString.append(getRoomString(i, j));
            }
        }
        return mazeString.toString();
    }

    private String getRoomString(int i, int j) {
        if (i == myY && j == myX) {
            return "[PLYR]";
        } else if (i == mazeSize - 1 && j == mazeSize - 1) {
            return "[FNSH]";
        } else if (i == 0 && j == 0) {
            return "[STRT]";
        } else {
            return "[ROOM]";
        }
    }

    public void moveToEnd() {
        setX(mazeSize - 1);
        setY(mazeSize - 1);
    }

    public void undeadAllRooms() {
        for (Room[] rooms : myMaze) {
            for (Room room : rooms) {
                room.undeadRoom();
            }
        }
    }
}
