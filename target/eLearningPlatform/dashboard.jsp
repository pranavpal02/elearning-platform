<%@ page import="java.util.List" %>
<%@ page import="com.elearning.beans.Enrollment" %>
<%@ page import="com.elearning.db.EnrollmentDAO" %>

<%
    // Assuming the user is logged in and their ID is available in session
    int studentId = ((com.elearning.beans.User) session.getAttribute("currentUser")).getUserId();
    EnrollmentDAO enrollmentDAO = new EnrollmentDAO();
    List<Enrollment> enrolledCourses = enrollmentDAO.getEnrolledCourses(studentId);
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Dashboard</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f0f4f8;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 80%;
            margin: 0 auto;
            max-width: 1200px;
        }

        header {
            background-color: #4CAF50;
            padding: 20px;
            color: white;
            text-align: center;
        }

        h2 {
            font-size: 2rem;
            margin-bottom: 20px;
        }

        .content {
            background-color: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        p {
            font-size: 1.1rem;
            color: #555;
        }

        a {
            text-decoration: none;
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }

        a:hover {
            background-color: #45a049;
        }

        footer {
            text-align: center;
            padding: 10px;
            background-color: #f1f1f1;
            margin-top: 20px;
        }

        .logout {
            text-align: right;
            margin-top: 20px;
        }
    </style>
</head>
<body>

    <header>
        <div class="container">
            <h1>Welcome to the eLearning Platform</h1>
        </div>
    </header>

    <div class="container">
        <div class="content">
            <h2>Welcome, <%= ((com.elearning.beans.User) session.getAttribute("currentUser")).getUsername() %>!</h2>
            <p>This is your dashboard. Here you can manage your courses, progress, and more.</p>

            <h3>Your Enrolled Courses:</h3>
            <table>
                <thead>
                    <tr>
                        <th>Course ID</th>
                        <th>Completion Status</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Enrollment enrollment : enrolledCourses) { %>
                        <tr>
                            <td><%= enrollment.getCourseId() %></td>
                            <td><%= enrollment.getCompletionStatus() %></td>
                        </tr>
                    <% } %>
                </tbody>
            </table>

            <div class="logout">
                <p><a href="logout.jsp">Logout</a></p>
            </div>
        </div>
    </div>

    <footer>
        <p>&copy; 2025 eLearning Platform | All Rights Reserved</p>
    </footer>

</body>
</html>
