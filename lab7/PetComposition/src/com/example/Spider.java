package com.example;

public class Spider extends Animal {
    private Ambulatory ambulatory;

    public Spider() {
        super(8); // Assuming the Animal constructor takes the number of legs or similar parameter
        this.ambulatory = new AmbulatoryImpl(8);
    }

    @Override
    public void eat() {
        System.out.println("The spider eats a fly.");
    }

    // Implement the walk method that delegates to the Ambulatory instance
    @Override
    public void walk() {
        this.ambulatory.walk();
    }
}
