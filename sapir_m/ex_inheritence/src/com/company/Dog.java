package com.company;

/**
 * Created by Sapir Michaeli on 06.02.2017.
 */
public class Dog extends Animal {

    @Override
    public void makeSound() {
        bark();
    }
    public void bark(){
        System.out.println("dog- whafhaf");

    }
}
