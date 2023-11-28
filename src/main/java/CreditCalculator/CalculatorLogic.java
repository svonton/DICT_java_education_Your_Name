package CreditCalculator;


public class CalculatorLogic {
    Double monthlyPayment; // every month payment - A
    Double loanPrincipal; // sum of credit - P
    Double numberOfMonth; //required month - n
    Double loanInterest; // for nominal calc
    Double nominalLoanInterest; // - i
    Double diffMonthPayment;
    String creditType;

    private void numberOfMonthPayments(){
        try {
            nominalLoanInterest = nominalLoanInterestCalc(loanInterest);
            double logCalc = monthlyPayment/(monthlyPayment-nominalLoanInterest*loanPrincipal);
            double logBase = 1+nominalLoanInterest;
            numberOfMonth = Math.log(logCalc)/Math.log(logBase);

            double years = Math.ceil(numberOfMonth)/12;
            double months = Math.ceil(numberOfMonth)%12;
            System.out.println(String.format("It will take %d years and %d months to repay this loan!",
                    (int) years, (int) months));
        } catch (Exception e) {
            System.out.println("Something went wrong in numberOfMonthPayments.");
        }
    }

    private void annuityMonthlyPaymentAmount(){
        try{
            nominalLoanInterest = nominalLoanInterestCalc(loanInterest);
            double tempr = Math.pow((1+nominalLoanInterest),numberOfMonth);
            monthlyPayment = loanPrincipal*((nominalLoanInterest*tempr)/(tempr-1));
            System.out.println(String.format("Your monthly payment = %d!",(int) Math.ceil(monthlyPayment)));
        }catch (Exception e){
            System.out.println("Something went wrong in annuityMonthlyPaymentAmount.");
        }
    }
    private void loanPrincipal(){
        try{
            nominalLoanInterest = nominalLoanInterestCalc(loanInterest);
            double tempr = Math.pow((1+nominalLoanInterest),numberOfMonth);
            loanPrincipal = monthlyPayment/((nominalLoanInterest*tempr)/(tempr-1));
            System.out.println(String.format("Your loan principal = %d!",loanPrincipal.intValue()));
        }catch(Exception e){
            System.out.println("Something went wrong in loanPrincipal.");
        }
    }
    private void diffCalc(){
        try {
            nominalLoanInterest = nominalLoanInterestCalc(loanInterest);
            for (int m = 1; m < numberOfMonth+1; m++){
                diffMonthPayment = (loanPrincipal/numberOfMonth)+(nominalLoanInterest*(loanPrincipal-(loanPrincipal*(m-1)/numberOfMonth)));
                System.out.println(String.format("Month %d: payment is %d",m,(int)Math.ceil(diffMonthPayment)));
            }
        } catch (Exception e) {
            System.out.println("Something went wrong with diff calc.");
        }
    }
    private Double nominalLoanInterestCalc(double loanInterest){
        return loanInterest/(12*100);
    }

    private void annuityOperationPicker(){
        if (loanPrincipal == null && numberOfMonth!=null && loanInterest!=null && monthlyPayment!=null)
            loanPrincipal();
        else if (monthlyPayment == null && loanPrincipal != null && numberOfMonth!=null && loanInterest!=null)
            annuityMonthlyPaymentAmount();
        else if (numberOfMonth == null && loanPrincipal != null && loanInterest!=null && monthlyPayment!=null)
            numberOfMonthPayments();
        else {
            System.out.println("Not enough values for annuity calc.");
        }
    }
    static Double parseDouble(String s) {
        return s == null ? null : Double.parseDouble(s);
    }
    public void setValues(String type,String principal,String periods, String interest,String payment){
        try {
            this.monthlyPayment = parseDouble(payment); // every month payment - A
            this.loanPrincipal= parseDouble(principal); // sum of credit - P
            this.numberOfMonth= parseDouble(periods); //required month - n
            this.loanInterest= parseDouble(interest); // for nominal calc
            this.creditType=type;
        } catch (Exception e) {
            System.out.println("Something went wrong with assigned data");
        }
    }
    public void dataAnalyze(String type,String principal,String periods, String interest,String payment){
        if(creditType==null){System.out.println("Enter type"); return;}
        for (String curValue : new String[]{principal,periods,interest,payment}){
            if (curValue !=null && curValue.contains("-")){
                System.out.println("Minus is not allowed");
                return;
            }
        }
        setValues(type,principal,periods,interest,payment);
        switch (creditType){
            case "diff" -> diffCalc();
            case "annuity" -> annuityOperationPicker();
        }
    }
}
