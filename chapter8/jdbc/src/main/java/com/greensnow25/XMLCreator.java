package com.greensnow25;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Document;


import java.io.File;
import java.io.IOException;
import java.sql.*;

import com.sun.org.apache.xerces.internal.dom.DocumentImpl;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMResult;
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
    private final String password = "tcrfylth";
    private final String userName = "postgres";
    private final String URL = "jdbc:postgresql://127.0.0.1:5432/job4j";
    private Connection connection = null;
    private Statement st;
    Document documentXMLOne = null;
    //  Handler  handler = new FileHandler();
    Logger l = LoggerFactory.getLogger(XMLCreator.class);

    public XMLCreator() {
        try {
            this.connection = DriverManager.getConnection(this.URL, this.userName, this.password);
            this.st = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean dbCreator() {
        boolean res = false;
        try {

            st.executeUpdate("DROP SCHEMA IF EXISTS num CASCADE ");
            st.executeUpdate("CREATE SCHEMA num");
            st.executeUpdate("CREATE TABLE num.numbers(id_key  SERIAL PRIMARY KEY, " +
                    "number INTEGER NOT NULL UNIQUE )");
            PreparedStatement sp = connection.prepareStatement("INSERT INTO num.numbers(number)VALUES (?)");
            for (int i = 0; i != 100; i++) {
                sp.setInt(1, i);
                sp.execute();
            }
            res = true;
        } catch (SQLException e) {
            l.error(e.getMessage(), e);
        }
        return res;
    }


    public void run() throws ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        //dbCreator();
        this.documentXMLOne = createEmptyDoc(dbf);
        try {
            documentXMLOne =this.fromDBToXML(documentXMLOne);

        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }


    private Document fromDBToXML(Document doc) throws TransformerException {
        boolean res = false;
        try {
            Element root = doc.createElement("Enumeration");
            doc.appendChild(root);
            ResultSet numbers = st.executeQuery("SELECT * FROM num.numbers;");
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
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("E:\\base.xml"));
            transformer.transform(source, result);

            res = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doc;
    }

    private void buildNumbersXML(ResultSet resultSet) {
        DocumentImpl XMLDoc = new DocumentImpl();
        Element rootElement = XMLDoc.createElement("Enumeration");
        XMLDoc.appendChild(rootElement);
    }

    public Document createEmptyDoc(DocumentBuilderFactory dbf) throws ParserConfigurationException {
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();
        return doc;
    }

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, TransformerException {
        XMLCreator creator = new XMLCreator();
        creator.run();

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document xslt = db.parse("E:\\progectsJava\\javaaz\\chapter8\\jdbc\\src\\main\\java\\com\\greensnow25\\Schema.xsl");
        System.out.println(xslt);
        System.out.println(creator.documentXMLOne);
        Document XML2 = transformXML(creator.documentXMLOne, xslt);
        System.out.println(XML2);



    }


    public static Document transformXML(Document xml, Document xslt) throws TransformerException, ParserConfigurationException, FactoryConfigurationError {

        Source xmlSource = new DOMSource(xml);
        Source xsltSource = new DOMSource(xslt);


        TransformerFactory transFact
                = TransformerFactory.newInstance();
        Transformer trans = transFact.newTransformer(xsltSource);
        StreamResult result = new StreamResult(new File("E:\\base1.xml"));
        trans.transform(xmlSource, result);

        Document resultDoc =null;

        return resultDoc;
    }
}
