package com.greensnow25.filter;

import com.greensnow25.db.ConnectToUsersBase;
import com.greensnow25.db.CreateConnection;
import org.apache.catalina.servlet4preview.http.HttpFilter;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Public class Filter.
 *
 * @author greensnow25.
 * @version 1.
 * @since 15.09.2017.
 */
@WebFilter(urlPatterns = "")
public class FilterAuthorization extends HttpFilter {
    private CreateConnection connection;

    @Override
    public void init() throws ServletException {
        this.connection = new CreateConnection();
        super.init();
    }

    @Override
    public void destroy() {
    }

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        ConnectToUsersBase connectBase = new ConnectToUsersBase(this.connection);
        String user = request.getParameter("user");
        String pwd = request.getParameter("password");

        try {
            if (connectBase.checkUser(user)) {
                chain.doFilter(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
