package com.greensnow25.servlet;

import com.greensnow25.dao.UserDAOImpl;
import com.greensnow25.dataBase.CreateConnection;
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
import java.util.Collection;
import java.util.List;

/**
 * Public class EditHimself.
 *
 * @author greensnow25.
 * @version 1.
 * @since 18.10.2017.
 */
public class EditHimself extends HttpServlet {

    private CreateConnection connection;

    @Override
    public void init() throws ServletException {
        this.connection = new CreateConnection();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String name = (String) session.getAttribute("userName");
        String newName = (String) session.getAttribute("newName");
        try (Connection connection = this.connection.getConnection()) {
            UserDAOImpl userDAO = new UserDAOImpl(connection);
            UserSQLRepository repository = new UserSQLRepository(connection);
            List<User> list = repository.query(new UserByNameSQLSpecification(name));
            User user = list.get(0);
            user.setName(newName);
            userDAO.update(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
