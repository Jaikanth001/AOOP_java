import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertRecords {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Student";
        String user = "yourUsername"; // Change to your DB username
        String password = "yourPassword"; // Change to your DB password

        String sql = "INSERT INTO Registration (id, name, address, program) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, 100);
            pstmt.setString(2, "John Doe");
            pstmt.setString(3, "123 Elm St");
            pstmt.setString(4, "Computer Science");
            pstmt.executeUpdate();

            pstmt.setInt(1, 101);
            pstmt.setString(2, "Jane Smith");
            pstmt.setString(3, "456 Oak St");
            pstmt.setString(4, "Mathematics");
            pstmt.executeUpdate();

            pstmt.setInt(1, 102);
            pstmt.setString(2, "Alice Johnson");
            pstmt.setString(3, "789 Pine St");
            pstmt.setString(4, "Physics");
            pstmt.executeUpdate();

            pstmt.setInt(1, 103);
            pstmt.setString(2, "Bob Brown");
            pstmt.setString(3, "321 Maple St");
            pstmt.setString(4, "Chemistry");
            pstmt.executeUpdate();

            System.out.println("Records inserted successfully...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}