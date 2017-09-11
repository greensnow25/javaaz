package com.greensnow25.servlets;

import com.greensnow25.servlets.dao.CalculatorDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


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
    private int operCount = 0;
    /**
     * mutex.
     */
    private Object mutex = new Object();
    /**
     * constant.
     */
    private static final String COUNT = "number";
    /**
     * logger.
     */
    private Logger l = LoggerFactory.getLogger(getClass());

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

        l.info("OK");
        PrintWriter p = resp.getWriter();
        CalculatorDAO calc = new CalculatorDAO();

        int first = Integer.parseInt(req.getParameter("first"));
        int second = Integer.parseInt(req.getParameter("second"));
        String oper = req.getParameter("oper");
        int re = calc.doOperation(first, oper, second);
        String res = first + "+" + second + " = " + re;

        synchronized (this.mutex) {
            operCount++;
            req.getSession().setAttribute("counter", operCount);
            req.getSession().setAttribute(COUNT + operCount, res);
        }

        Enumeration en = req.getSession().getAttributeNames();
        while (en.hasMoreElements()) {
            String str = (String) en.nextElement();
            if (str.startsWith("number")) {
                p.print(req.getSession().getAttribute(str));
                p.print(System.getProperty("line.separator"));
            }
        }


    }
}
