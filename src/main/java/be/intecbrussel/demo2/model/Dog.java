package be.intecbrussel.demo2.model;

public class Dog {
    private int id;
    private String name;
    private int ownerId;

    public Dog(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void pet(){
        System.out.println("Doggo is pet, doggo is happy.");
    }
}
