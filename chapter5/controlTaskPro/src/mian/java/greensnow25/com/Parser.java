package greensnow25.com;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

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
    /**
     * book map.
     */
    private TreeMap<String, OrderBook> ordersStorage;
    /**
     * Parsing settings.
     */
    private Handler handler;
    /**
     * order.
     */
    private Order order = null;

    /**
     * constructor.
     */
    public Parser() {
        this.saxParserFactory = SAXParserFactory.newInstance();
        this.ordersStorage = new TreeMap<>();
    }

    /**
     * Method of parsing a document and adding to bookOrder.
     */
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
        String book = attributes.getValue(0);
        order = new Order(attributes.getValue(0)
                , attributes.getValue(1).equals("BUY")
                , Double.parseDouble(attributes.getValue(2))
                , Integer.parseInt(attributes.getValue(3))
                , Integer.parseInt(id));
        this.sortOrders(order, book);
    }

    /**
     * Sort orders on repositories.
     *
     * @param order    order.
     * @param bookName book name.
     */
    public void sortOrders(Order order, String bookName) {
        OrderBook orderBook = ordersStorage.get(bookName);
        if (orderBook == null) {
            orderBook = new OrderBook();
            ordersStorage.put(bookName, orderBook);
        }
        orderBook.add(order);
    }

    /**
     * remove book from the storage.
     *
     * @param attributes attributes.
     */
    public void remove(Attributes attributes) {
        String book = attributes.getValue(0);
        OrderBook orderBook = ordersStorage.get(book);
        orderBook.remove(Integer.valueOf(attributes.getValue(1)));
    }

    /**
     * print order books.
     */
    public void init() {
        for (OrderBook orderBook : ordersStorage.values()) {
            orderBook.print();
        }
    }

    /**
     * inner class Handler, parsing settings.
     */
    private class Handler extends DefaultHandler {
        /**
         * if start element then method run.
         *
         * @param uri        do not use.
         * @param localName  do not use.
         * @param qName      tag name.
         * @param attributes tag attributes.
         * @throws SAXException ex.
         */
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("AddOrder")) {
                add(attributes);
            } else if (qName.equals("DeleteOrder")) remove(attributes);
        }
    }

    /**
     * run application.
     *
     * @param args args.
     */
    public static void main(String[] args) {
        Parser parser = new Parser();
        double start = System.currentTimeMillis();
        parser.parse();
        parser.init();
        double finish = System.currentTimeMillis();
        System.out.println(finish - start);
    }
}
