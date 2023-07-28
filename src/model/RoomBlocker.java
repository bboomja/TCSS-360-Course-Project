package src.model;

import src.model.Direction;

import java.util.EnumMap;

/**
 * RoomBlocker is a container for a boolean for every direction on a compass.
 */
public class RoomBlocker {
    private final EnumMap<Direction, Boolean> blockers;

    /**
     * Creates a new RoomBlocker.
     *
     * @param theNorth North Boolean
     * @param theSouth South Boolean
     * @param theEast  East Boolean
     * @param theWest  West Boolean
     */
    public RoomBlocker(final boolean theNorth, final boolean theSouth,
                       final boolean theEast, final boolean theWest) {
        blockers = new EnumMap<>(Direction.class);
        blockers.put(Direction.N, theNorth);
        blockers.put(Direction.S, theSouth);
        blockers.put(Direction.E, theEast);
        blockers.put(Direction.W, theWest);
    }

    /**
     * Returns boolean corresponding to the specified direction.
     *
     * @param direction Direction enum
     * @return Returns the boolean value for the specified direction
     */
    public boolean isBlocked(final Direction direction) {
        return blockers.getOrDefault(direction, false);
    }
}
