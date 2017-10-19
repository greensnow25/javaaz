package com.greensnow25.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Public class Actions.
 *
 * @author greensnow25.
 * @version 1.
 * @since 18.10.2017.
 */
//@WebServlet(urlPatterns = "action")
public class Actions extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("userAction");
        if (action.equals("addNewUser")) {
            req.getRequestDispatcher("/createUser").forward(req, resp);
        } else if (action.equals("editHimself")) {
            req.getRequestDispatcher("/editHimself").forward(req, resp);
        } else if (action.equals("editOtherUser")) {
            req.getRequestDispatcher("/editOtherUser").forward(req, resp);
        } else if (action.equals("deleteUser")) {
            req.getRequestDispatcher("/deleteUser").forward(req, resp);
        }

    }
}
