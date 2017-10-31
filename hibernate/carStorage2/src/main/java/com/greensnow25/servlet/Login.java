package com.greensnow25.servlet;

import com.greensnow25.hibernate.SingletonSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Public class Login.
 *
 * @author greensnow25.
 * @version 1.
 * @since 31.10.2017.
 */
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        SessionFactory factory = SingletonSessionFactory.getInstance();
        Transaction tr = null;
        try (Session session = factory.openSession()) {
            tr = session.beginTransaction();
            Query query = session.createQuery("from User where User.name=:param1 and User.password =:param2");
            query.setParameter("param1", login);
            query.setParameter("param2", password);
            List l = query.list();
            if(l.size() ==1){
                req.getSession().setAttribute("enter", true);
            }
            req.getRequestDispatcher("index.html").forward(req,resp);
        }
    }
}
