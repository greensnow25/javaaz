package com.greensnow25;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Document;


import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.*;

import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * Public class XMLCreator.
 *
 * @author greensnow25.
 * @version 1.
 * @since 10.08.2017.
 */
public class XMLCreator {
    /**
     * factory get new instance.
     */
    private TransformerFactory tf;
    /**
     * Doc build factory.
     */
    private DocumentBuilderFactory dbf;
    /**
     * class object, perform operations with data base.
     */
    private DBOperations dbOperations;
    /**
     * logger.
     */
    private Logger l = LoggerFactory.getLogger(XMLCreator.class);

    /**
     * constructor.
     *
     * @param count of recording in the data base.
     */
    public XMLCreator(int count) {
        dbOperations = new DBOperations(count);
        this.dbf = DocumentBuilderFactory.newInstance();
        this.tf = TransformerFactory.newInstance();
    }

    /**
     * method transform base to xml file.
     *
     * @param doc incoming empty document.
     * @return xml file with all values from data base.
     * @throws TransformerException ex.
     */
    private Document fromDBToXML(Document doc) throws TransformerException {
        try {
            l.info("start convert");
            Element root = doc.createElement("Enumeration");
            doc.appendChild(root);
            ResultSet numbers = this.dbOperations.selectQuery("SELECT id_key, number  FROM num.numbers;");
            ResultSetMetaData rsmd = numbers.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while (numbers.next()) {
                Element num = doc.createElement("id_number");
                root.appendChild(num);
                for (int i = 1; i < columnCount + 1; i++) {
                    String columnName = rsmd.getColumnName(i);
                    Object value = numbers.getObject(i);

                    Element el = doc.createElement(columnName);
                    el.appendChild(doc.createTextNode(value.toString()));
                    num.appendChild(el);
                }
            }
            l.info("conversion completed successfully");
        } catch (SQLException e) {
            l.warn(e.getMessage(), e);
        }
        Transformer transformer = tf.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("chapter8\\jdbc\\src\\main\\java\\com\\greensnow25\\baseFirst.xml"));
        transformer.transform(source, result);
        return doc;
    }

    /**
     * @param xml doc.
     * @return new mapping doc.
     * @throws TransformerException         ex.
     * @throws ParserConfigurationException ex.
     * @throws IOException                  ex.
     * @throws SAXException                 ex.
     */
    public File frmXMLToXML(Document xml) throws TransformerException, ParserConfigurationException, IOException, SAXException {
        Source xmlSource = new DOMSource(xml);
        DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
        Document xslt = documentBuilder.parse(new File("chapter8\\jdbc\\src\\main\\java\\com\\greensnow25\\Schema.xsl"));
        Source xsltSource = new DOMSource(xslt);
        Transformer trans = this.tf.newTransformer(xsltSource);
        File f = new File("chapter8\\jdbc\\src\\main\\java\\com\\greensnow25\\baseSecond.xml");
        StreamResult result = new StreamResult(f);
        trans.transform(xmlSource, result);
        return f;
    }

    /**
     * method create empty xml document.
     *
     * @param dbf factory.
     * @return empty xml.
     * @throws ParserConfigurationException ex.
     */
    public Document createEmptyDoc(DocumentBuilderFactory dbf) throws ParserConfigurationException {
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();
        return doc;
    }

    /**
     * run application.
     *
     * @throws ParserConfigurationException ex.
     * @throws IOException                  ex.
     * @throws SAXException                 ex.
     * @throws XMLStreamException           ex.
     */
    public void runApplication() throws ParserConfigurationException, IOException, SAXException, XMLStreamException {
        Document documentXMLFirst = createEmptyDoc(dbf);
        try {
            Document documentXML = this.fromDBToXML(documentXMLFirst);
            dbf.setNamespaceAware(true);
            File f = this.frmXMLToXML(documentXML);
            BigInteger count = new Counter(f.getPath()).parseAndAdd();
            System.out.printf("%s%d%s", "Sum of all attributes equals:", count, System.getProperty("line.separator"));
        } catch (TransformerException e) {
            l.warn(e.getMessage(), e);
        }
    }

    /**
     * main.
     *
     * @param args args.
     * @throws IOException                  ex.
     * @throws ParserConfigurationException ex.
     * @throws SAXException                 ex.
     * @throws TransformerException         ex.
     * @throws XMLStreamException           ex.
     */

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, TransformerException, XMLStreamException {

        long start = System.currentTimeMillis();
        XMLCreator creator = new XMLCreator(1_000);
        long finish1 = System.currentTimeMillis();
        double res1 = (finish1 - start) / 1000;
        System.out.printf("%s%f%s", "Database creation time : ", res1, System.getProperty("line.separator"));

        creator.runApplication();
        long finish = System.currentTimeMillis();
        double res = (finish - start) / 1000;
        System.out.printf("%s%f%s", "purse and make sum time : ", res, System.getProperty("line.separator"));


    }


}
