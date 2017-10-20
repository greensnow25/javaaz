package com.greensnow25.servlet;

import com.greensnow25.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Public class AddItem.
 *
 * @author greensnow25.
 * @version 1.
 * @since 20.10.2017.
 */
public class AddItem extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String description = req.getParameter("desc");
        String q = req.getParameter("done");
        boolean done = req.getParameter("done") != null;
        HibernateUtil hibernateUtil = new HibernateUtil();
        int i = hibernateUtil.addItem(description, done);
        PrintWriter writer = resp.getWriter();
        if (i > 0) {
            writer.write("Item added");
        } else {
            writer.write("Error try again.");
        }
    }
}
