package CoffeeMachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MachineLogic {
    Scanner scn = new Scanner(System.in);
    private int water;
    private int milk;
    private int coffeeBeans;
    private int cups;
    private int money;
    public MachineLogic(){
        this.milk = 540;
        this.coffeeBeans = 120;
        this.water = 400;
        this.cups = 9;
        this.money = 550;
    }
    private boolean isPossible(int uWater, int uMilk, int uCoffeeBeans){
        if (uWater>water){System.out.println("Please restore water");return false;}
        if (uMilk>milk){System.out.println("Please restore water");return false;}
        if (uCoffeeBeans>coffeeBeans){System.out.println("Please restore water");return false;}
        return true;
    }
    private void coffeeCook(int uWater, int uMilk, int uCoffeeBeans, int uMoney){
        if (isPossible(uWater,uMilk,uCoffeeBeans)){
            water -= uWater;
            coffeeBeans -= uCoffeeBeans;
            cups -= 1;
            milk -= uMilk;
            money += uMoney;
            remainingResources();
        }else{
            System.out.println("Canceled: not enough resources");
        }
    }
    private void buyMenu(){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int uCoffeeType = Integer.parseInt(userInput());
        switch (uCoffeeType) {
            case 1 -> coffeeCook(250,0,16,4);
            case 2 -> coffeeCook(350,75,20,7);
            case 3 -> coffeeCook(200,100,12,6);
            default -> System.out.println(String.format("Unknown coffee type: %d",uCoffeeType));
        }
    }
    private void fillAction(){
        System.out.println("\nWrite how many ml of water you want to add:");
        water += Integer.parseInt(userInput());
        System.out.println("Write how many ml of milk you want to add:");
        milk += Integer.parseInt(userInput());
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeBeans += Integer.parseInt(userInput());
        System.out.println("Write how many cups you want to add:");
        cups += Integer.parseInt(userInput());
        remainingResources();
    }
    private void takeAction(){
        System.out.println(String.format("I gave you %d uah", money));
        money -= money;
        remainingResources();
    }
    private void remainingResources(){
        System.out.println(String.format("""
                The coffee machine has:
                %d of water
                %d of milk
                %d of coffee beans
                %d of disposable cups
                %d of money""",water,milk,coffeeBeans,cups,money));
    }
    private void machineMenu(String uChoice){

        switch (uChoice) {
            case "buy" -> buyMenu();
            case "fill" -> fillAction();
            case "take" -> takeAction();
            case "remaining" -> remainingResources();
            default -> System.out.println(String.format("Unknown command: %s",uChoice));
        }
    }

    public void machineAction(){
        remainingResources();
        System.out.println("Write action (buy, fill, take):");
        machineMenu(userInput());
    }

    private String userInput(){
        System.out.print(">>> ");
        return scn.nextLine();
    }
}
