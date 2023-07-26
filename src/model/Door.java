package src.model;

/**
 * Door is obstacle for the player.
 * It can opened by havinf the player answer a question.
 */
public class Door {
   public enum DoorState {
       LOCKED,
       UNLOCKED,
       DEAD
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

    /**
     * Tries to unlock the door with a user answer.
     * If the answer is correct, the door state changes to UNLOCKED.
     * If the answer is wrong, the door state changes to DEAD.
     *
     * @param theUserAnswer Response that the user gives
     */
   public void attemptUnlock(final String theUserAnswer) {
       if (myDoorState == DoorState.LOCKED && theUserAnswer.equalsIgnoreCase(myQuestion.getAnswer())) {
           myDoorState = DoorState.UNLOCKED;
       } else {
           myDoorState = DoorState.DEAD;
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
     * Resets a dead door to the locked state.
     */
   public void reset() {
       if (myDoorState == DoorState.DEAD) {
           myDoorState = DoorState.LOCKED;
       }
   }
}
