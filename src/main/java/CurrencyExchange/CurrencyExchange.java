package CurrencyExchange;

import org.json.JSONException;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class CurrencyExchange {
    public static void main(String[] args) throws JSONException, IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        CurrencyLogic currencyLogic = new CurrencyLogic();
        currencyLogic.start();
        while (currencyLogic.isRunning()){
            String uInp = scanner.nextLine();
            if(Objects.equals(uInp, "")) break;
            currencyLogic.inputProcessing(uInp);
        }
    }
}
