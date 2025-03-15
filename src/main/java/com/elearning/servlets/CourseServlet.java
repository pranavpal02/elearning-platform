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
        
        String courseName = request.getParameter("courseName");
        String courseDescription = request.getParameter("courseDescription");
        String videoUrl = request.getParameter("videoUrl");

        CourseDAO courseDAO = new CourseDAO();
        
        try {
            courseDAO.addCourse(courseName, courseDescription, videoUrl);  // Now with video URL
            response.sendRedirect("course-list.jsp");  // Redirect to the course list after adding
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
