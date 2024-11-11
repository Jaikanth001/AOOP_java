import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateDatabase {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "yourUsername"; // Change to your DB username
        String password = "yourPassword"; // Change to your DB password

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE DATABASE Student";
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}