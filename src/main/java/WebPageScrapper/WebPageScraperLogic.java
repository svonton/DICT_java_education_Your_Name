package WebPageScrapper;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WebPageScraperLogic {
    public void mainProcessing(String inp) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(inp)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject jsonResponseResult = new JSONObject(response.body());
        if(jsonResponseResult.keySet().contains("statusCode")){
            if (jsonResponseResult.getInt("statusCode" ) == 404) System.out.println("Invalid quote resource!");
        }else{
            System.out.println(jsonResponseResult.get("content"));
        }
    }
}
