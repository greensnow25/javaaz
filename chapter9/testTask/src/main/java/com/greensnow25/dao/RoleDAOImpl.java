package com.greensnow25.dao;

import com.greensnow25.entity.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Public class RoleDAOImpl.
 *
 * @author greensnow25.
 * @version 1.
 * @since 12.10.2017.
 */
public class RoleDAOImpl implements Dao<Role> {
    private Connection connection;

    public RoleDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Role> getAllEntity() {
        String query = "SELECT * FROM servlet.controltask.role";
        List<Role> list = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String role = resultSet.getString("role");
                int id = resultSet.getInt("id_role");
                list.add(new Role(role, id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Role getOneByName(String string) {
        return null;
    }

    @Override
    public Role getByID(int id) {
        String query = "SELECT * FROM servlet.controltask.role AS A WHERE A.id_role = ?";
        String name = null;

        try {

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                name = resultSet.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Role(name, id);
    }

    @Override
    public boolean create(Role entity) {
        String query = "INSERT INTO controlTask.role (role) VALUES (?)";
        boolean res = false;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, entity.getRole());
            res = statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean update(Role entity) {
        String query = "UPDATE servlet.controltask.role SET role = ? WHERE id_role = ?;";
        boolean res = false;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(2, entity.getId());
            statement.setString(1, entity.getRole());
            res = statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean delete(Role entity) {
        String query = "DELETE FROM servlet.controltask.role WHERE role = ?";
        boolean res = false;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, entity.getRole());
            res = statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
