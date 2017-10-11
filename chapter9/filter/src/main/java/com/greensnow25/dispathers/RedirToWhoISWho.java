package com.greensnow25.dispathers;

import com.google.gson.Gson;
import com.greensnow25.db.ConnectToUsersBase;
import com.greensnow25.db.CreateConnection;
import com.greensnow25.model.visitors.RoleBase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

/**
 * Public class RedirToWhoISWho.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.09.2017.
 */
@WebServlet(urlPatterns = "/actions")
public class RedirToWhoISWho extends HttpServlet {

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession httpSession = req.getSession();
        String name = (String) httpSession.getAttribute("login");
        String role = connect.checkUserRole(false, name);

        List l = base.getMap().get(role);
        httpSession.setAttribute("canDo", l);
        httpSession.setAttribute("role", role);
        httpSession.setAttribute("login", name);
        httpSession.setMaxInactiveInterval(30 * 60);

        Cookie cookie = new Cookie("user", name);
        Cookie cookieRole = new Cookie(role, role);
        cookieRole.setMaxAge(30 * 60);
        cookie.setMaxAge(30 * 60);
        resp.addCookie(cookie);
        resp.addCookie(cookieRole);
        String jSon = new Gson().toJson(l);
        resp.getWriter().write(jSon);
    }
}
