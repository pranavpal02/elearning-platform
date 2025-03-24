<%@ page import="java.io.*, java.util.*, java.text.SimpleDateFormat" %>
<%@ page import="javax.servlet.*, javax.servlet.http.*" %>
<%@ page import="com.itextpdf.text.*, com.itextpdf.text.pdf.*" %>
<%@ page import="com.elearning.beans.User, com.elearning.db.CertificateDAO, com.elearning.db.CourseDAO" %>
<%@ page import="com.elearning.beans.Certificate, com.elearning.beans.Course" %>

<%
    response.setContentType("application/pdf");
    response.setHeader("Content-Disposition", "attachment; filename=certificate.pdf");

    // Get the certificate ID from the request
    int certificateId = Integer.parseInt(request.getParameter("id"));

    User user = (User) session.getAttribute("currentUser");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    CertificateDAO certDAO = new CertificateDAO();
    Certificate cert = certDAO.getCertificateById(certificateId);

    CourseDAO courseDAO = new CourseDAO();
    Course course = courseDAO.getCourseById(cert.getCourseId());

    if (cert == null || course == null) {
        out.println("Invalid certificate or course.");
        return;
    }

    OutputStream outStream = response.getOutputStream();
    Document document = new Document();
    PdfWriter.getInstance(document, outStream);

    document.open();

    Font titleFont = new Font(Font.FontFamily.HELVETICA, 22, Font.BOLD, BaseColor.DARK_GRAY);
    Font infoFont = new Font(Font.FontFamily.HELVETICA, 14, Font.NORMAL, BaseColor.BLACK);

    document.add(new Paragraph("Certificate of Completion", titleFont));
    document.add(Chunk.NEWLINE);

    document.add(new Paragraph("This certifies that", infoFont));
    document.add(new Paragraph(user.getFullName(), new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD)));
    document.add(Chunk.NEWLINE);

    document.add(new Paragraph("has successfully completed the course", infoFont));
    document.add(new Paragraph(course.getCourseName(), new Font(Font.FontFamily.HELVETICA, 16, Font.BOLDITALIC)));
    document.add(Chunk.NEWLINE);

    SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
    String certDate = sdf.format(cert.getCertificateDate());
    document.add(new Paragraph("Date of Completion: " + certDate, infoFont));
    document.add(Chunk.NEWLINE);
    document.add(Chunk.NEWLINE);

    document.add(new Paragraph("E-Learning Platform", infoFont));

    document.close();
%>
