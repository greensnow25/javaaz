package com.greensnow25.Database;

import org.apache.commons.dbcp2.*;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
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
     * driver.
     */
    private String driver = null;

    /**
     * constructor.
     * @throws SQLException
     */
    public DBOperations() throws SQLException {
        this.loadPropertiesFromJDBC();
        try {
            this.connection = this.setUp().getConnection();
            l.info(connection.toString());
        } catch (ClassNotFoundException e) {
            l.warn(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            l.warn(e.getMessage(), e);
        } catch (InstantiationException e) {
            l.warn(e.getMessage(), e);
        }
    }

    /**
     * prepare connection.
     * @return DataSource
     * @throws ClassNotFoundException ex.
     * @throws IllegalAccessException ex.
     * @throws InstantiationException ex.
     */
    private DataSource setUp() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName(this.driver).newInstance();

        PoolableConnectionFactory factory = new PoolableConnectionFactory(
                new DriverManagerConnectionFactory(this.URL, this.userName, this.password), null);

        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxTotal(10);
        config.setMaxIdle(10);
        config.setMinIdle(1);

        ObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<>(factory, config);

        factory.setPool(connectionPool);

        DataSource dataSource = new PoolingDataSource<>(connectionPool);
        l.info(dataSource.toString());
        return dataSource;
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
            this.driver = properties.getProperty("driver");
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
            l.info("adding", ps);
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
