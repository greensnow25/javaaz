package com.greensnow25.servlet;

import com.greensnow25.hibernate.SingletonSessionFactory;
import com.greensnow25.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.servlet.ServletException;
import javax.servlet.http.*;
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
            Query query = session.createQuery("from User as U where U.name=:param1 and U.password =:param2");
            query.setParameter("param1", login);
            query.setParameter("param2", password);
            List<User> l = query.list();
            tr.commit();

            User u = l.get(0);
            if (u.getName().equals(login) && u.getPassword().equals(password)) {
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("user", login);
                httpSession.setMaxInactiveInterval(30 * 60);
                Cookie cookie = new Cookie("user", login);
                cookie.setMaxAge(30 * 60);
                resp.addCookie(cookie);
//                req.getRequestDispatcher("index.html").forward(req, resp);
               // resp.sendRedirect("/login");
            }
//            else {
//                req.getRequestDispatcher("login.html").forward(req, resp);
//            }

        } catch (HibernateException e) {
            if (tr != null) {
                tr.rollback();
            }
            e.printStackTrace();
        }
    }
}
