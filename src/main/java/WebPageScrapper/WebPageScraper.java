package WebPageScrapper;

import java.io.IOException;
import java.util.Scanner;

public class WebPageScraper {
    public static void main(String[] arg) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        WebPageScraperLogic webPageScraperLogic = new WebPageScraperLogic();
        webPageScraperLogic.mainProcessing(scanner.nextLine());
    }
}
