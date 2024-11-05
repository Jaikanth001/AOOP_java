package com.StudentManagement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertRecords {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/studentweek11";
        String user = "postgres"; // Replace with your PostgreSQL username
        String password = "123"; // Replace with your PostgreSQL password

        String sql = "INSERT INTO Registration (name, address, program) VALUES (?, ?, ?);";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Insert four records
            pstmt.setString(1, "John Doe");
            pstmt.setString(2, "123 Elm St, Springfield");
            pstmt.setString(3, "Computer Science");
            pstmt.executeUpdate();

            pstmt.setString(1, "Jane Smith");
            pstmt.setString(2, "456 Maple Ave, Springfield");
            pstmt.setString(3, "Business Administration");
            pstmt.executeUpdate();

            pstmt.setString(1, "Alice Johnson");
            pstmt.setString(2, "789 Oak St, Springfield");
            pstmt.setString(3, "Engineering");
            pstmt.executeUpdate();

            pstmt.setString(1, "Bob Brown");
            pstmt.setString(2, "321 Pine Rd, Springfield");
            pstmt.setString(3, "Mathematics");
            pstmt.executeUpdate();

            System.out.println("Records inserted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}