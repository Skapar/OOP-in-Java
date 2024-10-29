package com.example;

public class Cat extends Animal implements Pet{
    private String name;
    public Cat(String name){
        super(4);
        this.name = name;
    }

    public Cat(){
        this("Fluffy");
    }

    @Override
    public void play(){
        System.out.println(name+" Likes to play with string.");
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public void eat(){
        System.out.println("Cats like to eat spiders and fish.");
    }
}
