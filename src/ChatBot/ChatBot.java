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
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");
        int[] remainders=new int[3];
        for(int i=0; i < remainders.length;i++){
            remainders[i] = scn.nextInt();
        }
        int age = (remainders[0] * 70 + remainders[1] * 21 + remainders[2] * 15) % 105;
        System.out.println(String.format("Your age is %d; that's a good time to start programming!",age));
    }
}
