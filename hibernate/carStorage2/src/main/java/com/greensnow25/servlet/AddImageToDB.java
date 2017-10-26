package com.greensnow25.servlet;

import com.greensnow25.hibernate.SingletonSessionFactory;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Public class AddImageToDB.
 *
 * @author greensnow25.
 * @version 1.
 * @since 25.10.2017.
 */
public class AddImageToDB extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionFactory factory = SingletonSessionFactory.getInstance();
        String name = req.getParameter("name");
        System.out.println(name);
    }
}
