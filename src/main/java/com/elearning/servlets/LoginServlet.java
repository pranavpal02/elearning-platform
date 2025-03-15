package com.elearning.servlets;

import com.elearning.beans.User;
import com.elearning.db.UserDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Assume userDAO is a class that handles database operations for user login
        UserDAO userDAO = new UserDAO();

        // Authenticate the user
        User user = userDAO.authenticateUser(username, password);

        if (user != null) {
            // If user is found, set the user object in session
            HttpSession session = request.getSession();
            session.setAttribute("currentUser", user);
            response.sendRedirect("dashboard.jsp"); // Redirect to dashboard after login
        } else {
            // If authentication fails, redirect to login page with error
            response.sendRedirect("login.jsp?error=invalidCredentials");
        }
    }
}
