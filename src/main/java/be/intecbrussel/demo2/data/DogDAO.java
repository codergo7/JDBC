package be.intecbrussel.demo2.data;

import be.intecbrussel.demo2.model.Dog;
import be.intecbrussel.demo2.model.User;

import java.sql.*;

public class DogDAO {
    private final String url = "jdbc:mysql://moktok.javawebdev.com:33061/gokhan";

    private String username;
    private String password;

    public void saveDog(Dog dog, User user) throws SQLException {
        String query = "INSERT INTO dog (name, owner_name) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, dog.getName());
            statement.setString(2, user.getUsername());

            statement.executeUpdate();
        }
    }

    public Dog getDog(User user) throws SQLException {

        String query = "SELECT * FROM dog WHERE owner_name LIKE ?";
        Dog dog;
        try(Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, user.getUsername());
            ResultSet rs = ps.executeQuery();
            rs.next();
            dog = new Dog( rs.getString("name"));
        }


        return dog;
    }

    public void setConfig(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
