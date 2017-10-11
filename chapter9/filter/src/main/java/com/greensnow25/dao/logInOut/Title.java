package com.greensnow25.dao.logInOut;

import com.google.gson.Gson;
import com.greensnow25.db.ConnectToUsersBase;
import com.greensnow25.db.CreateConnection;
import com.greensnow25.model.visitors.RoleBase;
import com.sun.istack.internal.NotNull;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


/**
 * Public class Title.
 *
 * @author greensnow25.
 * @version 1.
 * @since 15.09.2017.
 */
@WebServlet(urlPatterns = "/login")
public class Title extends HttpServlet {

    /**
     * connection.
     */
    private CreateConnection getConnection;
    /**
     * base.
     */
    private RoleBase base;
    /**
     *
     */
    private ConnectToUsersBase connect;

    @Override
    public void init() throws ServletException {
        if (this.getConnection == null) {
            this.getConnection = new CreateConnection();
        }
        if (connect == null) {
            this.connect = new ConnectToUsersBase(this.getConnection);
        }
        if (this.base == null) {
            this.base = new RoleBase();
        }
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/login/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String pwd = req.getParameter("password");
        try {
            Boolean access = connect.login(name, pwd);

            if (access) {
                resp.setContentType("text/plain");
                HttpSession httpSession = req.getSession();

                if (httpSession.getAttribute("enter") == null) {
                    String html = new Gson().toJson("Hi " + name + ", login successful!!!");
                    httpSession.setAttribute("login", name);
                    httpSession.setAttribute("enter", true);
                    resp.getWriter().write(html);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setGetConnection(CreateConnection getConnection) {
        this.getConnection = getConnection;
    }

    public void setBase(RoleBase base) {
        this.base = base;
    }

    public void setConnect(ConnectToUsersBase connect) {
        this.connect = connect;
    }
}
