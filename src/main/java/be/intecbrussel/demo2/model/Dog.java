package be.intecbrussel.demo2.model;

public class Dog {
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

    public void pet(){
        System.out.println(name + " is pet, " + name +" is happy.");
    }
}
