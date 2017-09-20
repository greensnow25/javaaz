package com.greensnow25.dispathers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Public class RedirToWhoISWho.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.09.2017.
 */
@WebServlet(urlPatterns = "/actions")
public class RedirToWhoISWho extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/jsp/whoIsWho.jsp").forward(req, resp);
    }
}
