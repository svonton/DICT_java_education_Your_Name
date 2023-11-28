package CurrencyExchange;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

public class CurrencyLogic {
    private boolean running;
    private CurrencyLogicState state;
    private String mainCurrency;
    private String currentCurrency;
    private Double currencyAmount;
    private JSONObject cachedUsedCurrencyResponse = new JSONObject();
    private JSONObject currentCurrencyResponse;
    private List<String> usedCurrency = new ArrayList<>();
    public boolean isRunning(){
        return running;
    }
    public void start(){
        running = true;
        state = CurrencyLogicState.ENTER_CURRENCY_MAIN;
    }
    public void makeRequest() throws IOException, InterruptedException, JSONException {
        HttpClient client = HttpClient.newHttpClient();
        //HttpRequest request = HttpRequest.newBuilder().uri(URI.create(String.format("http://www.floatrates.com/daily/%s.json",mainCurrency))).build();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(String.format("http://www.floatrates.com/daily/%s.json",currentCurrency))).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject jsonResponseResult = new JSONObject(response.body());
        //currentCurrencyResponse = (JSONObject) jsonResponseResult.get(currentCurrency);
        currentCurrencyResponse = (JSONObject) jsonResponseResult.get(mainCurrency);
        addToCache();
    }
    public void addToCache() throws JSONException {
        cachedUsedCurrencyResponse.put(currentCurrency,currentCurrencyResponse);
        usedCurrency.add(currentCurrency);
    }
    private void setMainCurrency(String uInp){
        mainCurrency = uInp;
        state = CurrencyLogicState.ENTER_CURRENCY_CURRENT;
    }
    private void setCurrentCurrency(String uInp){
        currentCurrency = uInp;
        state = CurrencyLogicState.ENTER_CURRENCY_AMOUNT;
    }
    private void setCurrencyAmount(String uInp){
        currencyAmount = Double.parseDouble(uInp);
    }
    private void calculateReceivedCash() throws JSONException {
        System.out.println(cachedUsedCurrencyResponse);
        JSONObject current = (JSONObject) cachedUsedCurrencyResponse.get(currentCurrency);
        Double rate = current.getDouble("inverseRate"); // Double rate = current.getDouble("inverseRate");
        Double calculatedCash = currencyAmount*rate;
        System.out.println(String.format("You received %f %s",calculatedCash,currentCurrency.toUpperCase()));
    }
    private void switcher() throws JSONException, IOException, InterruptedException {
        if(!usedCurrency.contains(currentCurrency)){
            System.out.println("Sorry, but it is not in the cache!");
            makeRequest();
        }else {
            System.out.println("It is in the cache!");
        }
        calculateReceivedCash();
        state = CurrencyLogicState.ENTER_CURRENCY_CURRENT;
    }
    public void inputProcessing(String uInp) throws JSONException, IOException, InterruptedException {
        switch (state){
            case ENTER_CURRENCY_MAIN -> setMainCurrency(uInp);
            case ENTER_CURRENCY_CURRENT -> setCurrentCurrency(uInp);
            case ENTER_CURRENCY_AMOUNT -> {
                setCurrencyAmount(uInp);
                switcher();
            }
        }
    }
}
