package src.model;

/**
 * This class represents a user.
 * It stores the user's name and any other properties related to a user.
 *
 * @author yaxyeM, HyunJ, ShuaibA
 * @version Summer 2023
 */
public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
