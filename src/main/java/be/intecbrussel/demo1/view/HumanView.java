package be.intecbrussel.demo1.view;

import be.intecbrussel.demo1.dao.HumanDao;
import be.intecbrussel.demo1.model.Human;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class HumanView {

    private static final HumanDao humanDao = new HumanDao();

    public static void displayMainMenu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the human app, where you might save humans!");
        System.out.println("You will now be asked to input data of a human! \n");

        while (true){

            System.out.println("\n What is its name?");
            String name = scanner.nextLine();

            System.out.println("What is its last name?");
            String lastName = scanner.nextLine();

            System.out.println("What is its gender?");
            String gender = scanner.nextLine();



            Human human = new Human(name, lastName, gender);

            try {
                humanDao.saveHuman(human);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            System.out.println("Enter 1: to quit, 2: to add nem human, 3: to display all humans");
            String command = scanner.nextLine();
            if (command.equals("1")){
                break;
            } else if(command.equals("3")){
                displayAllExistingHumans();
                break;
            }
        }


        scanner.close();

    }

    public static void displayAllExistingHumans(){
        try {
            List<Human> humanList = humanDao.getAllHumans();
            humanList.forEach(System.out::println);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void credentialOfDatabase(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter credential of the database");

        System.out.println("Enter URL: ");
        String url = scanner.nextLine();

        System.out.println("Enter port number: ");
        String port = scanner.nextLine();

        System.out.println("Enter the name of the database: ");
        String db = scanner.nextLine();

        System.out.println("Enter username: ");
        String username = scanner.nextLine();

        System.out.println("Enter password");
        String password = scanner.nextLine();

        humanDao.config(String.format("jdbc:mysql://%s:%s/%s", url, port, db), username, password);
    }
}
