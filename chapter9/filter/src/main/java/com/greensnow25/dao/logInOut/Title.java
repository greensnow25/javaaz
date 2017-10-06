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

        String name = req.getParameter("login");
        String pwd = req.getParameter("password");
        try {
            if (connect.login(name, pwd)) {

                HttpSession httpSession = req.getSession();
                String role = connect.checkUserRole(false, name);

                List l = base.getMap().get(role);
                httpSession.setAttribute("canDo", l);


                httpSession.setAttribute("role", role);
                httpSession.setAttribute("login", name);
                httpSession.setAttribute("enter", true);
                httpSession.setMaxInactiveInterval(30 * 60);

                Cookie cookie = new Cookie("user", name);
                Cookie cookieRole = new Cookie(role, role);
                cookieRole.setMaxAge(30 * 60);
                cookie.setMaxAge(30 * 60);
                resp.addCookie(cookie);
                resp.addCookie(cookieRole);
                resp.setContentType("text/plain");
                String jSon = new Gson().toJson(l);

                resp.getWriter().write(jSon);

            }
            //       req.getRequestDispatcher("WEB-INF/login/login.jsp").forward(req, resp);
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
