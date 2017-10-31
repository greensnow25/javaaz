package com.greensnow25.servlet;

import com.google.gson.Gson;
import com.greensnow25.hibernate.SingletonSessionFactory;
import com.greensnow25.model.*;
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
import java.util.*;

/**
 * Public class FindCar.
 *
 * @author greensnow25.
 * @version 1.
 * @since 30.10.2017.
 */
public class FindCar extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String brand = this.startWith(req.getParameter("brand"));
        String model = this.startWith(req.getParameter("model"));
        String engine = this.startWith(req.getParameter("engine"));
        String body = this.startWith(req.getParameter("body"));
        String transmission = this.startWith(req.getParameter("transmission"));

        Map<String, String> list = new HashMap<>();
        list.putIfAbsent("brands", brand);
        list.putIfAbsent("model", model);
        list.putIfAbsent("engine", engine);
        list.putIfAbsent("body", body);
        list.putIfAbsent("transmission", transmission);

        while (list.values().remove(null)) ;

        SessionFactory factory = SingletonSessionFactory.getInstance();
        Transaction tr = null;
        try (Session session = factory.openSession()) {
            tr = session.beginTransaction();
            Query query = session.createQuery(this.makeQuery(list));
            String answer = new Gson().toJson(query.list());

            tr.commit();
            resp.getWriter().write(answer);
            req.getSession().setAttribute("car", answer);
            req.getRequestDispatcher("wiev/findCar.jsp").forward(req, resp);

        } catch (HibernateException e) {
            if (tr != null) {
                tr.rollback();
            }
            e.printStackTrace();
        }
    }


    private String startWith(String string) {
        return string.startsWith("---") ? null : string;
    }

    private String makeQuery(Map map) {
        String query = "from Car as C where ";
        Iterator<Map.Entry> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry curr = iterator.next();
            query += "C." + curr.getKey() + ".name = \'" + (String) curr.getValue() + "\' AND ";
        }
        query = query.replaceAll("class", " ");
        int lastWordPos = query.lastIndexOf("AND ");
        query = query.substring(0, lastWordPos);

        System.out.println(query);
        return query;
    }

}
