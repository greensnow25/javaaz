package com.greensnow25.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Public class Redirect.
 *
 * @author greensnow25.
 * @version 1.
 * @since 31.08.2017.
 */
public class Redirect extends HttpServlet {
    private static int count = 0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        count++;
        req.setAttribute("current_count: ", count);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
