package com.StudentManagement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateRecords {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/studentweek11";
        String user = "postgres"; // Replace with your PostgreSQL username
        String password = "123"; // Replace with your PostgreSQL password

        String sql = "UPDATE Registration SET program = ? WHERE id = ?;";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "Updated Program 100");
            pstmt.setInt(2, 100);
            pstmt.executeUpdate();

            pstmt.setString(1, "Updated Program 101");
            pstmt.setInt(2, 101);
            pstmt.executeUpdate();

            System.out.println("Records updated successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
