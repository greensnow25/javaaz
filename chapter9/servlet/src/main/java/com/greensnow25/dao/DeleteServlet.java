package com.greensnow25.dao;

import com.greensnow25.db.DBOperations;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Public class DeleteServlet.
 *
 * @author greensnow25.
 * @version 1.
 * @since 14.09.2017.
 */
@WebServlet(urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {
    /**
     * Data base connector.
     */
    private DBOperations dbOperations;

    @Override
    public void init() throws ServletException {
        dbOperations = new DBOperations(Runtime.getRuntime().availableProcessors());
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        Boolean res = this.dbOperations.deleteUser(login);
        req.getSession().setAttribute("result", res.toString());
        req.getRequestDispatcher("WEB-INF/jsp/result/result.jsp").forward(req, resp);
    }
}
