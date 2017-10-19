package com.greensnow25.repository;

import com.greensnow25.entity.Address;
import com.greensnow25.entity.MusicType;
import com.greensnow25.entity.Role;
import com.greensnow25.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Public class User.
 *
 * @author greensnow25.
 * @version 1.
 * @since 12.10.2017.
 */
public class UserSQLRepository implements Repository<User> {

    private Connection connection;
    private final String QUERY = String.format("%s%s%s%s%s%s", "SELECT U.id_user, U.name, U.password, A.country, A.city, R.role, M.type ",
            "FROM servlet.controltask.user AS U",
            "  INNER JOIN servlet.controltask.address AS A ON U.id_user = A.id_address",
            "  INNER JOIN servlet.controltask.role AS R ON U.user_role = R.id_role",
            "  INNER JOIN servlet.controltask.user_musictype AS UM ON U.id_user = UM.id_user",
            "  INNER JOIN servlet.controltask.musictype AS M ON UM.id_musictype = M.id_musictype ");

    public UserSQLRepository(Connection connection) {
        this.connection = connection;
    }


    @Override
    public List<User> query(Specification specification) {
        SqlSpecification sqlSpecification = (SqlSpecification) specification;
        List<User> list = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(String.format("%s%s", QUERY, sqlSpecification.toSQLQuery()));) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id_user");
                String name = resultSet.getString("name");
                String country = resultSet.getString("country");
                String city = resultSet.getString("city");
                String role = resultSet.getString("role");
                String type = resultSet.getString("type");
                String pwd = resultSet.getString("password");
                list.add(new User(name, pwd, new Address(country, city, id), new MusicType(type, id), new Role(role, id), id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
