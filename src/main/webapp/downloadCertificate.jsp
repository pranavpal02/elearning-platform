<%@ page import="java.io.*, java.sql.*, com.elearning.db.DBConnection" %>

<%
    int certId = Integer.parseInt(request.getParameter("id"));

    Connection connection = DBConnection.getConnection();
    String query = "SELECT * FROM certificates WHERE id = ?";

    try (PreparedStatement ps = connection.prepareStatement(query)) {
        ps.setInt(1, certId);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            String fileName = "certificate_" + certId + ".pdf"; // Change to actual file name
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);

            // Assuming the certificate is stored as a PDF in the database
            InputStream inputStream = rs.getBinaryStream("certificate_file"); // Adjust column name
            OutputStream outputStream = response.getOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            inputStream.close();
            outputStream.close();
        } else {
            out.println("Certificate not found.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
