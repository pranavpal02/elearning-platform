package com.elearning.db;

import com.elearning.beans.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public static List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        // Define SQL query to fetch students
        String query = "SELECT id, name, course, learning_mode, status FROM students";

        // Try-with-resources to ensure resources are properly closed
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Loop through the result set and add students to the list
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String course = rs.getString("course");
                String learningMode = rs.getString("learning_mode");
                String status = rs.getString("status");

                // Create a new Student object and add it to the list
                students.add(new Student(id, name, course, learningMode, status));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }
}
