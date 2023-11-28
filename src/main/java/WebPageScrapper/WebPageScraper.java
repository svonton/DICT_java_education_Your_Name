package WebPageScrapper;

import java.io.IOException;
import java.util.Scanner;

public class WebPageScraper {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        WebPageScraperLogic webPageScraperLogic = new WebPageScraperLogic();
        webPageScraperLogic.mainProcessing(scanner.nextLine());
    }
}
