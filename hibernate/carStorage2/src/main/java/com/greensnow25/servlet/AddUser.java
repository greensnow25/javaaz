package com.greensnow25.servlet;

import com.google.gson.Gson;
import com.greensnow25.hibernate.SingletonSessionFactory;
import com.greensnow25.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Public class AddUser.
 *
 * @author greensnow25.
 * @version 1.
 * @since 01.11.2017.
 */
@WebServlet(urlPatterns = "/addUser")
public class AddUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionFactory factory = SingletonSessionFactory.getInstance();
        Transaction tr = null;
        try (Session session = factory.openSession()) {
            tr = session.beginTransaction();
            String name = req.getParameter("login");
            String password = req.getParameter("password");
            session.save(new User(name, password));
            tr.commit();
            resp.getWriter().write(new Gson().toJson("user added"));
        } catch (HibernateException e) {
            if (tr != null) {
                tr.rollback();
            }
            e.printStackTrace();
        }
    }
}
