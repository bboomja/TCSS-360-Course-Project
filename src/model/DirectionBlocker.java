package src.model;

import java.util.HashSet;
import java.util.Set;

/**
 * DirectionBlocker is a container for storing blocked directions in a HashSet.
 */
public class DirectionBlocker {
    private final Set<Direction> blockedDirections;

    /**
     * Creates a new DirectionBlocker with no blocked directions.
     */
    public DirectionBlocker() {
        blockedDirections = new HashSet<>();
    }

    /**
     * Sets the specified direction as blocked.
     *
     * @param direction The direction to block.
     */
    public void setBlocked(Direction direction) {
        blockedDirections.add(direction);
    }

    /**
     * Removes the specified direction from the blocked directions.
     *
     * @param direction The direction to unblock.
     */
    public void setUnblocked(Direction direction) {
        blockedDirections.remove(direction);
    }

    /**
     * Checks if the specified direction is blocked.
     *
     * @param direction The direction to check.
     * @return True if the direction is blocked, false otherwise.
     */
    public boolean isBlocked(Direction direction) {
        return blockedDirections.contains(direction);
    }
}
