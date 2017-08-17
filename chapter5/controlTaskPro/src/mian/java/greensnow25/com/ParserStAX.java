package greensnow25.com;

import jdk.internal.org.xml.sax.XMLReader;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

/**
 * public class ParserStAX.
 *
 * @author greensnow25.
 * @version 1.
 * @since 02.06.2017.
 */
public class ParserStAX {

    private XMLInputFactory xmlInputFactory;

    private String path = "D:\\java video\\orders.xml";

    private HashMap<String, Order> map;
    Order order;

    public ParserStAX() {
        this.xmlInputFactory = XMLInputFactory.newInstance();
        this.map = new HashMap<>();
    }

    public void parse() throws FileNotFoundException, XMLStreamException {
        XMLStreamReader reader = xmlInputFactory.createXMLStreamReader(new FileReader(path));
        while (reader.hasNext()) {
            if (reader.isStartElement()) {
                String value = reader.getLocalName();
                if (value.equals("AddOrder")) {
                    String id = reader.getAttributeValue(4);
                    order = new Order(reader.getAttributeValue(0)
                            , reader.getAttributeValue(1).equals("BUY")
                            , Double.parseDouble(reader.getAttributeValue(2))
                            , Integer.parseInt(reader.getAttributeValue(3))
                            , Integer.parseInt(id));
                    map.put(id, order);
                    order = null;
                } else if (value.equals("DeleteOrder")) {
                    map.remove(Integer.parseInt(reader.getAttributeValue(1)));
                }
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        ParserStAX stAX = new ParserStAX();
        double start = System.currentTimeMillis();
        stAX.parse();
        double finish = System.currentTimeMillis();
        System.out.println(finish - start);
    }


}
