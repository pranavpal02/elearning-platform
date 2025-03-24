package com.elearning.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.elearning.beans.Course;

public class CourseDAO {

    // Fetch all courses from the database
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM courses"; // Ensure 'description' & 'video_url' exist

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Course course = new Course();
                course.setCourseId(rs.getInt("id"));
                course.setCourseName(rs.getString("name"));
                course.setCourseImage(rs.getString("image"));
                course.setCategory(rs.getString("category"));
                course.setDescription(rs.getString("description")); // Fetch description
                course.setVideoUrl(rs.getString("video_url"));      // Fetch video URL
                courses.add(course);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching all courses: " + e.getMessage());
            e.printStackTrace();
        }
        return courses;
    }

    // Fetch a single course by ID
    public Course getCourseById(int courseId) {
        Course course = null;
        String sql = "SELECT * FROM courses WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, courseId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    course = new Course();
                    course.setCourseId(rs.getInt("id"));
                    course.setCourseName(rs.getString("name"));
                    course.setCourseImage(rs.getString("image"));
                    course.setCategory(rs.getString("category"));
                    course.setDescription(rs.getString("description")); // Fetch description
                    course.setVideoUrl(rs.getString("video_url"));      // Fetch video URL
                }
            }
        } catch (SQLException e) {
            System.err.println("Error fetching course by ID: " + e.getMessage());
            e.printStackTrace();
        }
        return course;
    }

    // Fetch courses by category
    public List<Course> getCoursesByCategory(String category) {
        List<Course> courses = new ArrayList<>();

        if (category == null || category.trim().isEmpty()) {
            System.err.println("Invalid category: Cannot be null or empty.");
            return courses;
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
                    course.setCourseImage(rs.getString("course_image"));
                    course.setCategory(rs.getString("category"));
                    course.setDescription(rs.getString("description")); // Fetch description
                    course.setVideoUrl(rs.getString("video_url"));      // Fetch video URL
                    courses.add(course);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error fetching courses by category: " + e.getMessage());
            e.printStackTrace();
        }
        return courses;
    }

    // Add a new course to the database
    public boolean addCourse(String courseName, String courseDescription, String videoUrl, String category) {
        String sql = "INSERT INTO courses (name, description, video_url, category) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, courseName);
            stmt.setString(2, courseDescription);
            stmt.setString(3, videoUrl);
            stmt.setString(4, category);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error adding course: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

}
