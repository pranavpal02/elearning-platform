<%@ page import="java.util.List" %>
<%@ page import="com.elearning.db.CourseDAO" %>
<%@ page import="com.elearning.beans.Course" %>

<%
    CourseDAO courseDAO = new CourseDAO();
    List<Course> courses = courseDAO.getAllCourses();  // Get all courses from DB
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Course List</title>
</head>
<body>

<h2>All Courses</h2>

<table>
    <thead>
        <tr>
            <th>Course Name</th>
            <th>Description</th>
            <th>Video URL</th>
        </tr>
    </thead>
    <tbody>
        <% for (Course course : courses) { %>
            <tr>
                <td><%= course.getCourseName() %></td>
                <td><%= course.getDescription() %></td>
                <td><a href="<%= course.getVideoUrl() %>" target="_blank">Watch Video</a></td>
            </tr>
        <% } %>
    </tbody>
</table>

</body>
</html>
