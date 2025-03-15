package com.elearning.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/elearningdb?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER = "root"; // Change to your MySQL username
    private static final String PASS = "root"; // Change to your MySQL 
    

    public static Connection getConnection() throws SQLException {
    	try {
    	    Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL driver
    	    return DriverManager.getConnection(URL, USER, PASS);
    	} catch (ClassNotFoundException e) {
    	    System.err.println("MySQL JDBC Driver not found: " + e.getMessage());
    	    throw new SQLException("Driver not found", e);
    	} catch (SQLException e) {
    	    System.err.println("Connection failed: " + e.getMessage());
    	    throw e;
    	}

    }
}
