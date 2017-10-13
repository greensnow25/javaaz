package com.greensnow25.daoImpl.dao;

import com.greensnow25.daoImpl.dao.daoParent.Dao;
import com.greensnow25.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Public class UserDAOImpl.
 *
 * @author greensnow25.
 * @version 1.
 * @since 11.10.2017.
 */
public class UserDAOImpl implements Dao<User> {
    private Connection connection;

    public UserDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<User> getAllEntity() {
        String query = "SELECT * FROM servlet.controltask.user";
        List<User> list = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int role = resultSet.getInt("user_role");
                list.add(new User(name, role));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public User getByID(int id) {
        String query = "SELECT * FROM servlet.controltask.user AS A WHERE A.id_user = ?";
        String name = null;
        int role = 0;
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                name = resultSet.getString("name");
                role = resultSet.getInt("user_role");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new User(name, role);
    }

    @Override
    public boolean create(User entity) {
        String query = "INSERT INTO controlTask.user (name) VALUES (?)";
        boolean res = false;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, entity.getName());
            res = statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean update(User entity) {
            String query = "UPDATE servlet.controltask.user SET name = ? WHERE id_user = ?;";
            boolean res = false;
            try {
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(2, entity.getId());
                statement.setString(1, entity.getName());
                res = statement.execute(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return res;
    }

    @Override
    public boolean delete(User entity) {
        String query = "DELETE FROM servlet.controltask.user WHERE name = ?";
        boolean res = false;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, entity.getName());
            res = statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
