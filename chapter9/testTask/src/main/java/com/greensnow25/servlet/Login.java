package com.greensnow25.servlet;

import com.google.gson.Gson;
import com.greensnow25.dataBase.CreateConnection;
import com.greensnow25.entity.User;
import com.greensnow25.entity.userRights.Rights;
import com.greensnow25.repository.UserLoginSQLSpecification;
import com.greensnow25.repository.UserSQLRepository;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Public class Login.
 *
 * @author greensnow25.
 * @version 1.
 * @since 17.10.2017.
 */
//@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {
    private CreateConnection connection;


    @Override
    public void init() throws ServletException {
        this.connection = new CreateConnection();
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        List<User> list = null;
        String role = null;
        try (Connection con = connection.getConnection()) {
            UserSQLRepository repository = new UserSQLRepository(con);
            list = new ArrayList();
            list = repository.query(new UserLoginSQLSpecification(name, pwd));
            role = list.get(0).getRole().getRole();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PrintWriter writer = resp.getWriter();
        Gson gson = new Gson();
        if (!list.isEmpty()) {
            addSession(req, resp, name, role);
            //writer.write(String.format("Hello, %s login successful!!!", name));
            for (Rights rights : Rights.values()) {
                if (rights.name().equals(role)) {
                    String s = gson.toJson(rights.getRights());
                    //s+=String.format("hello\":\"Hello, %s login successful!!!", name);
                    writer.write(s);
                    break;
                }
            }
        } else {
            writer.write("Incorect name or password");
        }
    }

    private void addSession(HttpServletRequest req, HttpServletResponse resp, String userName, String role) {
        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(60 * 1000);
        session.setAttribute("userName", userName);
        session.setAttribute("userRole", role);
        Cookie cookie = new Cookie("userName", userName);
        cookie.setMaxAge(60 * 1000);
        resp.addCookie(cookie);
    }
}
