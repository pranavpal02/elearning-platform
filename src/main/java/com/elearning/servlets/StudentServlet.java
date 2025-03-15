package com.elearning.servlets;

import com.elearning.beans.Student;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Creating a sample list of students
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "John Doe", "Java Programming", "Online", "Active"));
        students.add(new Student(2, "Jane Smith", "Python Programming", "Offline", "Inactive"));

        // Set students list in request scope
        request.setAttribute("students", students);

        // Forward request to students.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("students.jsp");
        dispatcher.forward(request, response);
    }
}
