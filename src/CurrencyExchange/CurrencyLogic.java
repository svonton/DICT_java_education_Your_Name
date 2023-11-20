package CurrencyExchange;

public class CurrencyLogic {
    private boolean running;
    private CurrencyLogicState state;
    private Double uInpCurrency;
    private Double exchangeRate;
    private Double myCoinAmount;
    public boolean isRunning(){
        return running;
    }
    public void start(){
        running = true;
        state = CurrencyLogicState.ENTER_CURRENCY;
    }
    private void setCurrency(String uInp){
        state = CurrencyLogicState.ENTER_EXCHANGE_RATE;
        myCoinAmount = Double.parseDouble(uInp);
    }
    private void setExchangeRate(String uInp){
        state = CurrencyLogicState.PRINT_RESULT;
        exchangeRate = Double.parseDouble(uInp);
    }
    private void printResult(){
        System.out.print(exchangeRate*myCoinAmount);
        running=false;
    }
    public CurrencyLogicState getCurrentState(){
        return state;
    }
    public void printUI(){
        switch (state){
            case ENTER_CURRENCY -> System.out.print("Please, enter the number of mycoins you have: ");
            case ENTER_EXCHANGE_RATE -> System.out.print("Please, enter the exchange rate:");
            case PRINT_RESULT -> {
                System.out.print("The total amount of dollars: ");
                printResult();
            }
        }
    }
    public void inputProcessing(String uInp){
        switch (state){
            case ENTER_CURRENCY -> setCurrency(uInp);
            case ENTER_EXCHANGE_RATE -> setExchangeRate(uInp);
        }
    }
}
