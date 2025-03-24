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
    <title><%= course.getCourseName() %> - Enroll</title>
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
        }

        .course-image {
            width: 100%;
            max-height: 300px;
            object-fit: cover;
            border-radius: 8px;
        }

        h2 {
            color: #333;
        }

        p {
            font-size: 16px;
            color: #555;
        }

        .btn {
            display: inline-block;
            margin-top: 20px;
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
        }

        .btn:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<div class="container">
    <img src="images/<%= course.getCourseImage() %>" class="course-image" alt="<%= course.getCourseName() %>">
    <h2><%= course.getCourseName() %></h2>
    <p><strong>Category:</strong> <%= course.getCategory() %></p>
    <p><%= course.getDescription() %></p>

    <a class="btn" href="courseDetail.jsp?id=<%= course.getCourseId() %>">Enroll Now</a>
</div>

</body>
</html>
