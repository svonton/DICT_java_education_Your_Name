package WebPageScrapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WebPageScraperLogic {
    public void mainProcessing(String inp) {
        try {
            Document doc = Jsoup.connect(inp).get();
            String pageContent = doc.html();
            BufferedWriter writer = new BufferedWriter(new FileWriter("source.html"));
            writer.write(pageContent);
            writer.close();
            System.out.println("Content saved.");
        } catch (org.jsoup.HttpStatusException e) {
            System.out.println(String.format("The URL returned %s!",e.getStatusCode()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
