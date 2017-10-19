package com.greensnow25.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Public class LogOut.
 *
 * @author greensnow25.
 * @version 1.
 * @since 18.10.2017.
 */
public class LogOut extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        HttpSession session = req.getSession(false);
        for (Cookie c : req.getCookies()) {
            if (c != null && c.getName().equals("userName")) {
                Cookie cookie = new Cookie("userName", null);
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
                session.invalidate();
                break;
            }
        }
        req.getRequestDispatcher("index.jsp").forward(req, resp);


    }
}
