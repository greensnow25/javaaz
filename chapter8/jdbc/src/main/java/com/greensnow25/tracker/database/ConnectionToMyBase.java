package com.greensnow25.tracker.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Public class ConnectionToMyBase.
 *
 * @author greensnow25.
 * @version 1.
 * @since 18.08.2017.
 */
public class ConnectionToMyBase {
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
     * logger.
     */
    private Logger l = LoggerFactory.getLogger(getClass());
    /**
     * connection.
     */
    private Connection connection = null;

    /**
     * constructor.
     */
    public ConnectionToMyBase() {
        this.loadProperties();
        try {
            this.connection = DriverManager.getConnection(this.URL, this.userName, this.password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * load properties from file.
     */
    private void loadProperties() {
        try (InputStream reader = this.getClass().getClassLoader().getResourceAsStream("jdbc.properties")) {
            Properties properties = new Properties();
            properties.load(reader);
            this.password = properties.getProperty("password");
            this.userName = properties.getProperty("userName");
            this.URL = properties.getProperty("URL");
        } catch (FileNotFoundException e) {
            l.warn(e.getMessage(), e);
        } catch (IOException e) {
            l.warn(e.getMessage(), e);
        }
    }

    /**
     * getConnection.
     *
     * @return connection.
     */
    public Connection getConnection() {
        return connection;
    }
}
