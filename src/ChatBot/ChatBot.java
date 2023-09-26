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
        System.out.println("Now I will prove to you that I can count to any number you want!");
        int userInpMaxNumber = scn.nextInt();
        for (int i=0;i<userInpMaxNumber+1;i++){
            System.out.println(String.format("%d !",i));
        }
        System.out.println("""
                Choose correct answer!
                1. Wrong answer
                2. Wrong answer
                3. Correct answer
                4. Wrong answer""");
        int userQuestAnswer = 0;
        while (userQuestAnswer!=3){
            userQuestAnswer = scn.nextInt();
            if (userQuestAnswer == 3) System.out.println("Correct");
            else System.out.println("Wrong");
        }
        System.out.println("Goodbye, have a nice day!");
    }
}
