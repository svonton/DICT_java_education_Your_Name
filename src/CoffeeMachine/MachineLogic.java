package CoffeeMachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MachineLogic {
    Scanner scn = new Scanner(System.in);
    private int reqWater = 200;
    private int reqMilk = 50;
    private int reqCoffeeBeans = 15;
    public void Greetings(){
        System.out.println("Starting to make a coffee\n" +
                "Grinding coffee beans\n" +
                "Boiling water\n" +
                "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" +
                "Pouring some milk into the cup\n" +
                "Coffee is ready!");
    }
    private void calcCups(){
        System.out.println("Write how many cups of coffee you will need:");
        Integer uInp = Integer.parseInt(userInput());
        System.out.println(String.format("For %d cups of coffee you will need:\n" +
                "%d ml of water\n" +
                "%d ml of milk\n" +
                "%d g of coffee beans",uInp,uInp*reqWater,uInp*reqMilk,uInp*reqCoffeeBeans));
    }
    private void caclPossibleCups(){
        ArrayList<Integer> minPossibleCup = new ArrayList<>();
        System.out.println("Write how many ml of water the coffee machine has:");
        Integer waterAmount = Integer.parseInt(userInput());
        System.out.println("Write how many ml of milk the coffee machine has:");
        Integer milkAmount = Integer.parseInt(userInput());
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        Integer beansAmount = Integer.parseInt(userInput());
        System.out.println("Write how many cups of coffee you will need:");
        Integer cupsAmount = Integer.parseInt(userInput());
        minPossibleCup.add(waterAmount/reqWater);
        minPossibleCup.add(milkAmount/reqMilk);
        minPossibleCup.add(beansAmount/reqCoffeeBeans);
        Integer min_cups = Collections.min(minPossibleCup);

        if(cupsAmount.equals(min_cups)) System.out.println("Yes, I can make that amount of coffee");
        if(cupsAmount < min_cups) System.out.println("Yes, I can make that amount of coffee (and even "
                +(min_cups-cupsAmount)+" more than that)");
        if(cupsAmount > min_cups) System.out.println("No, I can make only "
                +min_cups+" cups of coffee");
    }
    public void machineAction(){
        caclPossibleCups();
    }

    private String userInput(){
        System.out.print(">>> ");
        return scn.nextLine();
    }
}
