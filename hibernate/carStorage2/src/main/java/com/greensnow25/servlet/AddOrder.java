package com.greensnow25.servlet;

import com.google.gson.Gson;
import com.greensnow25.hibernate.SingletonSessionFactory;
import com.greensnow25.model.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Public class AddOrder.
 *
 * @author greensnow25.
 * @version 1.
 * @since 02.11.2017.
 */
@WebServlet(urlPatterns = "/addOrder")
public class AddOrder extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionFactory factory = SingletonSessionFactory.getInstance();
        Transaction tr = null;
        try (Session session = factory.openSession()) {
            tr = session.beginTransaction();
            String advertisement = req.getParameter("text");
            String carName = req.getParameter("carName");
            String body = req.getParameter("body");
            String brand = req.getParameter("brand");
            String model = req.getParameter("model");
            String engine = req.getParameter("engine");
            String transmission = req.getParameter("transmission");
            int price = Integer.parseInt(req.getParameter("price"));
            boolean sold = req.getParameter("sold").equals("no");

            String userName = (String) req.getSession().getAttribute("user");

            session.save(new Order(new Car(carName, new Brand(brand), new Body(body), new Transmission(transmission), new Engine(engine),
                    new Model(model), new User(userName), price), advertisement,sold ));
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