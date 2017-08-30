package com.greensnow25.Database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
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

    /**
     * load properties from file.
     */
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
     * create db.
     */
    public void createDB() {
        try {
            Statement statement = connection.createStatement();
            statement.execute("DROP SCHEMA IF EXISTS javaJob CASCADE ");
            statement.execute("CREATE SCHEMA javaJob");
            statement.execute("CREATE TABLE javaJob.jobList ( id SERIAL PRIMARY KEY," +
                    "address VARCHAR (100) UNIQUE , " +
                    "link_name VARCHAR (100)) ");
        } catch (SQLException e) {
            l.warn(e.getMessage(), e);
        }
    }

    /**
     * add data to the database.
     *
     * @param name link name.
     * @param URL  link address.
     */
    public void addData(String name, String URL) {
        String requestSQL = "INSERT INTO javaJob.jobList (address, link_name) VALUES (?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(requestSQL);
            ps.setString(1, URL);
            ps.setString(2, name);
            ps.execute();
        } catch (SQLException e) {
            l.warn(e.getMessage(), e);
        }
    }

    /**
     * select element.
     *
     * @param name link .
     * @param URL  adress.
     * @return true, if find.
     * @throws SQLException ex.
     */
    public boolean select(String name, String URL) throws SQLException {
        String request = "SELECT*FROM javajob.joblist AS A WHERE  A.address = ? and A.link_name = ?";

        PreparedStatement statement = connection.prepareStatement(request);
        statement.setString(1, URL);
        statement.setString(2, name);
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next();
    }

    /**
     * show all records.
     */
    public void showAll() {
        String request = "SELECT*FROM javajob.joblist ";
        try {
            Statement statement = connection.createStatement();
            statement.execute(request);
        } catch (SQLException e) {
            l.warn(e.getMessage(), e);
        }
    }

    /**
     * close connection.
     */
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            l.warn(e.getMessage(), e);
        }
    }
}
