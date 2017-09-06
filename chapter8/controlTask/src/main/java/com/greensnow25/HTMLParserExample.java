package com.greensnow25;

import com.greensnow25.Database.DBOperations;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
    /**
     * document.
     */
    private Document document = null;
    /**
     * Date, after which it is necessary to stop the search.
     */
    private static final String START_PARSING = "31 дек 2016";
    /**
     * last day of search.
     */
    private String lastDayOfParsing = null;
    /**
     * URL for parsing.
     */
    private String URL = "http://www.sql.ru/forum/job/";
    /**
     * database.
     */
    private DBOperations db;
    /**
     * logger.
     */
    private Logger l = LoggerFactory.getLogger(getClass());

    /**
     * constructor create base.
     *
     * @param dbOperations database.
     */
    public HTMLParserExample(DBOperations dbOperations) {
        this.db = dbOperations;
        db.createDB();
    }

    /**
     * method parse specified page.
     *
     * @param pageNumber specified page.
     * @return true, if page not contains elements in database,
     * else if contains then false.
     * @throws ParseException ex.
     * @throws SQLException   ex.
     */
    public boolean parseSomePageHTML(int pageNumber) throws ParseException, SQLException {
        String URL = this.URL;
        if (pageNumber != 0) {
            URL = this.URL + String.valueOf(pageNumber);
        }
        try {
            document = Jsoup.connect(URL).get();
        } catch (IOException e) {
            l.warn(e.getMessage(), e);
        }
        Elements elements = document.getElementsByTag("tr");
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
                if (this.matcher(text) && !db.select(text, w)) {
                    db.addData(text, w);
                }

            }
        }
        return res;
    }

    /**
     * method analyze sentence and match an certain word.
     *
     * @param sentence which we need tj analyze.
     * @return true, if match, else false.
     */
    public boolean matcher(String sentence) {
        Pattern pattern = Pattern.compile("^(?!.*[Ss][Cc][Rr][Ii][Pp][Tt]).*[Jj][Aa][vV][aA]\\s?");
        Matcher matcher = pattern.matcher(sentence);
        return matcher.find();
    }

    /**
     * compare dates.
     *
     * @param publishDay day of publish link.
     * @return true If the publication date is not older than the last update date,
     * if this is the first launch, then look for the past year. else false.
     * @throws ParseException ex.
     */
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


        return first.compareTo(second) <= 0 ;
    }

    /**
     * parse pages of given URL.
     *
     * @throws ParseException ex.
     * @throws SQLException   ex.
     */
    public void parsePages() throws ParseException, SQLException {
        //if three times publish day oldest that last update, then end parse and exit.
        int exit = 3;
        for (int i = 0; ; i++) {
            if (this.parseSomePageHTML(i + 1)) {
            } else {
                exit--;
            }
            if (exit == 0) {
                break;
            }
        }
    }
}
