package com.elearning.servlets;

import com.elearning.beans.User;
import com.elearning.db.UserDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String role = "student";  // Default role, adjust as needed

        // Create a new user object and set its fields
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);  // In production, remember to hash the password!
        user.setEmail(email);
        user.setRole(role);

        // Call DAO method to register user in the database
        UserDAO dao = new UserDAO();
        boolean registered = dao.registerUser(user);

        if (registered) {
            // If registration is successful, redirect to login page
            response.sendRedirect("login.jsp?msg=registered");
        } else {
            // If registration fails, send back to registration page with error message
            response.sendRedirect("register.jsp?error=Registration failed, try again");
        }
    }
}
