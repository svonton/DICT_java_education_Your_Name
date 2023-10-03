package Hangman;

import java.util.Scanner;

public class Hangman {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        while (true){
            System.out.print("Type \"play\" to play the game, \"exit\" to quit: ");
            String uInp = scn.nextLine();
            if(uInp.equals("play")){
                GameLogic gameLogic = new GameLogic();
                gameLogic.gameAction();
            }
            else if (uInp.equals("exit"))break;
        }
    }
}
