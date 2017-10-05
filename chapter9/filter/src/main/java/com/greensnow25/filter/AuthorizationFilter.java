package com.greensnow25.filter;

import org.apache.catalina.servlet4preview.http.HttpFilter;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Public class AuthorizationFilter.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.09.2017.
 */
//@WebFilter(urlPatterns = "/login/*")
public class AuthorizationFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        boolean res = false;
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (request.getSession().isNew()) {
                    res = true;
                }
                if (cookie.getName().equals("user")) {

                    res = true;
                }
            }
        }
        if (res) {
            chain.doFilter(request, response);

        } else {
            request.getRequestDispatcher("/login").forward(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
