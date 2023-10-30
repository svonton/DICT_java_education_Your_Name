package CreditCalculator;


import java.util.Scanner;

public class CalculatorLogic {
    double payment; // every month payment
    double principal; // sum of credit
    double month; //required month
    double lastPayment;
    public void calculation(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the loan principal:");
        principal = Integer.parseInt(scanner.nextLine());
        System.out.println("What do you want to calculate?\n" +
                "type \"m\" – for number of monthly payments, \n" +
                "type \"p\" – for the monthly payment:");
        String uInp = scanner.nextLine();
        switch (uInp){
            case "m" -> {
                System.out.println("Enter the monthly payment:");
                payment = scanner.nextInt();
                month = principal/payment;
                System.out.println(String.format("It will take %d month to repay the loan",(int) Math.ceil(month)));
            }
            case "p" -> {
                System.out.println("Enter the number of months:");
                month = scanner.nextInt();
                payment = Math.ceil(principal/month);
                lastPayment = Math.ceil(principal - (month-1)*payment);
                System.out.println(String.format("Your monthly payment = %d and the last payment = %d",
                        (int) payment, (int) lastPayment));
            }
        }
    }
}
