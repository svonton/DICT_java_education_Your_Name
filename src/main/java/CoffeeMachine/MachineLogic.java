package CoffeeMachine;

public class MachineLogic {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int cups;
    private int money;
    public boolean exitStatus;
    public String currentStatus;
    private int fillStage;
    public MachineLogic(){
        this.milk = 540;
        this.coffeeBeans = 120;
        this.water = 400;
        this.cups = 9;
        this.money = 550;
        this.exitStatus = false;
        this.currentStatus = "Awake";
        invMainMenu();
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
            System.out.println("I have enough resources, making you a coffee!");
        }
        invMainMenu();
        this.currentStatus = "Awake";
    }
    private void buyMenu(String outsideInput){
        if(outsideInput.equals("back")){currentStatus = "Awake";invMainMenu();return;}
        int uCoffeeType = Integer.parseInt(outsideInput);
        switch (uCoffeeType) {
            case 1 -> coffeeCook(250,0,16,4);
            case 2 -> coffeeCook(350,75,20,7);
            case 3 -> coffeeCook(200,100,12,6);
            default -> System.out.println(String.format("Unknown coffee type: %d",uCoffeeType));
        }
    }
    private void fillAction(String outsideInput){
        switch (fillStage) {
            case 1 -> {System.out.println("Write how many ml of milk you want to add:");
                water += Integer.parseInt(outsideInput);fillStage = 2;}
            case 2 -> {System.out.println("Write how many grams of coffee beans you want to add:");
                milk += Integer.parseInt(outsideInput); fillStage = 3;}
            case 3 -> {System.out.println("Write how many cups you want to add:");
                coffeeBeans += Integer.parseInt(outsideInput); fillStage = 4;}
            case 4 -> {
                cups += Integer.parseInt(outsideInput); fillStage =0; currentStatus = "Awake";
                invMainMenu();}
        }
    }
    private void takeAction(){
        System.out.println(String.format("I gave you %d uah", money));
        money -= money;
        invMainMenu();
    }
    private void remainingResources(){
        System.out.println(String.format("""
                The coffee machine has:
                %d of water
                %d of milk
                %d of coffee beans
                %d of disposable cups
                %d of money""",water,milk,coffeeBeans,cups,money));
        invMainMenu();
    }
    private void buyInvMenu(){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back – to main menu:");
        currentStatus = "buy";
    }
    private void fillInvMenu(){
        currentStatus = "fill";
        fillStage = 1;
        System.out.println("Write how many ml of water you want to add:");
    }
    private void invMainMenu(){
        System.out.println("Write action (buy, fill, take, remaining, exit):");
    }
    public void updatedMachineAction(String outsideInput){
        if(currentStatus.equals("buy"))buyMenu(outsideInput);
        else if (currentStatus.equals("fill")) fillAction(outsideInput);
        else{
            switch (outsideInput) {
                case "buy" -> buyInvMenu();
                case "fill" -> fillInvMenu();
                case "take" -> takeAction();
                case "remaining" -> remainingResources();
                case "exit" -> exitStatus=true;
                default -> System.out.println(String.format("Unknown command: %s",outsideInput));
            }
        }
    }
}
