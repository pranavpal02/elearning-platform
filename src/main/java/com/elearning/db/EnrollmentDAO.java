package com.elearning.db;

import com.elearning.beans.Enrollment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentDAO {

    // Get the courses enrolled by the student and their completion status
    public List<Enrollment> getEnrolledCourses(int userId) throws SQLException {  // Updated parameter name to userId
        List<Enrollment> enrolledCourses = new ArrayList<>();
        String query = "SELECT * FROM enrollments WHERE user_id = ?";  // Changed student_id to user_id

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, userId);  // Set userId to PreparedStatement
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int courseId = rs.getInt("course_id");
                String completionStatus = rs.getString("completion_status");
                enrolledCourses.add(new Enrollment(userId, courseId, completionStatus));  // Use userId instead of studentId
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;  // Rethrow the exception to handle it at the calling level
        }
        return enrolledCourses;
    }

    // Mark course as completed
    public boolean markCourseAsCompleted(int userId, int courseId) {  // Updated parameter name to userId
        String query = "UPDATE enrollments SET completion_status = 'Completed' WHERE user_id = ? AND course_id = ?";  // Changed student_id to user_id

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, userId);  // Set userId in PreparedStatement
            ps.setInt(2, courseId);  // Set courseId

            // Execute the update query and check if any rows were updated
            int result = ps.executeUpdate();
            return result > 0;  // Return true if the update was successful
        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // Return false if there was an error during the update
        }
    }

    // Other methods for handling enrollments could go here...
}
