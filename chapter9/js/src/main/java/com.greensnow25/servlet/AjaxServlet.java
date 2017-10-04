package com.greensnow25.servlet;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/AjaxAction/*")
public class AjaxServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("userName");

        if (userName.equals("")) {
            userName = "User name cannot be empty";
        } else {
            userName = "Hello " + userName;
        }
        response.setContentType("text/plain");
        response.getWriter().write(userName);
    }
}