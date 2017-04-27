package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Sapir Michaeli on 15.03.2017.
 */
public class Input {

    private static final int INITIAL_STATE = 1;
    private static final int GET_PATH = 2;
    String input;
    private InputInterface inputInterface;

    public Input() {
    }

    public Input(InputInterface inputInterface) {
        this.inputInterface = inputInterface;
    }

    String getInitialInstructions(){
        return "please choose:\n 1. encryption\n 2. decryption\n type exit at any point to exit this program";
    }

     String getInputFromUser(){
        System.out.println("Enter your choice : \n 1- for encryption \n 2- for decryption ");
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        try {
            bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "exit";
    }

    /*String callProgramMenu(String choice) {
        while (choice.equals("exit") || programMenu(choice).equals("")) {
            getInitialInstructions();
            choice = getInputFromUser();
        }
        return choice;
    }*/

     String programMenu(){
        String outPut="";
        switch (input) {
            case "1":
                outPut= "decryption";
                break;
            case "2":
                outPut= "encryption";
                break;
        }
        return outPut;
    }

    public void inputInterface(){
        input=this.inputInterface.input();
    }

    // get path and check if exist and the path is correct
      void getPath() {
        System.out.println("Enter the absolute path ( Directory/File )"); // full path+ file name+ file type
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.next();
        File file = new File(filePath);
        if (file == null)
            getPath();

    }


    //input interface
    public static interface InputInterface{
        String input();
    }


}
