package com.greensnow25.dao;

import com.greensnow25.db.ConnectToUsersBase;
import com.greensnow25.db.CreateConnection;
import com.sun.xml.internal.bind.v2.TODO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Public class Title.
 *
 * @author greensnow25.
 * @version 1.
 * @since 15.09.2017.
 */
@WebServlet(urlPatterns = "/login")
public class Title extends HttpServlet {

    private CreateConnection getConnection;

    @Override
    public void init() throws ServletException {
        this.getConnection = new CreateConnection();
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/login/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConnectToUsersBase connect = new ConnectToUsersBase(this.getConnection);
        String name = req.getParameter("login");
        String pwd = req.getParameter("password");
        try {
            if (connect.login(name, pwd)) {

                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("login", name);
                req.setAttribute("enter", true);
                httpSession.setMaxInactiveInterval(30 * 60);

                Cookie cookie = new Cookie("user", name);
                cookie.setMaxAge(30 * 60);
                resp.addCookie(cookie);

                req.getRequestDispatcher("WEB-INF/login/login.jsp").forward(req, resp);


            } else {
                req.getRequestDispatcher("WEB-INF/login/login.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
