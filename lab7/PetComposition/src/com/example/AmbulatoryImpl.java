package com.example;

public class AmbulatoryImpl implements Ambulatory {
    private int legs; // Private int field called legs

    // Single argument constructor that receives an int value to be stored in the legs field
    public AmbulatoryImpl(int legs) {
        this.legs = legs;
    }

    // Implement the walk method from the Ambulatory interface
    @Override
    public void walk() {
        // Print a message that uses the legs field
        System.out.println("This animal walks on " + legs + " legs.");
    }
}
