package com.greensnow25.servlet;

import com.google.gson.Gson;
import com.greensnow25.HibernateUtil;
import com.greensnow25.model.Item;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Public class ShowTable.
 *
 * @author greensnow25.
 * @version 1.
 * @since 20.10.2017.
 */
public class ShowTable extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HibernateUtil<Item> hibernateUtil = new HibernateUtil<>();
        Gson gson = new Gson();
        List list = hibernateUtil.getAllItems();
        resp.getWriter().write(gson.toJson(list));
    }
}
