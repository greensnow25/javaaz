package com.greensnow25.tracker.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

/**
 * Public class MyBase.
 *
 * @author greensnow25.
 * @version 1.
 * @since 17.08.2017.
 */
public class MyBase {
    /**
     * password.
     */
    private String password;
    /**
     * user name.
     */
    private String userName;
    /**
     * URL.
     */
    private String URL;
    /**
     * connection.
     */
    private Connection connection = null;
    /**
     * statement.
     */
    private Statement st = null;
    /**
     * logger.
     */
    private Logger l = LoggerFactory.getLogger(getClass());

    /**
     * constructor.
     */
    public MyBase() {
        this.loadProperties();
        try {
            Connection driver = DriverManager.getConnection(this.URL,this.userName, this.password);
            st = driver.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * load properties from file.
     */
    public void loadProperties() {
        try (InputStreamReader reader = new FileReader("chapter8\\jdbc\\src\\main\\resourses\\jdbc.properties")) {
            Properties properties = new Properties();
            properties.load(reader);
            l.info("load properties");
            this.password = properties.getProperty("password");
            this.userName = properties.getProperty("userName");
            this.URL = properties.getProperty("URL");
            l.info("properties loaded");
        } catch (FileNotFoundException e) {
            l.warn(e.getMessage(), e);
        } catch (IOException e) {
            l.warn(e.getMessage(), e);
        }
        System.out.println("dsd");
    }

    public void createTable(){

    }

    public static void main(String[] args) {
        MyBase base = new MyBase();
        
    }
}
