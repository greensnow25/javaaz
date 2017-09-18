package com.greensnow25.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Public class ConnectToUrersBase.
 *
 * @author greensnow25.
 * @version 1.
 * @since 15.09.2017.
 */
public class ConnectToUsersBase {
    private CreateConnection connection;

    public ConnectToUsersBase(CreateConnection connection) {
        this.connection = connection;
    }

    public boolean checkUser(String name) throws SQLException {
        int i = 1;
        String query = "SELECT* FROM servlet.public.visitors as V WHERE V.login = ?";
        try (PreparedStatement st = connection.getConnection().prepareStatement(query)) {
            st.setString(1, name);
            ResultSet res = st.executeQuery();

            while (res.next()) {
                i--;
            }
            return i == 0;
        }

    }

    public boolean login(String name, String psw) throws SQLException {
        int i = 1;
        String query = "SELECT* FROM servlet.public.visitors as V WHERE V.login = ? AND V.password = ?;";
        try (PreparedStatement st = connection.getConnection().prepareStatement(query)) {
            st.setString(1, name);
            st.setString(2, psw);
            ResultSet res = st.executeQuery();

            while (res.next()) {
                i--;
            }
            return i == 0;
        }

    }

    public String checkUserRole(boolean enter, String login) {
        String i = null;
        String query = "SELECT W.role\n" +
                "FROM (((SELECT *\n" +
                "        FROM servlet.public.visitors AS A\n" +
                "        WHERE login = ?) AS A\n" +
                "  INNER JOIN servlet.public.rolebase AS RO ON RO.rolebase_role_id = A.id) AS V\n" +
                "  INNER JOIN servlet.public.role AS D ON D.id = V.rolebase_role_id) AS W;";
        try (PreparedStatement st = connection.getConnection().prepareStatement(query)) {
            st.setString(1, login);
            ResultSet res = st.executeQuery();

            while (res.next()) {
                i = res.getString(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
}
