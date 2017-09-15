package com.greensnow25.db;

import java.sql.PreparedStatement;
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

    public ConnectToUsersBase() {
    this.connection = new CreateConnection();
    }
    public String checkUser(String name, String psw) throws SQLException {
String query = "";
        try(PreparedStatement st = connection.getConnection().prepareStatement(query)){

        }


    }
}
