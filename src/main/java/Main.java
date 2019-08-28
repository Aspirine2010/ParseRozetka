import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class Main {
    static int t = 0;
    private static Document getDocument()throws IOException{
        String url = "https://rozetka.com.ua/mobile-phones/c80003/";
        Document page = Jsoup.parse(new URL(url),10000);
        return page;
    }
    static void parseAllPAgers()throws IOException{
        String s = "https://rozetka.com.ua/mobile-phones/c80003/page=";
        String e =  "/";
        for (int i = 2; i <=100 ; i++) {
           String url  = s+ i+ e;
           Document page = Jsoup.parse(new URL(url),10000);
            Element element = page.selectFirst("div[class = g-i-tile-l g-i-tile-catalog-hover-left-side clearfix]");
            Elements elements = element.select("div[class = g-i-tile g-i-tile-catalog]");
            for(Element element1: elements){
                Element model = element1.selectFirst("div[class = g-i-tile-i-title clearfix]");
                t++;
                System.out.println("Модель номер "+t+  "   "+model.text());

            }
        }
    }

    public static void main(String[] args) throws IOException{
        Document page = getDocument();
        Element element = page.selectFirst("div[class = g-i-tile-l g-i-tile-catalog-hover-left-side clearfix]");
        Elements elements = element.select("div[class = g-i-tile g-i-tile-catalog]");
        for(Element element1: elements){
            Element model = element1.selectFirst("div[class = g-i-tile-i-title clearfix]");
            t++;
            System.out.println("Модель номер "+t+  "   "+model.text());

        }
        parseAllPAgers();

    }
}
