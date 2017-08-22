package com.greensnow25;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Public class HTMLParserExample.
 *
 * @author greensnow25.
 * @version 1.
 * @since 21.08.2017.
 */
public class HTMLParserExample {

    private Document document = null;
    private static final String START_PARSING = "31 дек 2016";
    private String lastDayOfParsing = null;
    private String wordForSearch = "java";
    private String URL = "http://www.sql.ru/forum/job/";


    public HTMLParserExample() {

    }

    public void parseSomePageHTML(int pageNumber) throws ParseException {
        List list = new ArrayList();
        String URL = this.URL;
        if (pageNumber != 0) {
            URL = this.URL + String.valueOf(pageNumber);
        }
        try {
            document = Jsoup.connect(URL).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements elements = document.getElementsByTag("tr");

        //Elements elements = document.select("td[style]").select("[class]");
        boolean res = false;
        for (Element element : elements) {
            Elements elements1 = element.select("td[style]").select("[class]");
            String s = elements1.text();
            if (!s.isEmpty()) {
                res = this.compareDates(s);
            }
            if (res) {
                Element e = element.select("a[href]").first();
                String w = e.attr("href");
                String text = e.text();
                System.out.println(w);
                System.out.println(text);

            }
        }
    }

    public boolean mather(String sentence) {
        Pattern pattern =  Pattern.compile("[Jj][Aa][vV][aA]\\s|$");
        Matcher matcher = pattern.matcher(sentence);
    }

    public boolean compareDates(String publishDay) throws ParseException {
        String dayPattern = "dd MMM yy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dayPattern);
        Date first;
        if (publishDay.startsWith("сегодня")) {
            publishDay = new SimpleDateFormat(dayPattern).format(new Date());
        } else if (publishDay.startsWith("вчера")) {
            final Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, -1);
            publishDay = new SimpleDateFormat(dayPattern).format(cal.getTime());
        }
        if (this.lastDayOfParsing == null) {
            first = simpleDateFormat.parse(START_PARSING);
        } else {
            first = simpleDateFormat.parse(this.lastDayOfParsing);
        }
        Date second = simpleDateFormat.parse(publishDay);

        int a = first.compareTo(second);

        return a <= 0 ? true : false;
    }

    public static void main(String[] args) throws ParseException {
        HTMLParserExample pars = new HTMLParserExample();
        pars.parseSomePageHTML(1);
        //pars.compareDates("d");
    }
}
