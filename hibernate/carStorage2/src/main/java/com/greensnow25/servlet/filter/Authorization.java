package com.greensnow25.servlet.filter;

import com.greensnow25.hibernate.SingletonSessionFactory;
import com.greensnow25.model.User;
import org.apache.catalina.servlet4preview.http.HttpFilter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Public class Authorization.
 *
 * @author greensnow25.
 * @version 1.
 * @since 31.10.2017.
 */
//@WebFilter(urlPatterns = "/*")
public class Authorization extends HttpFilter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String uri = req.getRequestURI();

        HttpSession session = req.getSession(false);
        String user = null;
        if (session != null) {
            user = session.getAttribute("user").toString();
        }

        if ((uri.endsWith("login.html") || uri.endsWith("login") || uri.endsWith("jsp")
                || uri.endsWith("js") || uri.endsWith(".css")||(uri.endsWith("addUser"))|| uri.endsWith("selectModel"))) {
            chain.doFilter(req, resp);

        } else if (user != null) {
            chain.doFilter(req, resp);
            //            resp.getWriter().write("Bad login or password !!!");
//            req.getRequestDispatcher("/login").forward(req, resp);
        } else {
            resp.getWriter().write("Bad login or password !!!");
            req.getRequestDispatcher("/login").forward(req, resp);
        }
    }


    @Override
    public void destroy() {

    }
}
