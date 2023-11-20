package CreditCalculator;


public class CreditCalculator {
    public static void main(String[] args){
        CalculatorLogic calculatorLogic = new CalculatorLogic();
        String type = System.getProperty("type");
        String principal = System.getProperty("principal"); // P
        String periods = System.getProperty("periods"); // n
        String interest = System.getProperty("interest"); // for i calc
        String payment = System.getProperty("payment"); // A
        calculatorLogic.dataAnalyze(type,principal,periods,interest,payment);
    }
}
