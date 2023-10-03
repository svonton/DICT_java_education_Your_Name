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
    private ArrayList<String> alreadyGuessedLetter = new ArrayList<>();
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
            if (isCorrect(uInp)) {
                if(secretWord.contains(uInp)){
                    ArrayList<Integer> allIndex = allGuessedIndex(uInp);
                    alreadyGuessedLetter.add(uInp);
                    System.out.println(hintMaker(uInp,allIndex));
                }else {
                    System.out.println("That letter doesn't appear in the word");
                    alreadyGuessedLetter.add(uInp);
                    userHealth--;
                }
            }
            if(currentSecretWord.toString().equals(secretWord)){
                System.out.println(String.format("You guessed the word %s",secretWord));
                System.out.println("You survived!");
                break;
            }
        }
        if(!currentSecretWord.toString().equals(secretWord))System.out.println("You lost!");
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
        if (inp.length()>1){
            System.out.println("You should input a single letter");
            return Boolean.FALSE;
        }
        if (!Character.isLowerCase(inp.charAt(0))){
            System.out.println("Please enter a lowercase English letter.");
            return Boolean.FALSE;
        }
        if (alreadyGuessedLetter.contains(inp)){
            System.out.println("You've already guessed this letter");
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
    private String userInput(){
        System.out.print(">>> ");
        return scn.nextLine();
    }
}
