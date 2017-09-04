package com.greensnow25.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Public class EchoServlet.
 *
 * @author greensnow25.
 * @version 1.
 * @since 04.09.2017.
 */
public class EchoServlet extends HttpServlet {
    /**
     * counter.
     */
    private static int count = 0;

    /**
     * doGEt.
     *
     * @param req  request.
     * @param resp response.
     * @throws ServletException ex.
     * @throws IOException      ex.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        PrintWriter pw = resp.getWriter();
//        count = (int) req.getAttribute("count");
//        count++;
//        pw.print("<h1>count:</h1>" + "wdw");
//        req.getRequestDispatcher("main.jsp").forward(req,resp);

        PrintWriter p = resp.getWriter();
        p.print("<h1>HELLO<h1>");
    }
}
