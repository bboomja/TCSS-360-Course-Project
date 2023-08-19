package src.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.model.Player;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    private Player player;

    @BeforeEach
    public void setUp() {
        player = new Player();
    }

    @Test
    public void testDefaultConstructor() {
        assertEquals(0, player.getX());
        assertEquals(0, player.getY());
    }

    @Test
    public void testSetX() {
        player.setX(5);
        assertEquals(5, player.getX());
    }

    @Test
    public void testSetY() {
        player.setY(3);
        assertEquals(3, player.getY());
    }

    @Test
    public void testMoveToPrevPositionAfterSettingX() {
        player.setX(5);
        player.moveToPrevPosition();
        assertEquals(0, player.getX());
    }

    @Test
    public void testMoveToPrevPositionAfterSettingY() {
        player.setY(3);
        player.moveToPrevPosition();
        assertEquals(0, player.getY());
    }

    @Test
    public void testMultipleMoveUndo() {
        player.setX(5);
        player.setY(7);
        player.setX(8);
        player.setY(9);

        player.moveToPrevPosition();

        assertEquals(5, player.getX());
        assertEquals(7, player.getY());
    }
}
