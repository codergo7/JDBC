package be.intecbrussel.demo3.data;

import be.intecbrussel.demo3.model.User;

import java.sql.*;

public class UserDAO {
    private final String url = "jdbc:mysql://moktok.javawebdev.com:33061/gokhan";
    private String user;
    private String password;

    public void saveUser(User user) throws SQLException {
        String query = "INSERT INTO user (id, username, password) VALUES (?,?,?)";
       // User user = null;

        try (Connection connection = DriverManager.getConnection(url, this.user, password);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, 0);
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());


            statement.executeUpdate();


           // user = new User(usernameFromDB, password);

        }
    }

    public User getUser(String username) throws SQLException {
        String query = "SELECT * FROM user WHERE username LIKE ?";
        User user = null;

        try (Connection connection = DriverManager.getConnection(url, this.user, password);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, username);

            ResultSet rs = statement.executeQuery();
            rs.next();
            String usernameFromDB = rs.getString("username");
            String password = rs.getString("password");

            user = new User(usernameFromDB, password);

        }

        return user;
    }

    public void setConfig(String user, String password) {
        this.user = user;
        this.password = password;
    }
}