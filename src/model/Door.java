package src.model;

/**
 * Door is obstacle for the player.
 * It can be Opened  by having the player answer a question.
 */
public class Door {
    public static final int MAX_FAILED_ATTEMPTS = 3;
    private static int failedAttempts = 0;

    /**
     * The Question and answer of the door.
     */

    public enum DoorState {
       LOCKED,
       UNLOCKED,
       DEAD,
        WALL
   }

    /**
     * The Question and answer of the door.
     */
   final private Question myQuestion;
    /**
     * Variable for the status of the Door.
     */
   private DoorState myDoorState;

    /**
     * Creates a new Door.
     */
   public Door() {
       myDoorState = DoorState.LOCKED;
       myQuestion = Database.getRandomQuestion();
   }

    /**
     * Returns the state of the door.
     *
     * @return Returns a DoorState enum of the state of the Door
     */
   public DoorState getDoorState() {
       return myDoorState;
   }

    public static int getFailedAttempts() {
        return failedAttempts;
    }

    public void attemptUnlock(final String theUserAnswer) {
        if (myDoorState == DoorState.LOCKED && theUserAnswer.equalsIgnoreCase(myQuestion.getAnswer())) {
            myDoorState = DoorState.UNLOCKED;
        } else {
            failedAttempts++;
            if (failedAttempts >= MAX_FAILED_ATTEMPTS) {
                myDoorState = DoorState.WALL;
            } else {
                myDoorState = DoorState.DEAD;
            }
        }
    }

    /**
     * Resets a dead door to the locked state.
     */
    public void reset() {
        myDoorState = DoorState.LOCKED;
    }

}
