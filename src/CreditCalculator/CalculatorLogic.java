package CreditCalculator;


import java.util.Scanner;

public class CalculatorLogic {
    double monthlyPayment; // every month payment - A
    double loanPrincipal; // sum of credit - P
    double numberOfMonth; //required month - n
    double loanInterest; // for nominal calc 
    double nominalLoanInterest; // - i
    String mainMenu = """
                What do you want to calculate?
                type "n" for number of monthly payments,\s
                type "a" for annuity monthly payment amount,\s
                type "p" for loan principal:""";
    Scanner scanner = new Scanner(System.in);
    private void calculatorMenu(){
        System.out.println(mainMenu);
        switch (scanner.nextLine()){
            case "n" -> numberOfMonthPayments();
            case "a" -> annuityMonthlyPaymentAmount();
            case "p" -> loanPrincipal();
        }
    }
    private void numberOfMonthPayments(){
        System.out.println("Enter the loan principal");
        loanPrincipal = scanner.nextDouble();
        System.out.println("Enter the monthly payment:");
        monthlyPayment = scanner.nextDouble();
        System.out.println("Enter the loan interest:");
        loanInterest = scanner.nextDouble();

        nominalLoanInterest = loanInterest/(12*100);
        double logCalc = monthlyPayment/(monthlyPayment-nominalLoanInterest*loanPrincipal);
        double logBase = 1+nominalLoanInterest;
        numberOfMonth = Math.log(logCalc)/Math.log(logBase);

        double years = Math.ceil(numberOfMonth)/12;
        double months = Math.ceil(numberOfMonth)%12;
        System.out.println(String.format("It will take %d years and %d months to repay this loan!",
                (int) years, (int) months));
    }

    private void annuityMonthlyPaymentAmount(){
        System.out.println("Enter the loan principal");
        loanPrincipal = scanner.nextDouble();
        System.out.println("Enter the number of periods:");
        numberOfMonth = scanner.nextDouble();
        System.out.println("Enter the loan interest:");
        loanInterest = scanner.nextDouble();

        nominalLoanInterest = loanInterest/(12*100);
        double tempr = Math.pow((1+nominalLoanInterest),numberOfMonth);
        monthlyPayment = loanPrincipal*((nominalLoanInterest*tempr)/(tempr-1));
        System.out.println(String.format("Your monthly payment = %d!",(int) Math.ceil(monthlyPayment)));
    }
    private void loanPrincipal(){
        System.out.println("Enter the annuity payment:");
        monthlyPayment = scanner.nextDouble();
        System.out.println("Enter the number of periods:");
        numberOfMonth = scanner.nextDouble();
        System.out.println("Enter the loan interest:");
        loanInterest = scanner.nextDouble();

        nominalLoanInterest = loanInterest/(12*100);
        double tempr = Math.pow((1+nominalLoanInterest),numberOfMonth);
        loanPrincipal = monthlyPayment/((nominalLoanInterest*tempr)/(tempr-1));
        System.out.println(String.format("Your loan principal = %d!",(int) loanPrincipal));
    }
    public void calculation(){
        calculatorMenu();
    }
}
