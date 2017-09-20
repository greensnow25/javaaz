package com.greensnow25.dao.adminRole;

import com.greensnow25.db.CreateConnection;
import com.greensnow25.db.editVisitior.EditUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Public class EditDB.
 *
 * @author greensnow25.
 * @version 1.
 * @since 20.09.2017.
 */
@WebServlet(urlPatterns = "/editUser")
public class EditUserServlet extends HttpServlet {
    /**
     * create connection.
     */
    private CreateConnection connection;

    @Override
    public void init() throws ServletException {
        this.connection = new CreateConnection();
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        if (operation != null) {
            req.setAttribute("operation", operation);
            req.getRequestDispatcher("WEB-INF/jsp/edit.jsp").forward(req, resp);
        } else {
            String oldName = req.getParameter("oldName");
            String currentUserName = null;
            String newName = req.getParameter("newName");
            String newPassword = req.getParameter("newPassword");
            EditUser editUser = new EditUser(this.connection);
            Cookie[] cookie = req.getCookies();

            for (Cookie c : cookie) {
                if (c.getName().equals("user") && oldName == null) {
                    currentUserName = c.getValue();
                    break;
                } else {
                    currentUserName = oldName;
                }
            }
            editUser.editHimSelf(currentUserName, newName, newPassword);
            List l = editUser.showAll();
            req.getSession().setAttribute("base", l);
            req.getRequestDispatcher("WEB-INF/jsp/result/result.jsp").forward(req, resp);

        }
    }
}
