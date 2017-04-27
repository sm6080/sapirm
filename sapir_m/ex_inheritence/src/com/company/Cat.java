package com.company;

/**
 * Created by Sapir Michaeli on 06.02.2017.
 */
public class Cat extends Animal{
    void howl(){
        System.out.println("cat- miyahuuuuuuuu");
    }


    @Override
    public void makeSound() {
       howl();
    }
}
