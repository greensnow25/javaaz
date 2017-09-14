package com.greensnow25;

import com.greensnow25.db.DBOperations;
import com.greensnow25.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.*;
import java.util.Date;
import java.util.List;

/**
 * Public class SympleServlet.
 *
 * @author greensnow25.
 * @version 1.
 * @since 08.09.2017.
 */
public class SimpleServlet extends HttpServlet {
    /**
     * logger.
     */
    private Logger l = LoggerFactory.getLogger(getClass());

    /**
     * Db operations.
     */
    private DBOperations dbOperations;

    /**
     * init.
     *
     * @throws ServletException ex.
     */
    @Override
    public void init() throws ServletException {
        this.dbOperations = new DBOperations(Runtime.getRuntime().availableProcessors());
        super.init();
    }

    /**
     * print table.
     *
     * @param req  rec.
     * @param resp resp.
     * @throws ServletException ex.
     * @throws IOException      ex.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List res = null;
        try {
            res = dbOperations.showTable();
        } catch (SQLException e) {
            l.warn(e.getMessage(), e);
        }
        req.getSession().setAttribute("userList", res);
        req.getRequestDispatcher("jsp/result/result.jsp").forward(req, resp);

    }

    /**
     * The method looks redirects the request for further sorting.
     *
     * @param req  re.
     * @param resp re.
     * @throws ServletException ex.
     * @throws IOException      ex.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.dispatcher(req, resp);
    }

    /**
     * update.
     *
     * @param req  re.
     * @param resp re.
     * @throws ServletException ex.
     * @throws IOException      ex.
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Boolean res;
        String login = req.getParameter("login");
        String mail = req.getParameter("newMail");
        res = this.dbOperations.updateMail(login, mail);
        req.getSession().setAttribute("result", res.toString());
        req.getRequestDispatcher("jsp/result/result.jsp").forward(req, resp);
    }

    /**
     * delete.
     *
     * @param req  re.
     * @param resp re.
     * @throws ServletException ex.
     * @throws IOException      ex.
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Boolean res;
        String login = req.getParameter("login");
        res = this.dbOperations.deleteUser(login);
        req.getSession().setAttribute("result", res.toString());
        req.getRequestDispatcher("jsp/result/result.jsp").forward(req, resp);
    }

    /**
     * add.
     *
     * @param req  rec.
     * @param resp resp.
     * @throws ServletException ex.
     * @throws IOException      ex.
     */
    public void myDoPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Boolean res;
        User user = new User(req.getParameter("login"), req.getParameter("eMail"),
                new Timestamp(new Date().getTime()));
        res = dbOperations.addToBase(user);
        req.getSession().setAttribute("result", res.toString());
        req.getRequestDispatcher("/jsp/result/result.jsp").forward(req, resp);
    }

    /**
     * dispatcher.
     *
     * @param req  rec.
     * @param resp resp.
     * @throws ServletException ex.
     * @throws IOException      ex.
     */
    public void dispatcher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("operation").equals("read")) {
            this.doGet(req, resp);
        } else if (req.getParameter("operation").equals("update")) {
            this.doPut(req, resp);
        } else if (req.getParameter("operation").equals("delete")) {
            this.doDelete(req, resp);
        } else {
            this.myDoPost(req, resp);
        }
    }

}
