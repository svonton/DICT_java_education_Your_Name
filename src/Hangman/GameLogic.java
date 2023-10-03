package Hangman;

import java.util.Scanner;

public class GameLogic {
    private Scanner scn = new Scanner(System.in);
    private String secretWord = "java";
    public void greeting(){
        System.out.println("HANGMAN");
    }

    public void gameAction(){
        greeting();
        System.out.print("Guess the word: ");
        String uInp = userInput();
        if (isCorrect(uInp)) System.out.println("You survived!");
        else System.out.println("You lost!");
    }

    private Boolean isCorrect(String inp){
        if (inp.contains(secretWord)) return Boolean.TRUE;
        else return Boolean.FALSE;
    }
    private String userInput(){
        System.out.print(">>> ");
        return scn.nextLine();
    }
}
