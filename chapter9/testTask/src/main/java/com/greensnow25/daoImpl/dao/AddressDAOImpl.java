package com.greensnow25.daoImpl.dao;

import com.greensnow25.daoImpl.dao.daoParent.Dao;
import com.greensnow25.repository.Repository;
import com.greensnow25.entity.Address;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Public class Address.
 *
 * @author greensnow25.
 * @version 1.
 * @since 12.10.2017.
 */
public class AddressDAOImpl implements Dao<Address> {
    private Repository<Address> repository;

    private Connection connection;


    public AddressDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Address> getAllEntity() {
        String query = "SELECT * FROM servlet.controltask.address";
        List<Address> list = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String country = resultSet.getString("country");
                String city = resultSet.getString("city");
                int id = resultSet.getInt("id_address");
                list.add(new Address(country, city, id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Address getByID(int id) {
        String query = "SELECT * FROM servlet.controltask.address AS A WHERE A.id_address = ?";
        String country = null;
        String city = null;
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                country = resultSet.getString("country");
                city = resultSet.getString("city");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Address(country, city, id);
    }

    @Override
    public boolean create(Address entity) {
        String query = "INSERT INTO controlTask.address (country, city) VALUES (?,?)";
        boolean res = false;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, entity.getCountry());
            statement.setString(2, entity.getCity());
            res = statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean update(Address entity) {
        String query = "UPDATE servlet.controltask.address SET country = ?, city = ? WHERE id_role = ?;";
        boolean res = false;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(3, entity.getId());
            statement.setString(1, entity.getCountry());
            statement.setString(2, entity.getCity());
            res = statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean delete(Address entity) {
        String query = "DELETE FROM servlet.controltask.address WHERE id_address = ?";
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
