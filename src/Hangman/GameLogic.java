package Hangman;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameLogic {
    private Scanner scn = new Scanner(System.in);
    private Random rnd = new Random();
    private String[] secretWordArr = {"java", "javascript","kotlin","python"};
    private String secretWord = secretWordArr[rnd.nextInt(secretWordArr.length)];
    private StringBuilder currentSecretWord = new StringBuilder(secretWord);
    private int userHealth = 8;
    public void greeting(){
        System.out.println("HANGMAN");
    }

    public void gameAction(){
        greeting();
        System.out.println(currentSecretWord.replace(0,secretWord.length(),
                new String(new char[secretWord.length()]).replace("\0", "-")));
        while (userHealth!=0){
            System.out.print("Input a letter: ");
            String uInp = userInput();
            if (!isCorrect(uInp)) System.out.println("That letter doesn't appear in the word");
            ArrayList<Integer> allIndex = allGuessedIndex(uInp);
            System.out.println(hintMaker(uInp,allIndex));
            userHealth--;
        }
        System.out.println("Thanks for playing!\n" +
                "We'll see how well you did in the next stage\n");
    }
    private ArrayList<Integer> allGuessedIndex(String inp){
        int index = secretWord.indexOf(inp);
        ArrayList<Integer> allIndex = new ArrayList<>();
        while (index >= 0) {
            allIndex.add(index);
            index = secretWord.indexOf(inp, index + 1);
        }
        return allIndex;
    }
    private String hintMaker(String inp, ArrayList<Integer> index){
        if (!index.isEmpty())for (int curIndex : index)currentSecretWord.replace(curIndex,curIndex+1,inp);
        return currentSecretWord.toString();
    }
    private Boolean isCorrect(String inp){
        if (secretWord.contains(inp)) return Boolean.TRUE;
        else return Boolean.FALSE;
    }
    private String userInput(){
        System.out.print(">>> ");
        return scn.nextLine();
    }
}
