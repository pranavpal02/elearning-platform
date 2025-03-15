<%@ page import="java.util.List, com.elearning.beans.Student" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Students List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2>Student List</h2>
        <table class="table table-striped">
            <tr><th>ID</th><th>Name</th><th>Course</th><th>Learning Mode</th><th>Status</th></tr>
            <%
                List<Student> students = (List<Student>) request.getAttribute("students");

                if (students != null && !students.isEmpty()) {
                    for (Student s : students) {
            %>
                <tr>
                    <td><%= s.getId() %></td>
                    <td><%= s.getName() %></td>
                    <td><%= s.getCourse() %></td>
                    <td><%= s.getLearningMode() %></td>
                    <td><%= s.getStatus() %></td>
                </tr>
            <% 
                    }
                } else {
            %>
                <tr><td colspan="5">No students found.</td></tr>
            <% } %>
        </table>
    </div>
</body>
</html>
