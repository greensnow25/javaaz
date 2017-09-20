package com.greensnow25.dao.adminRole;

import com.greensnow25.db.CreateConnection;
import com.greensnow25.db.editVisitior.EditUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Public class EditRoleServlet.
 *
 * @author greensnow25.
 * @version 1.
 * @since 20.09.2017.
 */
@WebServlet(urlPatterns = "/editRole1")
public class EditRoleServlet extends HttpServlet {
    /**
     * create connection.
     */
    private CreateConnection connection;

    @Override
    public void init() throws ServletException {
        this.connection = new CreateConnection();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EditUser editUser = new EditUser(this.connection);
        String userName = req.getParameter("userName");
        String newRole = req.getParameter("newRole");
        editUser.editRole(userName, newRole);
        List l = editUser.showAll();
        req.getSession().setAttribute("base", l);
        req.getRequestDispatcher("WEB-INF/jsp/result/result.jsp").forward(req, resp);
    }
}
