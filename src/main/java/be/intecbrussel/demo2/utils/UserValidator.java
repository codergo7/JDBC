package be.intecbrussel.demo2.utils;

import be.intecbrussel.demo2.model.User;

public class UserValidator {
    public static boolean validateUserPassword(User user, String password) {
        return user.getPassword().equals(password);
    }
}