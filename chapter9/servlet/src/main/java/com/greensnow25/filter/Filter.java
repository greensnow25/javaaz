package com.greensnow25.filter;

import org.apache.catalina.servlet4preview.http.HttpFilter;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Public class Filter.
 *
 * @author greensnow25.
 * @version 1.
 * @since 15.09.2017.
 */
@WebFilter(urlPatterns = "")
public class Filter extends HttpFilter {

    @Override
    public void destroy() {
    }

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
    String user = request.getParameter("user");
    String pwd = request.getParameter("password");

    if(user!=null || !user.equals("")){
        request.getSession().
    }
    }
}
