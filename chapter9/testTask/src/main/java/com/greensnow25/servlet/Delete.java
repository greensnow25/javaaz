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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Public class Delete.
 *
 * @author greensnow25.
 * @version 1.
 * @since 18.10.2017.
 */
public class Delete extends HttpServlet {
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
        HttpSession session = req.getSession();
        String role = (String) session.getAttribute("userRole");
        String deleteName = req.getParameter("deleteUser");
        if (role.equals("ADMIN")) {

            try (Connection connection = this.connection.getConnection()) {
                connection.setAutoCommit(false);
                UserDAOImpl userDAO = new UserDAOImpl(connection);
                AddressDAOImpl addressDAO = new AddressDAOImpl(connection);
                User user = userDAO.getOneByName(deleteName);
                int id = user.getId();
                userDAO.delete(new User(deleteName, null, 0));
                addressDAO.delete(new Address(null, null, id));
                connection.commit();
                req.getRequestDispatcher("/showTable").forward(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
    }
}
