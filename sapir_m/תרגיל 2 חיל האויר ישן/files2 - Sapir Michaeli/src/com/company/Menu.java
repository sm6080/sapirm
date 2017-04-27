package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Sapir Michaeli on 28.02.2017.
 */
public class Menu {

    public static final String EXIT = "exit";


    public void menu() {
       /* String userInput=null;
        System.out.println(input.getInitialInstructions());
        while ((userInput = input.getInputFromUser()) != EXIT) {
          //  System.out.println(input.programMenu(userInput));
            userInput=input.programMenu(userInput);
            while (userInput.equals("")){
                //error message
                userInput=input.programMenu(userInput);
            }
        }*/
       Input input=new Input();

        Input inputMenu = new Input(new Input.InputInterface() {
            @Override
            public String input() {
                return input.getInputFromUser();
            }
        });

    }

}