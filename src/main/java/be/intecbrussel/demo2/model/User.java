package be.intecbrussel.demo2.model;

public class User {
    // UNIQUE ID !!!
    private int id;
    private String username;
    private String password;
    private Dog doggo;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Dog getDoggo() {
        return doggo;
    }

    public void setDoggo(Dog doggo) {
        this.doggo = doggo;
    }
}
