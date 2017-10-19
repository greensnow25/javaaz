package com.greensnow25.servlet;

import com.greensnow25.dao.AddressDAOImpl;
import com.greensnow25.dao.UserDAOImpl;
import com.greensnow25.dataBase.CreateConnection;
import com.greensnow25.entity.Address;
import com.greensnow25.entity.User;
import com.greensnow25.repository.UserByNameSQLSpecification;
import com.greensnow25.repository.UserSQLRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Public class Delete.
 *
 * @author greensnow25.
 * @version 1.
 * @since 18.10.2017.
 */
public class Delete extends HttpServlet {
    private CreateConnection connection;

    @Override
    public void init() throws ServletException {
        this.connection = new CreateConnection();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String role = (String) session.getAttribute("userRole");
//        String name = (String) session.getAttribute("userName");
//        String newName = (String) session.getAttribute("newName");
//        String newPassword = (String) session.getAttribute("newPassword");

        String country = req.getParameter("country");
        String city = req.getParameter("city");
        String deleteName = req.getParameter("deleteUser");
        if (role.equals("ADMIN")) {

            try (Connection connection = this.connection.getConnection()) {
                UserDAOImpl userDAO = new UserDAOImpl(connection);
                AddressDAOImpl addressDAO = new AddressDAOImpl(connection);
                //  RoleDAOImpl roleDAO = new RoleDAOImpl(connection);
                //  MusicTypeDAOImpl musicTypeDAO = new MusicTypeDAOImpl(connection);

                UserSQLRepository repository = new UserSQLRepository(connection);
                List<User> list = repository.query(new UserByNameSQLSpecification(deleteName));
                User user = list.get(0);
                int id = user.getId();
                userDAO.delete(new User(deleteName, null, 0));
                addressDAO.delete(new Address(null, null, id));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
