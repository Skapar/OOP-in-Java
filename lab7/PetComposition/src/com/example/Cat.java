package com.example;

public class Cat extends Animal implements Pet {

    private Nameable nameable = new NameableImpl();

    private Ambulatory ambulatory;
    public Cat() {
        super(4); // Cats have 4 legs
        nameable.setName("Fluffy");
    }

    public Cat(String name) {
        super(4); // Cats have 4 legs
        nameable.setName(name);
    }

    @Override
    public void eat() {
        System.out.println("Cats like to eat spiders and fish.");
    }

    @Override
    public String getName() {
        return nameable.getName();
    }

    @Override
    public void setName(String name) {
        nameable.setName(name);
    }

    @Override
    public void play() {
        System.out.println(getName() + " likes to play with string.");
    }
}
