package com.elearning.servlets;

import com.elearning.db.EnrollmentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CompletionServlet")
public class CompletionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get courseId and studentId from the request
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        int studentId = Integer.parseInt(request.getParameter("studentId"));

        EnrollmentDAO enrollmentDAO = new EnrollmentDAO();
        
        // Mark the course as completed
        enrollmentDAO.markCourseAsCompleted(courseId, studentId);

        // Redirect to the user's dashboard after completion
        response.sendRedirect("dashboard.jsp");
    }
}
