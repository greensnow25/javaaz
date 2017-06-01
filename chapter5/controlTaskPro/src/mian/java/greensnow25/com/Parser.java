package greensnow25.com;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.HashMap;

/**
 * public class OrderBook.
 *
 * @author greensnow25.
 * @version 1.
 * @since 01.06.2017.
 */
public class Parser {
    /**
     * SAXParserFactory object.
     */
    private SAXParserFactory saxParserFactory;
    /**
     * xml path.
     */
    private String path = "D:\\java video\\orders.xml";

    private HashMap<String, Book> map;

    private Handler handler;

    private Book book = null;

    public Parser() {
        this.saxParserFactory = SAXParserFactory.newInstance();
        this.map = new HashMap<>();
    }

    public void parse() {
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            this.handler = new Handler();

            saxParser.parse(path, handler);


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * add book to the map.
     *
     * @param attributes xml attributes.
     */
    public void add(Attributes attributes) {
        String id = attributes.getValue(4);
        book = new Book(attributes.getValue(0)
                , attributes.getValue(1).equals("BUY")
                , Double.parseDouble(attributes.getValue(2))
                , Integer.parseInt(attributes.getValue(3))
                , Integer.parseInt(id));
        map.put(id, book);
    }

    public void remove(Attributes attributes) {
        String id = attributes.getValue(1);
        if (id != null) map.remove(attributes.getValue(1));

    }

    private class Handler extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("AddOrder")) {
                add(attributes);
            } else if (qName.equals("DeleteOrder")) remove(attributes);
        }
    }

    public static void main(String[] args) {
        Parser parser = new Parser();
        double start = System.currentTimeMillis();
        parser.parse();
        double finish = System.currentTimeMillis();
        System.out.println(finish - start);
    }
}
