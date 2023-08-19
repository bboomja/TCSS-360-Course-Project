package src.Test;

import src.model.Maze;
import src.model.Direction;
import src.model.Player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MazeTest {

    private Maze maze;

    @BeforeEach
    void setUp() {
        maze = new Maze();
    }

    @Test
    void testMovePlayerValidDirections() {
        // Initially, player is at (0, 0)
        Player player = maze.getPlayer();
        assertEquals(0, player.getX());
        assertEquals(0, player.getY());

        assertTrue(maze.movePlayer(Direction.E));
        assertEquals(1, player.getX());
        assertEquals(0, player.getY());

        assertTrue(maze.movePlayer(Direction.S));
        assertEquals(1, player.getX());
        assertEquals(1, player.getY());
    }

    @Test
    void testMovePlayerInvalidDirections() {

        assertFalse(maze.movePlayer(Direction.N));
        assertFalse(maze.movePlayer(Direction.W));
    }

    @Test
    void testLockAllDoors() {
        maze.lockAllDoors();
        Player player = maze.getPlayer();

        // After locking all doors, player should be unable to move in any direction
        assertFalse(maze.movePlayer(Direction.N));
        assertFalse(maze.movePlayer(Direction.E));
        assertFalse(maze.movePlayer(Direction.S));
        assertFalse(maze.movePlayer(Direction.W));

        // Player's position should still be (0, 0)
        assertEquals(0, player.getX());
        assertEquals(0, player.getY());
    }

    @Test
    void testIsExitReached() {
        Player player = maze.getPlayer();
        // Manually set player's position to the exit (bottom-right corner)
        player.setX(3);
        player.setY(3);

        assertTrue(maze.isExitReached());
    }


    @Test
    void testToString() {
        // Test the string representation
        String initialRepresentation =
                "[PLYR][Maze][Maze][Maze]\n[Maze][Maze][Maze][Maze]\n[Maze][Maze][Maze][Maze]\n[Maze][Maze][Maze][FNSH]\n";
        assertEquals(initialRepresentation, maze.toString());
    }
}
