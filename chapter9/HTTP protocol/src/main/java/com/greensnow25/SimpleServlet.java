package com.greensnow25;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Public class SympleServlet.
 *
 * @author greensnow25.
 * @version 1.
 * @since 08.09.2017.
 */
public class SimpleServlet extends HttpServlet {
    /**
     *
     */
    private Connection connection = null;
    /**
     * logger.
     */
    Logger l = LoggerFactory.getLogger(getClass());

    /**
     * @param config conf.
     * @throws ServletException ex.
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            Class.forName(config.getInitParameter("driver"));
            this.connection = DriverManager.getConnection(config.getInitParameter("URL"),
                    config.getInitParameter("userName"),
                    config.getInitParameter("password"));
            System.out.println(config.getInitParameter("userName"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param req  rec.
     * @param resp resp.
     * @throws ServletException ex.
     * @throws IOException      ex.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.addToBase(req, resp);
        req.getRequestDispatcher("index1.jsp").forward(req, resp);
    }

    /**
     * @param req  re.
     * @param resp re.
     * @throws ServletException ex.
     * @throws IOException      ex.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.addToBase(req, resp);
        req.getRequestDispatcher("index2.jsp").forward(req, resp);
    }

    /**
     * @param req  re.
     * @param resp re.
     * @throws ServletException ex.
     * @throws IOException      ex.
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    /**
     * @param req  re.
     * @param resp re.
     * @throws ServletException ex.
     * @throws IOException      ex.
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

    public void addToBase(HttpServletRequest req, HttpServletResponse resp) {
        String login = req.getParameter("login");
        String eMail = req.getParameter("eMail");
        Date date = new Date();
        Timestamp time = new Timestamp(date.getTime());
        String query = "INSERT INTO users (login, e_mail, crete_date) VALUES (?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, login);
            st.setString(2, eMail);
            st.setTimestamp(3, time);
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
