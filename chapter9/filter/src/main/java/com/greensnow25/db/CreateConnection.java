package com.greensnow25.db;

import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDataSource;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Public class CreateConnection.
 *
 * @author greensnow25.
 * @version 1.
 * @since 15.09.2017.
 */
public class CreateConnection {
    /**
     * source.
     */
    private DataSource dataSource;

    /**
     * constructor.
     */
    public CreateConnection() {
        try {
            this.dataSource = this.setUp(4);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    /**
     * get connection.
     *
     * @return new connection.
     * @throws SQLException ex.
     */
    public Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();

    }

    /**
     * prepare connection.
     *
     * @param countConnection size of pool.
     * @return DataSource
     * @throws ClassNotFoundException ex.
     * @throws IllegalAccessException ex.
     * @throws InstantiationException ex.
     */
    private DataSource setUp(int countConnection) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String address = "";
        String password = null;
        String userName = null;
        String driver = null;
        try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("jdbc.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            address = properties.getProperty("URL");
            password = properties.getProperty("password");
            userName = properties.getProperty("userName");
            driver = properties.getProperty("driver");
        } catch (IOException e) {
            System.out.println("defwf");
            // l.warn(e.getMessage(), e);
        }

        Class.forName(driver).newInstance();

        PoolableConnectionFactory factory = new PoolableConnectionFactory(
                new DriverManagerConnectionFactory(address, userName, password), null);

        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxTotal(countConnection);
        config.setMaxIdle(countConnection);
        config.setMinIdle(1);

        ObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<>(factory, config);
        factory.setPool(connectionPool);
        DataSource dataSource = new PoolingDataSource<>(connectionPool);
        return dataSource;
    }
}

