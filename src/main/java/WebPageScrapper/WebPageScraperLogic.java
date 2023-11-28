package WebPageScrapper;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;

public class WebPageScraperLogic {
    public void mainProcessing(String inp) {
        try {
            if (!inp.contains("https://www.imdb.com/title/")) {
                System.out.println("Invalid movie page!");
                return;
            }
            Connection connection = Jsoup.connect(inp);
            connection.header("Accept-Language", "en-US,en;q=0.5");
            Document doc = connection.get();
            Element metaDescription = doc.select("meta[name=description]").first();
            if (metaDescription != null) {
                String content = metaDescription.attr("content");
                System.out.println(content);
            } else {
                System.out.println("Description not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
