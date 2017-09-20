package com.greensnow25.db;

import com.greensnow25.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private CreateConnection connection;
    /**
     * logger.
     */
    private Logger l = LoggerFactory.getLogger(getClass());

    /**
     * constructor.
     */
    public DBOperations(int countCore) {
        this.connection = new CreateConnection();
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
        try (PreparedStatement st = this.connection.getConnection().prepareStatement(query)) {
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
        try (PreparedStatement ps = this.connection.getConnection().prepareStatement(query)) {
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
        try (PreparedStatement ps = this.connection.getConnection().prepareStatement(query)) {
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

        try (Statement st = this.connection.getConnection().createStatement()) {
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
