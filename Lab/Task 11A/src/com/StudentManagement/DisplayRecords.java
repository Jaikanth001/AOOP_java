package com.StudentManagement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayRecords {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/studentweek11";
        String user = "postgres"; // Replace with your PostgreSQL username
        String password = "123"; // Replace with your PostgreSQL password

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            String sql = "SELECT * FROM Registration;";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("ID   " + "Name     "+"Address       "+" Program     ");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String program = rs.getString("program");

                System.out.println(id +"   " + name + "     " + address + "       " + program);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
