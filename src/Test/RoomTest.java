package src.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.model.Room;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RoomTest {

    private Room room;

    @BeforeEach
    public void setUp() {
        room = new Room();
    }

    @Test
    public void testDefaultConstructor() {
        assertFalse(room.isWall(), "By default, the room should not be a wall.");
    }

    @Test
    public void testSetWallTrue() {
        room.setWall(true);
        assertTrue(room.isWall(), "The room should be a wall after setting it as a wall.");
    }

    @Test
    public void testSetWallFalse() {
        room.setWall(true);  // First, set it as a wall.
        room.setWall(false); // Then, change it to be a non-wall.
        assertFalse(room.isWall(), "The room should not be a wall after setting it as a non-wall.");
    }
}
