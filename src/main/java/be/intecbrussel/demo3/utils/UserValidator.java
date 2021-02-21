package be.intecbrussel.demo3.utils;

import be.intecbrussel.demo3.model.User;

public class UserValidator {
    public static boolean validateUserPassword(User user, String password) {
        return user.getPassword().equals(password);
    }
}