<%@ page import="com.elearning.db.CourseDAO" %>
<%@ page import="com.elearning.beans.Course" %>

<%
    String courseIdParam = request.getParameter("id");
    int courseId = courseIdParam != null ? Integer.parseInt(courseIdParam) : -1;

    CourseDAO courseDAO = new CourseDAO();
    Course course = courseDAO.getCourseById(courseId);

    if (course == null) {
%>
    <p>Course not found.</p>
<%
    return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><%= course.getCourseName() %> - Course Detail</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f9f9f9;
            padding: 30px;
        }

        .container {
            max-width: 800px;
            margin: auto;
            background: #fff;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            text-align: center;
        }

        iframe {
            width: 100%;
            height: 450px;
            border: none;
            border-radius: 10px;
            margin-top: 20px;
        }

        h2 {
            color: #333;
        }

        .btn {
            margin-top: 25px;
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
            display: inline-block;
        }

        .btn:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<div class="container">
    <h2><%= course.getCourseName() %></h2>

    <iframe src="<%= course.getVideoUrl() %>" allowfullscreen></iframe>

    <a class="btn" href="certifications.jsp">Get Certificate</a>
</div>

</body>
</html>
