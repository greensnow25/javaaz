package greensnow25.com;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * public class OrderBook.
 *
 * @author greensnow25.
 * @version 1.
 * @since 01.06.2017.
 */
public class OrderBook {

    private SAXParserFactory saxParserFactory;

    private String path = "D:\\java video\\orders.xml";


    public OrderBook() {
        this.saxParserFactory = SAXParserFactory.newInstance();
    }

    public void parse(String ) {
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();

            saxParser.parse(path,new DefaultHandler(){
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    super.startElement(uri, localName, qName, attributes);
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    super.endElement(uri, localName, qName);
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    super.characters(ch, start, length);
                }
            });

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
