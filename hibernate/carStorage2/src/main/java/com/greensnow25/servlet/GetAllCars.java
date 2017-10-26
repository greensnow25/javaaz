package com.greensnow25.servlet;

import com.google.gson.Gson;
import com.greensnow25.hibernate.SingletonSessionFactory;
import org.hibernate.HibernateException;
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
 * Public class GetAllCars.
 *
 * @author greensnow25.
 * @version 1.
 * @since 25.10.2017.
 */
public class GetAllCars extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionFactory factory = SingletonSessionFactory.getInstance();
        Transaction transaction = null;
        try (Session session = factory.openSession();) {
            transaction = session.getTransaction();
            transaction.begin();
            Query query = session.createQuery("from com.greensnow25.model.Car");
            query.setReadOnly(true);
            List list = query.list();
            String json = new Gson().toJson(list);
            resp.getWriter().write(json);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }


    }
}
