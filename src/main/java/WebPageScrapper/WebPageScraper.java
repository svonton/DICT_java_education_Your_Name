package WebPageScrapper;

import java.util.Scanner;

public class WebPageScraper {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        WebPageScraperLogic webPageScraperLogic = new WebPageScraperLogic();
        webPageScraperLogic.mainProcessing("https://www.nature.com/nature/articles?sort=PubDate&year=2022&page=3");
    }
}
