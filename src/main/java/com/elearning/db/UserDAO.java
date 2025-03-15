package com.elearning.db;

import com.elearning.beans.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    // Register a new user
    public boolean registerUser(User user) {
        boolean result = false;
        String sql = "INSERT INTO users (username, password, email, role) VALUES (?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());  // In production, hash the password!
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getRole());
            int rows = ps.executeUpdate();
            result = rows > 0;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Login a user: returns a User object if credentials are valid
    public User loginUser(String username, String password) {
        User user = null;
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);  // Again, compare hashed passwords in production!
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    user = new User();
                    user.setUserId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setEmail(rs.getString("email"));
                    user.setRole(rs.getString("role"));
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    // Authenticate user by username and password (updated)
    public User authenticateUser(String username, String password) {
        User user = null;
        String sql = "SELECT * FROM users WHERE username = ?";
        
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Get user details from the database
                    String storedPassword = rs.getString("password");
                    
                    // Compare the provided password with the stored password (hashed in production)
                    if (storedPassword.equals(password)) {  // Plain password comparison (use hashed passwords in production)
                        user = new User();
                        user.setUserId(rs.getInt("id"));
                        user.setUsername(rs.getString("username"));
                        user.setPassword(storedPassword);
                        user.setEmail(rs.getString("email"));
                        user.setRole(rs.getString("role"));
                    }
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
