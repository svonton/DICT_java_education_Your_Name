package ChatBot;


import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.println("Hello! My name is MyBot.\n" +
                "I was created in 2023.");
        System.out.println("Please, remind me your name.");
        String userName = scn.nextLine();
        System.out.println(String.format("What a great name you have, %s!",userName));
    }
}
