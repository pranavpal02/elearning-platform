package com.elearning.servlets;

import com.elearning.db.CourseDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CourseServlet")
public class CourseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Get parameters from the form submission
        String courseName = request.getParameter("courseName");
        String courseDescription = request.getParameter("courseDescription");
        String videoUrl = request.getParameter("videoUrl");
        String category = request.getParameter("category"); // New: Category field

        // Check for missing required fields
        if (courseName == null || courseName.trim().isEmpty() ||
            courseDescription == null || courseDescription.trim().isEmpty() ||
            videoUrl == null || videoUrl.trim().isEmpty() ||
            category == null || category.trim().isEmpty()) {
            
            request.setAttribute("errorMessage", "All fields are required.");
            request.getRequestDispatcher("add-course.jsp").forward(request, response);
            return;
        }

        CourseDAO courseDAO = new CourseDAO();
        
        try {
            boolean isAdded = courseDAO.addCourse(courseName, courseDescription, videoUrl, category);
            if (isAdded) {
                response.sendRedirect("course-list.jsp"); // Redirect to course list after successful addition
            } else {
                request.setAttribute("errorMessage", "Failed to add course.");
                request.getRequestDispatcher("add-course.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred while adding the course.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
