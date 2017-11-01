package com.greensnow25.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Public class LogOut.
 *
 * @author greensnow25.
 * @version 1.
 * @since 31.10.2017.
 */
public class LogOut extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("user") && cookie.getValue() != null) {
                cookie.setValue(null);
            }
        }
        HttpSession session = req.getSession(false);
        session.invalidate();
        req.getRequestDispatcher("login.html").forward(req, resp);
    }
}
