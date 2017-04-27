package com.company;

/**
 * Created by Sapir Michaeli on 06.02.2017.
 */
public class Poodle extends Dog {
    @Override
    public void makeSound() {
        bark();
    }

    @Override
    public void bark() {
        System.out.println("poodle- whafhaf");

    }
}
