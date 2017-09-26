package com.greensnow25.dao.logInOut;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Public class LogOut.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.09.2017.
 */
@WebServlet(urlPatterns = "/logout")
public class LogOut extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        HttpSession session = req.getSession(false);
        for (Cookie c : req.getCookies()) {
            if (c != null && c.getName().equals("user")) {
                Cookie cookie = new Cookie("user", null);
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
                session.invalidate();
                break;
            }
        }
        req.getRequestDispatcher("WEB-INF/login/login.jsp").forward(req, resp);


    }
}
