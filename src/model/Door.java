package src.model;

/**
 * Door is obstacle for the player.
 * It can Opened  by having the player answer a question.
 */
public class Door {
    private DoorState doorState;

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
   private Question myQuestion;
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
    public void setDoorState(DoorState doorState) {
        this.myDoorState = doorState;
    }

    /**
     * Tries to unlock the door with a user answer.
     * If the answer is correct, the door state changes to UNLOCKED.
     * If the answer is wrong, the door state changes to DEAD.
     *
     * @param theUserAnswer Response that the user gives
     */

    private int failedAttempts = 0;
    private static final int MAX_FAILED_ATTEMPTS = 3;

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
     * Returns the question.
     *
     * @return Returns a String of the question
     */
   public String getQuestion() {
       return myQuestion.getQuestion();
   }

    /**
     * Returns the answer.
     *
     * @return the answer
     */
   public String getAnswer() {
       return myQuestion.getAnswer();
   }

    /**
     * Checks if the door is in DEAD state.
     *
     * @return true if the door is DEAD, false otherwise.
     */
    public boolean isDead() {
        return myDoorState.equals(DoorState.DEAD);
    }

    /**
     * Resets a dead door to the locked state.
     */
    public void reset() {
        myDoorState = DoorState.LOCKED;
    }

    /**
     * Locks the door.
     */
    public void lock() {
        this.doorState = DoorState.LOCKED;
    }

    /**
     * Unlocks the door.
     */
    public void unlock() {
        this.doorState = DoorState.UNLOCKED;
    }
}
