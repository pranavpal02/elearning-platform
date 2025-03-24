package com.elearning.db;

import com.elearning.beans.Certificate;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CertificateDAO {

    // Get all certificates for a user
    public List<Certificate> getCertificatesByUserId(int userId) {
        List<Certificate> certificates = new ArrayList<>();
        String query = "SELECT * FROM certificates WHERE user_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Certificate certificate = new Certificate(
                    rs.getInt("id"),
                    rs.getInt("user_id"),
                    rs.getInt("course_id"),
                    rs.getString("certificate_date")
                );
                certificates.add(certificate);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return certificates;
    }

    // ✅ Get a single certificate by its ID (new method for downloadCertificate.jsp)
    public Certificate getCertificateById(int id) {
        Certificate certificate = null;
        String query = "SELECT * FROM certificates WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                certificate = new Certificate(
                    rs.getInt("id"),
                    rs.getInt("user_id"),
                    rs.getInt("course_id"),
                    rs.getString("certificate_date")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return certificate;
    }
}
