package com.greensnow25.Database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Public class DBOperations.
 *
 * @author greensnow25.
 * @version 1.
 * @since 21.08.2017.
 */
public class DBOperations {
    /**
     * Db connection.
     */
    private Connection connection = null;
    /**
     * Prepeare statement.
     */
    private Statement st = null;
    /**
     * logger.
     */
    private Logger l = LoggerFactory.getLogger(getClass());
    /**
     * user name.
     */
    private String userName = null;

    /**
     * password.
     */
    private String password = null;

    /**
     * URL.
     */
    private String URL = null;

    /**
     * constructor.
     */
    public DBOperations() throws SQLException {
        this.loadPropertiesFromJDBC();
        this.connection = DriverManager.getConnection(this.URL, this.userName, this.password);
        l.info(String.valueOf(connection));
    }

    private void loadPropertiesFromJDBC() {
        try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("jdbc.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            this.URL = properties.getProperty("URL");
            this.password = properties.getProperty("password");
            this.userName = properties.getProperty("userName");
        } catch (IOException e) {
            l.warn(e.getMessage(), e);
        }
    }

    /**
     *
     */
    public void createDB() {
        try {
            Statement statement = connection.createStatement();
            statement.execute("DROP SCHEMA IF EXISTS javaJob");
            statement.execute("CREATE SCHEMA javaJob");
            statement.execute("CREATE TABLE jobList id_job ( id SERIAL PRIMARY KEY," +
                    "address VARCHAR (100), " +
                    "link_name VARCHAR (100)) ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        DBOperations DB = new DBOperations();
    }
}
