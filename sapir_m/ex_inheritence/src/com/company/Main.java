package com.company;

public class Main {

    public static void main(String[] args) {

        Animal a=new Dog();
        a.makeSound(); //dog- whafhaf
        Dog d=new Dog();
        d.bark(); //dog- whafhaf
        Poodle p=new Poodle();
        p.bark(); //poodle- whafhaf

        Animal b=new Poodle();
        b.makeSound();//poodle- whafhaf
        //b.bark()  //אי אפשר כי המתודות הן של המצביע
        //Cat c=new Dog() //אסור

    }
}
