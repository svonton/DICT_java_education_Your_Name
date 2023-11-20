package CurrencyExchange;

import java.util.Scanner;

public class CurrencyExchange {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        CurrencyLogic currencyLogic = new CurrencyLogic();
        currencyLogic.start();
        while (currencyLogic.isRunning()){
            currencyLogic.printUI();
            if(!(currencyLogic.getCurrentState() == CurrencyLogicState.PRINT_RESULT)){
                String uInp = scanner.nextLine();
                currencyLogic.inputProcessing(uInp);
            }
        }
    }
}
