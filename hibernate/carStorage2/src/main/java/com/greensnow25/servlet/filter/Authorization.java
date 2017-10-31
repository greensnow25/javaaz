package com.greensnow25.servlet.filter;

import com.greensnow25.hibernate.SingletonSessionFactory;
import org.apache.catalina.servlet4preview.http.HttpFilter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Public class Authorization.
 *
 * @author greensnow25.
 * @version 1.
 * @since 31.10.2017.
 */
public class Authorization extends HttpFilter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
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
            if (l.size() == 1) {
                req.getSession().setAttribute("enter", true);
            } else {
                request.getRequestDispatcher("login.html").forward(req, resp);
            }


        }
    }

}

    @Override
    public void destroy() {

    }
}
