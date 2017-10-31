package com.greensnow25.servlet;


import com.google.gson.Gson;
import com.greensnow25.hibernate.SingletonSessionFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Public class SearchFilter.
 *
 * @author greensnow25.
 * @version 1.
 * @since 27.10.2017.
 */
public class SelectModel extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionFactory factory = SingletonSessionFactory.getInstance();
        Transaction tr = null;
        try (Session session = factory.openSession()) {
            tr = session.beginTransaction();
            Query query = session.createQuery("select C.name  from com.greensnow25.model.Brand as C group by C.name");
            List list = query.list();
            tr.commit();
            resp.getWriter().write(new Gson().toJson(list));
        } catch (HibernateException e) {
            if (tr != null) {
                tr.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionFactory factory = SingletonSessionFactory.getInstance();
        Transaction tr = null;
        List<List> resultList = new ArrayList<>();
        try (Session session = factory.openSession()) {
            tr = session.beginTransaction();
            String brand = req.getParameter("brand");
            Query queryModel = session.createQuery("select M.model from com.greensnow25.model.Model As M where M.brand = :param1");
            queryModel.setParameter("param1", brand);
            Query queryEngine = session.createQuery("from com.greensnow25.model.Engine");
            Query queryBody = session.createQuery("from com.greensnow25.model.Body");
            Query queryTransmission = session.createQuery("from com.greensnow25.model.Transmission");

//            JSONObject jsonObject = new JSONObject();

//            Gson json = new Gson();

//
//            jsonObject.put("model", json.toJson(queryModel.list()));
//            jsonObject.put("transmission", json.toJson(queryTransmission.list()));
//            jsonObject.put("engine", json.toJson(queryEngine.list()));
//            jsonObject.put("body", json.toJson(queryBody.list()));

            resultList.add(queryModel.list());
            resultList.add(queryBody.list());
            resultList.add(queryEngine.list());
            resultList.add(queryTransmission.list());
            List l = queryModel.list();
            tr.commit();
            String d = new Gson().toJson(resultList);
            resp.getWriter().write(new Gson().toJson(resultList));

            //    resp.getWriter().write(jsonObject.toJSONString());
        } catch (HibernateException e) {
            if (tr != null) {
                tr.rollback();
            }
            e.printStackTrace();
        }
    }
}
