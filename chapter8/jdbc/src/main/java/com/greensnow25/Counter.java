package com.greensnow25;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.XMLReader;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigInteger;

/**
 * Public class Counter.
 *
 * @author greensnow25.
 * @version 1.
 * @since 16.08.2017.
 */
public class Counter {
    /**
     * XML factory.
     */
    private XMLInputFactory xmlInputFactory;
    /**
     * xml reader.
     */
    private XMLStreamReader reader;
    /**
     * logger.
     */
    private Logger l = LoggerFactory.getLogger(getClass());

    /**
     * constructor.
     *
     * @param path to file.
     */
    public Counter(String path) {
        this.xmlInputFactory = XMLInputFactory.newInstance();
        try {
            this.reader = xmlInputFactory.createXMLStreamReader(new FileReader(path));
        } catch (XMLStreamException e) {
            l.warn(e.getMessage(), e);
        } catch (FileNotFoundException e) {
            l.warn(e.getMessage(), e);
        }
    }

    /**
     * parse file and sum values.
     *
     * @return sum.
     * @throws XMLStreamException ex.
     */
    public BigInteger parseAndAdd() throws XMLStreamException {
        BigInteger count = BigInteger.valueOf(0);
        while (reader.hasNext()) {
            reader.next();
            if (reader.isStartElement()) {
                if (reader.getLocalName().equals("entity")) {
                    count = this.readAttributes(reader).add(count);
                }
            }
        }
        return count;
    }

    /**
     * read atributes from xml and sum them.
     *
     * @param reader reader.
     * @return sum.
     * @throws XMLStreamException ex.
     */
    public BigInteger readAttributes(XMLStreamReader reader) throws XMLStreamException {
        int first = Integer.parseInt(reader.getAttributeValue(0));
        int second = Integer.parseInt(reader.getAttributeValue(1));
        return BigInteger.valueOf(first + second);
    }
}
