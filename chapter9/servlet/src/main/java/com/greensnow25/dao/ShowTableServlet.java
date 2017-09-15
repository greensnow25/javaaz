package com.greensnow25.dao;

import com.greensnow25.db.DBOperations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Public class ShowTableServlet.
 *
 * @author greensnow25.
 * @version 1.
 * @since 14.09.2017.
 */
@WebServlet(urlPatterns = "/show")
public class ShowTableServlet extends HttpServlet {
    /**
     * Data base connector.
     */
    private DBOperations dbOperations;
    /**
     * logger.
     */
    private Logger l = LoggerFactory.getLogger(getClass());

    @Override
    public void init() throws ServletException {
        this.dbOperations = new DBOperations(Runtime.getRuntime().availableProcessors());
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List res = null;
        try {
            res = dbOperations.showTable();
        } catch (SQLException e) {
            l.warn(e.getMessage(), e);
        }
        req.getSession().setAttribute("userList", res);
        req.getRequestDispatcher("WEB-INF/jsp/result/result.jsp").forward(req, resp);

    }
}
