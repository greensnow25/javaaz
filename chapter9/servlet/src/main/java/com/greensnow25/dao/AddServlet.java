package com.greensnow25.dao;

import com.greensnow25.db.DBOperations;
import com.greensnow25.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Public class AddServlet.
 *
 * @author greensnow25.
 * @version 1.
 * @since 14.09.2017.
 */
@WebServlet(urlPatterns = "/add")
public class AddServlet extends HttpServlet {
    /**
     * Data base connector.
     */
    private DBOperations dbOperations;

    @Override
    public void init() throws ServletException {
        this.dbOperations = new DBOperations(Runtime.getRuntime().availableProcessors());
        super.init();
    }

    @Override

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User(req.getParameter("login"), req.getParameter("eMail"),
                new Timestamp(new Date().getTime()));
        Boolean res = dbOperations.addToBase(user);
        req.getSession().setAttribute("result", res.toString());
        req.getRequestDispatcher("WEB-INF/jsp/result/result.jsp").forward(req, resp);
    }
}

