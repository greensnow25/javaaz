package com.greensnow25.db.editVisitior;

import com.greensnow25.db.CreateConnection;
import com.greensnow25.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Public class EditAdmin.
 *
 * @author greensnow25.
 * @version 1.
 * @since 20.09.2017.
 */
public class EditUser {
    /**
     * create connection.
     */
    private CreateConnection connection;

    /**
     * constructor.
     *
     * @param connection connection to db.
     */
    public EditUser(CreateConnection connection) {
        this.connection = connection;
    }

    /**
     * change user role.
     *
     * @param user    name.
     * @param newRole role.
     */
    public void editRole(String user, String newRole) {
        String query = "UPDATE rolebase\n"
                + "SET rolebase_role_id = (SELECT B.id\n"
                + "                          FROM servlet.public.rolebase AS A INNER JOIN servlet.public.role AS B\n"
                + "                              ON A.rolebase_role_id = B.id AND B.role = ?)\n"
                + "WHERE user_id = (SELECT A.user_id\n"
                + "       FROM\n"
                + "         servlet.public.rolebase AS A INNER JOIN servlet.public.visitors AS B\n"
                + "           ON A.user_id = B.id AND B.login = ?); ";
        try (PreparedStatement st = connection.getConnection().prepareStatement(query)) {
            st.setString(1, newRole);
            st.setString(2, user);
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * edit user .
     *
     * @param currentUserName current name.
     * @param newName         new name.
     * @param newPassword     password.
     */
    public void editHimSelf(String currentUserName, String newName, String newPassword) {
        String query = "UPDATE visitors\n"
                + "SET login = ?, password = ?\n"
                + "WHERE login = ?";
        try (PreparedStatement st = connection.getConnection().prepareStatement(query)) {
            st.setString(1, newName);
            st.setString(2, newPassword);
            st.setString(3, currentUserName);
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * show all results.
     *
     * @return list.
     */
    public List showAll() {
        List l = new ArrayList();
        String query = "SELECT\n"
                + "  V.login,\n"
                + "  V.password,\n"
                + "  R.role\n"
                + "FROM servlet.public.rolebase AS RB\n"
                + "  INNER JOIN servlet.public.visitors AS V\n"
                + "    ON V.id = RB.user_id\n"
                + "  INNER JOIN servlet.public.role AS R\n"
                + "ON R.id = RB.rolebase_role_id;";
        try (Statement st = connection.getConnection().createStatement()) {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                User u = new User(rs.getString("login"),
                        rs.getString("password"),
                        rs.getString("role"));
                l.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return l;
    }
}
