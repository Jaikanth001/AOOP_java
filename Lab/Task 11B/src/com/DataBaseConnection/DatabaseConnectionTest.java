package com.DataBaseConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionTest {
	public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:postgresql://localhost:5432/testjava"; // Database URL
        String user = "postgres";                        // Replace with your PostgreSQL username
        String password = "123";                    // Replace with your PostgreSQL password

        // Try connecting to the database
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to the database");
        } catch (SQLException e) {
            // Check if the error is due to invalid credentials
            if (e.getSQLState().equals("28000")) {  // PostgreSQL error code for invalid authorization
                System.out.println("Invalid username or password");
            } else {
                e.printStackTrace();
            }
        }
    }

}
