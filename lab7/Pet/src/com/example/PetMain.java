package com.example;

public abstract class PetMain {

    public static void main(String[] args) {
        Animal a;
        //test a spider with a spider reference
        Spider s = new Spider();
        s.eat();
        s.walk();
        //test a spider with an animal reference
        a = new Spider();
        a.eat();
        a.walk();

        System.out.println('\n');

        Pet p;
        Cat c = new Cat("Tom");
        c.eat();
        c.walk();
        c.play();
        a  = new Cat();
        a.eat();
        a.walk();
        p = new Cat();
        p.setName("Mr. Whiskers");
        p.play();

        System.out.println('\n');


        Fish f = new Fish();
        f.setName("Guppy");
        f.eat();
        f.walk();
        f.play();
        a = new Fish();
        a.eat();
        a.walk();
        System.out.println('\n');

        playWithAnimal(s);
        playWithAnimal(c);
        playWithAnimal(f);
    }
    
    public static void playWithAnimal(Animal a) {
        if(a instanceof Pet){
            Pet p = (Pet) a;
            p.play();
        }else{
            System.out.println("Danger! Wild Animal");
        }
    }

    public abstract String getName();


}