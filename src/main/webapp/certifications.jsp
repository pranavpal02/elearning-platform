<%@ page import="java.util.List" %>
<%@ page import="com.elearning.beans.Certificate" %>
<%@ page import="com.elearning.db.CertificateDAO" %>
<%@ page import="com.elearning.db.CourseDAO" %>
<%@ page import="com.elearning.beans.Course" %>

<%
    com.elearning.beans.User currentUser = (com.elearning.beans.User) session.getAttribute("currentUser");

    if (currentUser == null) {
        response.sendRedirect("login.jsp"); // Redirect to login page if not logged in
        return;
    }

    int userId = currentUser.getUserId();
    CertificateDAO certificateDAO = new CertificateDAO();
    List<Certificate> certificates = certificateDAO.getCertificatesByUserId(userId);

    CourseDAO courseDAO = new CourseDAO();
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Certifications</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f0f4f8;
            margin: 0;
            padding: 20px;
        }

        .container {
            max-width: 800px;
            margin: auto;
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            color: #4CAF50;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        .download-btn {
            padding: 5px 10px;
            background: #1abc9c;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }

        .download-btn:hover {
            background: #16a085;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>My Certifications</h2>

    <table>
        <thead>
            <tr>
                <th>Course Name</th>
                <th>Certificate Date</th>
                <th>Download</th>
            </tr>
        </thead>
        <tbody>
            <% if (certificates.isEmpty()) { %>
                <tr>
                    <td colspan="3" style="text-align:center;">No certifications available</td>
                </tr>
            <% } else {
                for (Certificate cert : certificates) {
                    Course course = courseDAO.getCourseById(cert.getCourseId());
            %>
                <tr>
                    <td><%= course != null ? course.getCourseName() : "Unknown Course" %></td>
                    <td><%= cert.getCertificateDate() %></td>
                    <td>
                        <a href="downloadCertificate.jsp?id=<%= cert.getId() %>" class="download-btn">Download</a>
                    </td>
                </tr>
            <% } } %>
        </tbody>
    </table>

</div>

</body>
</html>
