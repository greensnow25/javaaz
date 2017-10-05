package com.greensnow25.ajax;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Public class AjaxController.
 *
 * @author greensnow25.
 * @version 1.
 * @since 02.10.2017.
 */
@WebServlet(urlPatterns = "/ajax")
public class AjaxController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        resp.setContentType("text/plain");


        resp.getWriter().write("111111111111111111111111111111111111111111111111111");

    }

}
