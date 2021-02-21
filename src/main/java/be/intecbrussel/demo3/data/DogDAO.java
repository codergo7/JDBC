package be.intecbrussel.demo3.data;

import be.intecbrussel.demo3.model.Dog;
import be.intecbrussel.demo3.model.User;

import java.sql.*;

public class DogDAO {
    private final String url = "jdbc:mysql://moktok.javawebdev.com:33061/gokhan";

    private String username;
    private String password;

    public void saveDog(Dog dog, User user) throws SQLException {
        String query = "INSERT INTO dog (id, name, owner_id) VALUES (?, ?,?)";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, 0);
            statement.setString(2, dog.getName());
            statement.setInt(3, user.getId());


            statement.executeUpdate();
        }
    }

    public Dog getDogsByUser(User user) throws SQLException {

        String query = "SELECT * FROM dog WHERE owner_id LIKE ?";
        Dog dog;
        try(Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, user.getId());
            ResultSet rs = ps.executeQuery();

            dog = new Dog( rs.getString("name"));
        }


        return dog;
    }

    public void setConfig(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
