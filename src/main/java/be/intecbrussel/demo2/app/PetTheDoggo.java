package be.intecbrussel.demo2.app;

import be.intecbrussel.demo2.view.CuiView;

import java.sql.SQLException;

public class PetTheDoggo {

    public static void main(String[] args) {
        CuiView cv = new CuiView();
        try {
            cv.start();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
