package com.StudentManagement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateDatabase {
	public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/";
        String user = "postgres"; // Replace with your PostgreSQL username
        String password = "123"; // Replace with your PostgreSQL password

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            String sql = "CREATE DATABASE Studentweek11;";
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
