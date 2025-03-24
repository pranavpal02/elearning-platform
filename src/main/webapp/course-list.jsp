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
    <title>All Courses</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f0f4f8;
            margin: 0;
            padding: 20px;
        }

        h2 {
            text-align: center;
            color: #2c3e50;
        }

        .course-grid {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
            padding: 20px;
        }

        .course-card {
            background: #fff;
            width: 300px;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0px 4px 10px rgba(0,0,0,0.1);
            transition: transform 0.3s ease;
            text-decoration: none;
            color: inherit;
        }

        .course-card:hover {
            transform: translateY(-5px);
        }

        .course-card img {
            width: 100%;
            height: 180px;
            object-fit: cover;
        }

        .course-content {
            padding: 15px;
        }

        .course-content h3 {
            margin: 0 0 10px;
            font-size: 20px;
            color: #4CAF50;
        }

        .course-content p {
            font-size: 14px;
            color: #555;
            height: 50px;
            overflow: hidden;
        }
    </style>
</head>
<body>

<h2>All Courses</h2>

<div class="course-grid">
    <% 
        if (courses == null || courses.isEmpty()) { 
    %>
        <p>No courses available</p>
    <% 
        } else {
            for (Course course : courses) {
    %>
        <a class="course-card" href="enroll.jsp?id=<%= course.getCourseId() %>">
            <img src="images/<%= course.getCourseImage() != null ? course.getCourseImage() : "default.jpg" %>" alt="<%= course.getCourseName() %>">
            <div class="course-content">
                <h3><%= course.getCourseName() %></h3>
                <p><%= course.getDescription() != null ? course.getDescription() : "No description available" %></p>
            </div>
        </a>
    <% 
            } 
        }
    %>
</div>

</body>
</html>
