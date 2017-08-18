package com.greensnow25.tracker.database;

import com.greensnow25.tracker.model.Item;
import com.greensnow25.tracker.start.Tracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Public class MyBase.
 *
 * @author greensnow25.
 * @version 1.
 * @since 17.08.2017.
 */
public class MyBase extends Tracker {

    /**
     * connection.
     */
    private Connection connection = null;
    /**
     * statement.
     */
    private PreparedStatement st = null;
    /**
     * statement.
     */
    Statement statement = null;
    /**
     * logger.
     */
    private Logger l = LoggerFactory.getLogger(getClass());

    /**
     * constructor.
     */
    public MyBase() {
        this.connection = new ConnectionToMyBase().getConnection();
        try {
            this.createTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * create table.
     *
     * @throws SQLException ex.
     */
    public void createTable() throws SQLException {
        this.statement = connection.createStatement();
        statement.executeUpdate("DROP SCHEMA IF EXISTS tracker CASCADE ");
        statement.executeUpdate("CREATE SCHEMA tracker");
        statement.executeUpdate("CREATE TABLE tracker.items (id_user SERIAL PRIMARY KEY , user_name VARCHAR (20)UNIQUE ,time_create TIMESTAMP without time zone DEFAULT now(), descriptios TEXT )");
        statement.executeUpdate("CREATE TABLE tracker.comments( id_comment SERIAL PRIMARY KEY, comment TEXT," +
                " id_user INTEGER , FOREIGN KEY (id_user) REFERENCES tracker.items)");

    }

    /**
     * add item to the DB.
     *
     * @param item item.
     * @return added item.
     */
    @Override
    public Item add(Item item) {
        try {
            st = this.connection.prepareStatement("INSERT INTO tracker.items(user_name, descriptios)VALUES(?,?) ");
            st.setString(1, item.getName());
            st.setString(2, item.getDiscription());
            st.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    /**
     * update item.
     *
     * @param item you want to find.
     */
    @Override
    public void update(Item item) {
        try {
            st = connection.prepareStatement("UPDATE tracker.items SET user_name = ? WHERE id_user = ? ");
            st.setString(1, item.getName());
            st.setInt(2, 1);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * find by name.
     *
     * @param name - name of item.
     * @return detected item.
     */
    @Override
    public Item findByName(String name) {
        Item item = null;
        try {
            st = connection.prepareStatement("SELECT user_name , descriptios FROM tracker.items AS A WHERE A.user_name = ?");

            st.setString(1, name);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                item = new Item(resultSet.getString("user_name"),
                        resultSet.getString("descriptios"));
                System.out.println(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    /**
     * find by id.
     *
     * @param id of item.
     * @return detected item.
     */
    @Override
    public Item findById(String id) {
        Item item = null;
        try {
            st = connection.prepareStatement("SELECT descriptios, user_name FROM tracker.items AS A WHERE A.id_user = ?");

            st.setInt(1, Integer.parseInt(id));
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                item = new Item(resultSet.getString("user_name"),
                        resultSet.getString("descriptios"));
                System.out.println(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    /**
     * delete item.
     *
     * @param item which need to delete.
     */
    @Override
    public void delete(Item item) {

        try {
            st = connection.prepareStatement("DELETE FROM tracker.items AS A WHERE A.user_name = ?");
            st.setString(1, item.getName());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * show items from DB.
     *
     * @return list.
     */
    @Override
    public List<Item> getAll() {
        List<Item> list = new ArrayList<>();
        Item item = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT*FROM tracker.items");
            while (resultSet.next()) {
                item = new Item(resultSet.getString("user_name"),
                        resultSet.getString("descriptios"));
                list.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

