package Hangman;

import java.util.Random;
import java.util.Scanner;

public class GameLogic {
    private Scanner scn = new Scanner(System.in);
    private Random rnd = new Random();
    private String[] secretWordArr = {"java", "javascript","kotlin","python"};
    private String secretWord = secretWordArr[rnd.nextInt(secretWordArr.length)];
    public void greeting(){
        System.out.println("HANGMAN");
    }

    public void gameAction(){
        greeting();
        System.out.print(String.format("Guess the word %s: ",hintMaker(secretWord)));
        String uInp = userInput();
        if (isCorrect(uInp)) System.out.println("You survived!");
        else System.out.println("You lost!");
    }

    private String hintMaker(String inp){
        StringBuilder hint = new StringBuilder(inp);
        hint.replace(2,inp.length(),new String(new char[inp.length()-2]).replace("\0", "-"));
        return hint.toString();
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
