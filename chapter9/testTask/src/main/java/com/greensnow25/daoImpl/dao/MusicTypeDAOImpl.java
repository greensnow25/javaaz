package com.greensnow25.daoImpl.dao;

import com.greensnow25.daoImpl.dao.daoParent.Dao;
import com.greensnow25.entity.Address;
import com.greensnow25.entity.MusicType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Public class MusicTypeDAOImpl.
 *
 * @author greensnow25.
 * @version 1.
 * @since 12.10.2017.
 */
public class MusicTypeDAOImpl implements Dao<MusicType> {
    private Connection connection;

    public MusicTypeDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<MusicType> getAllEntity() {
        String query = "SELECT * FROM servlet.controltask.musictype";
        List<MusicType> list = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String type = resultSet.getString("type");
                int id = resultSet.getInt("id_musictype");
                list.add(new MusicType(type, id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public MusicType getByID(int id) {
        String query = "SELECT * FROM servlet.controltask.musictype AS A WHERE A.id_address = ?";
        String type = null;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                type = resultSet.getString("type");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new MusicType(type, id);
    }

    @Override
    public boolean create(MusicType entity) {
        String query = "INSERT INTO controlTask.musictype (type) VALUES (?)";
        boolean res = false;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, entity.getType());
            res = statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean update(MusicType entity) {
        String query = "UPDATE servlet.controltask.musictype SET type = ? WHERE id_musictype = ?;";
        boolean res = false;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(2, entity.getId());
            statement.setString(1, entity.getType());
            res = statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean delete(MusicType entity) {
        String query = "DELETE FROM servlet.controltask.musictype WHERE id_musictype = ?";
        boolean res = false;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, entity.getId());
            res = statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
