package com.greensnow25.db;

import com.greensnow25.model.User;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDataSource;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

/**
 * Public class DBOperations.
 *
 * @author greensnow25.
 * @version 1.
 * @since 13.09.2017.
 */
public class DBOperations {
    /**
     * Connections pool.
     */
    private DataSource dataSource;
    /**
     * logger.
     */
    private Logger l = LoggerFactory.getLogger(getClass());

    /**
     * constructor.
     *
     * @param countConnections size of pool.
     */
    public DBOperations(int countConnections) {
        try {
            this.dataSource = this.setUp(countConnections);
        } catch (ClassNotFoundException e) {
            l.warn(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            l.warn(e.getMessage(), e);
        } catch (InstantiationException e) {
            l.warn(e.getMessage(), e);
        }
    }

    /**
     * get connection.
     *
     * @return new connection.
     * @throws SQLException ex.
     */
    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
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
            l.warn(e.getMessage(), e);
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

    /**
     * add new user to the base.
     *
     * @param user which is registered.
     * @return false if successful.
     */
    public boolean addToBase(User user) {
        String query = "INSERT INTO users (login, e_mail, crete_date) VALUES (?,?,?)";
        Boolean res = true;
        try (PreparedStatement st = this.getConnection().prepareStatement(query)) {
            st.setString(1, user.getLogin());
            st.setString(2, user.geteMail());
            st.setTimestamp(3, user.getCreateDate());
            res = st.execute();
        } catch (SQLException e) {
            l.warn(e.getMessage(), e);
        }
        return res;
    }

    /**
     * update user mail.
     *
     * @param login which is edited.
     * @param mail  new mail.
     * @return false if successful.
     */
    public boolean updateMail(String login, String mail) {
        String query = "UPDATE servlet.public.users SET e_mail = ? WHERE login = ?";
        Boolean res = true;
        try (PreparedStatement ps = getConnection().prepareStatement(query)) {
            ps.setString(1, mail);
            ps.setString(2, login);
            res = ps.execute();
        } catch (SQLException e) {
            l.warn(e.getMessage(), e);
        }
        return res;
    }

    /**
     * delete user from base.
     *
     * @param login login
     * @return false if successful.
     */
    public boolean deleteUser(String login) {
        String query = "DELETE FROM servlet.public.users WHERE login = ?";
        Boolean res = true;
        try (PreparedStatement ps = getConnection().prepareStatement(query)) {
            ps.setString(1, login);
            res = ps.execute();
        } catch (SQLException e) {
            l.warn(e.getMessage(), e);
        }
        return res;
    }

    /**
     * show all base.
     *
     * @return base as list.
     * @throws SQLException ex.
     */
    public List showTable() throws SQLException {
        String query = "SELECT*FROM servlet.public.users";
        ResultSet set;
        List<User> list = new ArrayList();

        try (Statement st = getConnection().createStatement()) {
            set = st.executeQuery(query);
            while (set.next()) {
                String login = set.getString("login");
                String eMail = set.getString("e_mail");
                Timestamp date = set.getTimestamp("crete_date");

                User user = new User(login, eMail, date);
                list.add(user);

            }
            return list;

        }
    }
}
