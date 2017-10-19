package com.greensnow25.servlet;

import com.greensnow25.repository.dao.UserDAOImpl;
import com.greensnow25.dataBase.CreateConnection;
import com.greensnow25.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Public class EditOtherUser.
 *
 * @author greensnow25.
 * @version 1.
 * @since 18.10.2017.
 */
public class EditOtherUser extends HttpServlet {
    /**
     * connection pool.
     */
    private CreateConnection connection;

    @Override
    public void init() throws ServletException {
        this.connection = new CreateConnection();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("userOldName");
        String newName = req.getParameter("newName");
        try (Connection connection = this.connection.getConnection()) {
            UserDAOImpl userDAO = new UserDAOImpl(connection);
            User user = userDAO.getOneByName(name);
            user.setName(newName);
            userDAO.update(user);
            req.getRequestDispatcher("/showTable").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

