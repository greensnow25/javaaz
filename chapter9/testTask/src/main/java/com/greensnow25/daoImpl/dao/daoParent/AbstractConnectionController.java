package com.greensnow25.daoImpl.dao.daoParent;

import org.postgresql.jdbc2.optional.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Public class AbstractConnectionController.
 *
 * @author greensnow25.
 * @version 1.
 * @since 11.10.2017.
 */
public abstract class AbstractConnectionController {
    private ConnectionPool connectionPool;
    private Connection connection;

    public AbstractConnectionController() {
        this.connectionPool = new ConnectionPool();
        try {
            this.connection = this.connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
