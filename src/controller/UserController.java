package src.controller;

import src.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class is responsible for user management, including creating a new user
 * and fetching the current user.
 *
 * @author yaxyeM, HyunJ, ShuaibA
 * @version Summer 2023
 */
public class UserController {

    private List<User> users = new ArrayList<>();
    private User currentUser;

    public UserController() {
        // TODO: Fetch users from a database or a file if needed
    }

    public User createNewUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();
        User newUser = new User(userName);
        users.add(newUser);
        setCurrentUser(newUser);

        return newUser;
    }

    public User getCurrentUser() {
        if (currentUser == null) {
            createNewUser();
        }
        return currentUser;
    }

    public void setCurrentUser(User user) {
        currentUser = user;
    }

}
