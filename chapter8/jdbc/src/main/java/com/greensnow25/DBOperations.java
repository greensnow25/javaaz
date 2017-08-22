package com.greensnow25;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

/**
 * Public class DBOperations.
 *
 * @author greensnow25.
 * @version 1.
 * @since 15.08.2017.
 */
public class DBOperations {
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
     * number of records in the table.
     */
    private final int countOfRecords;
    /**
     * logger.
     */
    private Logger l = LoggerFactory.getLogger(getClass());

    public DBOperations(int count) {
        try {
            l.info("start connecting to data base");
            this.loadProperties();
            this.connection = DriverManager.getConnection(this.URL, this.userName, this.password);
            this.st = connection.createStatement();
            l.info("end connecting to data base");
        } catch (SQLException e) {
            l.warn(e.getMessage(), e);
        }
        this.countOfRecords = count;
        this.dbCreate();
    }

    /**
     * load properties from file.
     */
    private void loadProperties() {
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
    }

    /**
     * method create data base.
     *
     * @return if successful true, else false.
     */
    private boolean dbCreate() {
        l.info("create Db");
        boolean res = false;
        int batchSize = 1000;
        int count = 0;
        try {
            connection.setAutoCommit(false);
            st.executeUpdate("DROP SCHEMA IF EXISTS num CASCADE ");
            st.executeUpdate("CREATE SCHEMA num");
            st.executeUpdate("CREATE TABLE num.numbers(id_key  SERIAL PRIMARY KEY, " +
                    "number INTEGER NOT NULL )");
            PreparedStatement sp = connection.prepareStatement("INSERT INTO num.numbers(number)VALUES (?)");
            for (int i = 0; i != this.countOfRecords; i++) {
                sp.setInt(1, i);
                sp.addBatch();
                if (++count % batchSize == 0) {
                    sp.executeBatch();
                }
            }
            sp.executeBatch();
            res = true;
            connection.commit();
            l.info("base create successful");
        } catch (SQLException e) {
            l.error(e.getMessage(), e);
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return res;
    }

    /**
     * method send query to base.
     *
     * @param query query.
     * @return resultSet.
     * @throws SQLException ex.
     */
    public ResultSet selectQuery(String query) throws SQLException {
        return st.executeQuery(query);
    }
}