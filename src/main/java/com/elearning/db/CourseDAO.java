package com.elearning.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.elearning.beans.Course;

public class CourseDAO {

    // Fetch courses by category
    public List<Course> getCoursesByCategory(String category) {
        List<Course> courses = new ArrayList<>();

        // Validate category to avoid SQL errors
        if (category == null || category.trim().isEmpty()) {
            System.err.println("Invalid category: Cannot be null or empty.");
            return courses; // Return empty list
        }

        String sql = "SELECT * FROM courses WHERE category = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, category);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Course course = new Course();
                    course.setCourseId(rs.getInt("id"));
                    course.setCourseName(rs.getString("name"));
                    course.setCourseImage(rs.getString("image"));
                    course.setCategory(rs.getString("category"));
                    courses.add(course);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error fetching courses: " + e.getMessage());
            e.printStackTrace();
        }
        return courses;
    }

    // Add a new course to the database
    public boolean addCourse(String courseName, String courseImage, String category) {
        String sql = "INSERT INTO courses (name, image, category) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Set the parameters for the course
            stmt.setString(1, courseName);
            stmt.setString(2, courseImage);
            stmt.setString(3, category);

            // Execute the query
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Return true if the course was added successfully
        } catch (SQLException e) {
            System.err.println("Error adding course: " + e.getMessage());
            e.printStackTrace();
            return false; // Return false if there was an error
        }
    }
}
