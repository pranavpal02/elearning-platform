<%@ page import="java.util.List" %>
<%@ page import="com.elearning.beans.Course" %>
<%@ page import="com.elearning.db.CourseDAO" %>
<%@ page import="com.elearning.beans.Certificate" %>
<%@ page import="com.elearning.db.CertificateDAO" %>

<%
    CourseDAO courseDAO = new CourseDAO();
    List<Course> aiCourses = courseDAO.getCoursesByCategory("AI");
    List<Course> cyberSecurityCourses = courseDAO.getCoursesByCategory("Cyber Security");
    List<Course> webDevelopmentCourses = courseDAO.getCoursesByCategory("Web Development");
    List<Course> otherCourses = courseDAO.getCoursesByCategory("Other");

    String username = (String) session.getAttribute("username");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - eLearning Platform</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            min-height: 100vh;
            margin: 0;
        }

        header {
            background-color: #4CAF50;
            color: white;
            padding: 20px;
            text-align: center;
            width: 100%;
        }

        .sidebar {
            height: 100%;
            width: 250px;
            background-color: #333;
            color: white;
            position: fixed;
            top: 0;
            left: 0;
            padding-top: 20px;
        }

        .sidebar a {
            padding: 10px 15px;
            text-decoration: none;
            font-size: 18px;
            color: white;
            display: block;
            transition: background-color 0.3s ease;
        }

        .sidebar a:hover {
            background-color: #575757;
        }

        .sidebar .active {
            background-color: #4CAF50;
        }

        .main-content {
            margin-left: 250px;
            padding: 20px;
            width: 100%;
        }

        .slider {
            width: 100%;
            height: 400px;
            background: url('images/ai-course.jpg') center center no-repeat;
            background-size: cover;
            position: relative;
            cursor: pointer;
        }

        .slider h2 {
            position: absolute;
            bottom: 20px;
            left: 20px;
            background: rgba(0, 0, 0, 0.5);
            color: white;
            padding: 10px;
            font-size: 2rem;
        }

        .course-section {
            padding: 20px;
            margin: 20px 0;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }

        .course-section h3 {
            font-size: 1.8rem;
            margin-bottom: 20px;
        }

        .course-list {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
            justify-content: space-between;
        }

        .course-item {
            width: 18%;
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 8px;
            padding: 10px;
            text-align: center;
        }

        .course-item img {
            width: 100%;
            height: auto;
            border-radius: 8px;
        }

        .course-item h4 {
            margin-top: 10px;
        }

        .course-item a {
            display: block;
            margin-top: 10px;
            background-color: #4CAF50;
            color: white;
            padding: 10px;
            border-radius: 5px;
            text-decoration: none;
        }

        .course-item a:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<div class="sidebar">
    <h2 style="color: white; text-align: center;">Menu</h2>
    <a href="dashboard.jsp" class="active">Dashboard</a>
    <a href="addCourse.jsp">Add Course</a>
    <a href="courseList.jsp">Course List</a>
    <a href="certifications.jsp">Certifications</a>
    <a href="logout.jsp">Logout</a>
</div>

<div class="main-content">
    <header>
        <h1>Welcome, <%= username != null ? username : "User" %></h1>
        <h2>What would you like to learn today?</h2>
    </header>

    <div class="slider" onclick="window.location.href='enroll.jsp?courseId=1'">
        <h2>Artificial Intelligence - The Most Popular Course</h2>
    </div>

    <% String[] categories = {"Cyber Security", "AI", "Web Development", "Other"};
       List<List<Course>> courses = List.of(cyberSecurityCourses, aiCourses, webDevelopmentCourses, otherCourses);
       for (int i = 0; i < categories.length; i++) { %>
        <div class="course-section">
            <h3><%= categories[i] %> Courses</h3>
            <div class="course-list">
                <% for (Course course : courses.get(i)) { %>
                    <div class="course-item">
                        <img src="images/<%= course.getCourseImage() %>" alt="<%= course.getCourseName() %>">
                        <h4><%= course.getCourseName() %></h4>
                        <a href="enroll.jsp?courseId=<%= course.getCourseId() %>">Enroll Now</a>
                    </div>
                <% } %>
            </div>
        </div>
    <% } %>
</div>

</body>
</html>
