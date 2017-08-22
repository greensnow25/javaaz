package com.greensnow25;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Public class HTMLParserExample.
 *
 * @author greensnow25.
 * @version 1.
 * @since 21.08.2017.
 */
public class HTMLParserExample {
    Document document = null;

    public HTMLParserExample() {
        try {
            this.document = Jsoup.connect("http://www.sql.ru/forum/job").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
