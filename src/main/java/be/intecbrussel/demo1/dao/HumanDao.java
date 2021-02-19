package be.intecbrussel.demo1.dao;

import be.intecbrussel.demo1.model.Human;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HumanDao {
    private String url;
    private String username;
    private String password;

    public void saveHuman(Human human) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            String query = String.format("insert into human (name, lastname, gender) values('%s', '%s', '%s')", human.getName(), human.getLastName(), human.getGender());
            statement.execute(query);
        }

    }

    public void config(String url, String username, String password) {

        this.url = url;
        this.username = username;
        this.password = password;
    }

    public List<Human> getAllHumans() throws SQLException {

        List<Human> humans = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            String query ="select * from human";
            statement.execute(query);

            ResultSet rs = statement.executeQuery(query);

            while (rs.next()){
                Human human = new Human(rs.getString("name"),
                                        rs.getString("lastname"),
                                        rs.getString("gender"));
                humans.add(human);
            }
        }
        return humans;
    }
}
