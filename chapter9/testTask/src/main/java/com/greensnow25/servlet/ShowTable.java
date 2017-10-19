package com.greensnow25.servlet;

import com.google.gson.Gson;
import com.greensnow25.dataBase.CreateConnection;
import com.greensnow25.entity.User;
import com.greensnow25.repository.SelectAllUsers;
import com.greensnow25.repository.UserSQLRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Public class ShowTable.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.10.2017.
 */
public class ShowTable extends HttpServlet {
    /**
     * connection pool.
     */
    private CreateConnection connection;

    @Override
    public void init() throws ServletException {
        this.connection = new CreateConnection();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/wiev/result.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Connection connection = this.connection.getConnection();
            UserSQLRepository repository = new UserSQLRepository(connection);
            List<User> list = repository.query(new SelectAllUsers());
            String json = new Gson().toJson(list);
            PrintWriter writer = resp.getWriter();
            writer.write(json);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
