package com.greensnow25;

import javax.xml.ws.Service;
import java.net.URL;
import java.sql.*;
import java.util.Enumeration;
import java.util.ServiceLoader;

/**
 * Public class JDBSDriver.
 *
 * @author greensnow25.
 * @version 1.
 * @since 02.08.2017.
 */
public class JDBCDriver {

    private static final String JDBC_URL = "jdbc:postgres:// 192.168.0.104/greensnow25";
    URL result = this.getClass().getClassLoader().getResource("jdbc:postgres://127.0.0.1/greensnow25");

    public void w() {
        ServiceLoader<Driver> drivers = ServiceLoader.load(Driver.class);
        for (Driver driver : drivers)
            System.out.println(driver);
    }

    public void q() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(JDBC_URL, "postgres", "tcrfylth");
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE tmp");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCDriver driver = new JDBCDriver();
        driver.w();
    }
}
