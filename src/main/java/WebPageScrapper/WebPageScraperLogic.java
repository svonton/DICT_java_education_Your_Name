package WebPageScrapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WebPageScraperLogic {
    public void mainProcessing(String inp) {
        try {
            Document doc = Jsoup.connect(inp).get();
            Elements articles = doc.select("article");
            for(Element article : articles){
                if(article.select("span[class=c-meta__type]").text().matches("News")){
                    String fileName = article.select("a").text().replaceAll(" ","_");
                    System.out.println(fileName);
                    BufferedWriter writer = new BufferedWriter(new FileWriter("articles/"+fileName+".txt"));
                    Element link = article.select("h3.c-card__title > a").first();
                    String url = link.attr("href");
                    Document fullArticleDoc = Jsoup.connect("https://www.nature.com"+url).get();
                    System.out.println(fullArticleDoc.select("p[class=article__teaser]").text());
                    writer.write(fullArticleDoc.select("p[class=article__teaser]").text());
                    writer.close();
                }
            }
        } catch (org.jsoup.HttpStatusException e) {
            System.out.println(String.format("The URL returned %s!",e.getStatusCode()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
