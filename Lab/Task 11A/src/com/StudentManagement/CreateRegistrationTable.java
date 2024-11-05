package com.StudentManagement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class CreateRegistrationTable {
	 public static void main(String[] args) {
	        String url = "jdbc:postgresql://localhost:5432/studentweek11";
	        String user = "postgres"; // Replace with your PostgreSQL username
	        String password = "123"; // Replace with your PostgreSQL password

	        try (Connection conn = DriverManager.getConnection(url, user, password);
	             Statement stmt = conn.createStatement()) {

	            String sql = "CREATE TABLE Registration ("
	                       + "id SERIAL PRIMARY KEY, "
	                       + "name VARCHAR(100), "
	                       + "address VARCHAR(255), "
	                       + "program VARCHAR(100));";
	            stmt.executeUpdate(sql);
	            System.out.println("Registration table created successfully!");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

}
