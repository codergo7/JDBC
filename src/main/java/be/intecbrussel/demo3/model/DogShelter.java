package be.intecbrussel.demo3.model;

public class DogShelter {
    public Dog adopt(String name) {
        return new Dog(name);
    }
}