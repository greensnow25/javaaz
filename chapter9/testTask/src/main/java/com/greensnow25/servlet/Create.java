package com.greensnow25.servlet;

import com.greensnow25.repository.dao.AddressDAOImpl;
import com.greensnow25.repository.dao.UserDAOImpl;
import com.greensnow25.dataBase.CreateConnection;
import com.greensnow25.entity.Address;
import com.greensnow25.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Public class Create.
 *
 * @author greensnow25.
 * @version 1.
 * @since 18.10.2017.
 */
public class Create extends HttpServlet {
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
        String newName = req.getParameter("newName");
        String newPassword = req.getParameter("newPassword");

        String country = req.getParameter("newCountry");
        String city = req.getParameter("newCity");

        try (Connection connection = this.connection.getConnection()) {
            connection.setAutoCommit(false);
            UserDAOImpl userDAO = new UserDAOImpl(connection);
            AddressDAOImpl addressDAO = new AddressDAOImpl(connection);
            userDAO.create(new User(newName, newPassword, 0));
            connection.commit();
            int id = userDAO.getOneByName(newName).getId();
            addressDAO.create(new Address(country, city, id));
            connection.commit();
            req.getRequestDispatcher("/showTable").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
